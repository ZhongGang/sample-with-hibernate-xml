package com.icode.core.transaction.document;

import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-22
 * Time: 下午1:25
 */
public class DocumentUploaderTransactionSynchronization extends TransactionSynchronizationAdapter {
    private DocumentUploaderFactory factory;

    public DocumentUploaderTransactionSynchronization(DocumentUploaderFactory factory) {
        this.factory = factory;
    }

    @Override
    public void afterCompletion(int status) {
        if (!TransactionSynchronizationManager.hasResource(this.factory)) {
            throw new IllegalStateException("Required synchronization resource missing under key");
        }
        DocumentUploaderContext context = DocumentUploaderContext.getContext(this.factory);
        DocumentUploader uploader = context.getUploader();
        try {
            if (STATUS_COMMITTED == status) {
                uploader.commit();
            } else {
                uploader.rollback();
            }
        } finally {
            TransactionSynchronizationManager.unbindResource(this.factory);
        }
    }
}
