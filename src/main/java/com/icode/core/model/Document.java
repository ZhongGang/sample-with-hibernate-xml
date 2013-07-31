package com.icode.core.model;

import com.icode.dao.DocumentDao;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-22
 * Time: 上午11:14
 */
@Entity
@Table
@Configurable(autowire = Autowire.BY_NAME, preConstruction = true)
public class Document extends AbstractEntity {
    private String name;
    private String path;
    private transient byte[] content;

    @Autowired
    @Transient
    private DocumentDao documentDao;

    public Document(String name, byte[] content) {
        this.name = name;
        this.content = content;
    }

    public Document() {

    }

    public DocumentDao getDocumentDao() {
        return documentDao;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public byte[] getContent() {
        return content;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
