package com.icode.core.transaction;

import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-21
 * Time: 下午10:17
 */
public class WorkTransactionSynchronization extends TransactionSynchronizationAdapter {
    private WorkerFactory workerFactory;

    public WorkTransactionSynchronization(WorkerFactory workerFactory) {
        this.workerFactory = workerFactory;
    }

    @Override
    public void afterCompletion(int status) {
        if (!TransactionSynchronizationManager.hasResource(this.workerFactory)) {
            throw new IllegalStateException("Required synchronization resource missing under key");
        }
        WorkerFactoryContext context = WorkerFactoryContext.getContext(this.workerFactory);
        Worker worker = context.getWorker();
        try {
            if (STATUS_COMMITTED == status) {
                worker.commit();
            } else {
                worker.rollback();
            }
        } finally {
            TransactionSynchronizationManager.unbindResource(this.workerFactory);
        }
    }
}
