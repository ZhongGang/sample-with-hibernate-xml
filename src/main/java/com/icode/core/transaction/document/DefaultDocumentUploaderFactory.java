package com.icode.core.transaction.document;

import com.icode.core.model.Document;
import com.icode.dao.DocumentDao;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-22
 * Time: 下午1:22
 */
@Component("documentUploaderFactory")
public class DefaultDocumentUploaderFactory implements DocumentUploaderFactory {

    @Override
    public DocumentUploader create(DocumentDao documentDao, Document document) {
        if (TransactionSynchronizationManager.hasResource(this)) {
            return getTransactionBoundWorker();
        } else {
            return createNewTransactionBoundWorker(documentDao, document);
        }
    }

    private DocumentUploader createNewTransactionBoundWorker(DocumentDao documentDao, Document document) {
        DocumentUploader uploader = new DefaultDocumentUploader(documentDao, document);
        DocumentUploaderContext context = new DocumentUploaderContext(uploader);
        TransactionSynchronization synchronization = new DocumentUploaderTransactionSynchronization(this);
        TransactionSynchronizationManager.registerSynchronization(synchronization);
        TransactionSynchronizationManager.bindResource(this, context);
        return uploader;
    }

    public DocumentUploader getTransactionBoundWorker() {
        DocumentUploaderContext context = (DocumentUploaderContext) TransactionSynchronizationManager.getResource(this);
        return context.getUploader();
    }
}
