package com.icode.service.impl;

import com.icode.core.model.Document;
import com.icode.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.web.multipart.MultipartFile;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-22
 * Time: 下午1:59
 */
@ContextConfiguration(locations = "classpath:rootApplicationContext.xml")
public class DocumentServiceImplTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private DocumentService documentService;

    @Test
    @Rollback(value = false)
    public void testUpload() throws Exception {
        File file = new File("F:\\draft-ietf-oauth-v2-31.pdf");
        FileInputStream inputStream = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile("draft-ietf-oauth-v2-31.pdf", inputStream);
        Document document = new Document(multipartFile.getName(), multipartFile.getBytes());
        documentService.upload(document);

    }

    @Test
    public void testConfigurable() throws Exception {
        Document document = new Document();

        Assert.assertNotNull(document.getDocumentDao());
    }
}
