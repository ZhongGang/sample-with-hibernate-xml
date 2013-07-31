package com.icode.core.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-31
 * Time: 下午4:37
 */
@Entity
@Table(name = "comment_attachment")
public class CommentAttachment extends AbstractEntity {

    private String name;

    private String type;

    @Lob
    @Column(columnDefinition = "blob")
    private byte[] contents;

    @Lob
    @Column(columnDefinition = "text")
    private String description;

    public CommentAttachment() {
    }

    public CommentAttachment(MultipartFile multipartFile) throws IOException {
        this.name = multipartFile.getName();
        this.type = multipartFile.getContentType();
        this.contents = multipartFile.getBytes();
        this.description = "The description of " + this.name;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public byte[] getContents() {
        return contents;
    }
}
