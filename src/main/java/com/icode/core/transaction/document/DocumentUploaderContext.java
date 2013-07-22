package com.icode.core.transaction.document;

import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-22
 * Time: 下午1:23
 */
public class DocumentUploaderContext {
    private DocumentUploader uploader;

    public DocumentUploaderContext(DocumentUploader uploader) {
        this.uploader = uploader;
    }

    public DocumentUploader getUploader() {
        return uploader;
    }

    public static DocumentUploaderContext getContext(DocumentUploaderFactory factory) {
        if (TransactionSynchronizationManager.isSynchronizationActive() && TransactionSynchronizationManager.hasResource(factory)) {
            DocumentUploaderContext context = (DocumentUploaderContext) TransactionSynchronizationManager.getResource(factory);
            if (context == null) {
                throw new IllegalStateException("Null DocumentUploaderContext bound as transactional resource");
            }
            return context;
        }
        throw new IllegalStateException("Can not access DocumentUploaderContext when transaction synchronization");
    }
}
