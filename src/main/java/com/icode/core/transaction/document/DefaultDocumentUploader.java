package com.icode.core.transaction.document;

import com.icode.core.model.Document;
import com.icode.dao.DocumentDao;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-22
 * Time: 下午1:21
 */
public class DefaultDocumentUploader implements DocumentUploader {
    private static final Log LOG = LogFactory.getLog(DefaultDocumentUploader.class);

    private DocumentDao documentDao;
    private Document document;
    private transient File file;

    public DefaultDocumentUploader(DocumentDao documentDao, Document document) {
        this.documentDao = documentDao;
        this.document = document;
    }

    @Override
    public String upload() {
        File file = new File("../upload/", document.getName());
        this.file = file;
        try {
            FileUtils.writeByteArrayToFile(file, document.getContent());
        } catch (IOException e) {
            throw new UnsupportedOperationException("Not yet implemented!");
        }
        String path = file.getPath();
        document.setPath(path);
        documentDao.saveOrUpdate(document);
        ruin();
        LOG.debug("The path of uploaded file is " + file.getAbsolutePath());
        return path;
    }

    private void ruin() {
        throw new UnsupportedOperationException("Not yet implemented!");
    }

    @Override
    public void commit() {
        LOG.debug("COMMIT: The file has been saved on the disk of server~~~");
    }

    @Override
    public void rollback() {
        if (file.delete()) {
            LOG.debug("ROLLBACK: The file has been deleted from the disk of server~~~");
        }
    }
}
