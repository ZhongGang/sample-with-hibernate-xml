package com.icode.core.transaction;

import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-21
 * Time: 下午9:48
 */
@Component
public class TransactionAwareWorkerFactory implements WorkerFactory {

    @Override
    public Worker create() {
        if (TransactionSynchronizationManager.hasResource(this)) {
            return getTransactionBoundWorker();
        } else {
            return createNewTransactionBoundWorker();
        }
    }

    private Worker createNewTransactionBoundWorker() {
        Worker worker = new DefaultWorker(20);
        WorkerFactoryContext context = new WorkerFactoryContext(worker);
        TransactionSynchronization synchronization = new WorkTransactionSynchronization(this);
        TransactionSynchronizationManager.registerSynchronization(synchronization);
        TransactionSynchronizationManager.bindResource(this, context);
        return worker;
    }

    public Worker getTransactionBoundWorker() {
        WorkerFactoryContext context = (WorkerFactoryContext) TransactionSynchronizationManager.getResource(this);
        return context.getWorker();
    }
}
