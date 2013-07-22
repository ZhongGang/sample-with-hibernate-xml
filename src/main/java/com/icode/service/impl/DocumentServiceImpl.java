package com.icode.service.impl;

import com.icode.core.model.Document;
import com.icode.core.transaction.document.DocumentUploader;
import com.icode.core.transaction.document.DocumentUploaderFactory;
import com.icode.dao.DocumentDao;
import com.icode.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-22
 * Time: 上午11:19
 */
@Service("documentService")
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentDao documentDao;

    @Autowired
    private DocumentUploaderFactory documentUploaderFactory;

    @Override
    @Transactional
    public void upload(Document document) {
        DocumentUploader uploader = documentUploaderFactory.create(documentDao, document);
        uploader.upload();
    }
}
