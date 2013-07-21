package com.icode.core.transaction;

import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-21
 * Time: 下午9:49
 */
public class WorkerFactoryContext {
    private Worker worker;

    public WorkerFactoryContext(Worker worker) {
        this.worker = worker;
    }

    public Worker getWorker() {
        return worker;
    }

    public static WorkerFactoryContext getContext(WorkerFactory workerFactory) {
        if (TransactionSynchronizationManager.isSynchronizationActive() && TransactionSynchronizationManager.hasResource(workerFactory)) {
            WorkerFactoryContext context = (WorkerFactoryContext) TransactionSynchronizationManager.getResource(workerFactory);
            if (context == null) {
                throw new IllegalStateException("Null WorkerFactoryContext bound as transactional resource");
            }
            return context;
        }
        throw new IllegalStateException("Can not access WorkerFactoryContext when transaction synchronization");
    }
}
