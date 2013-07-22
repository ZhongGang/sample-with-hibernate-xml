package com.icode.core.transaction.document;

import com.icode.core.model.Document;
import com.icode.dao.DocumentDao;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-22
 * Time: 下午1:21
 */
public interface DocumentUploaderFactory {

    DocumentUploader create(DocumentDao documentDao, Document document);
}
