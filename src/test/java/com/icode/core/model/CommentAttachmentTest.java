package com.icode.core.model;

import com.icode.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.web.multipart.MultipartFile;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-31
 * Time: 下午4:39
 */
@ContextConfiguration(locations = {"classpath:rootApplicationContext.xml"})
public class CommentAttachmentTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private ShopService shopService;

    @Test
    public void testCreateAttachment() throws Exception {
        Resource resource = new ClassPathResource("PROPAGATION.et");
        MultipartFile multipartFile = new MockMultipartFile("PROPAGATION.et", resource.getInputStream());
        CommentAttachment attachment = new CommentAttachment(multipartFile);
        shopService.saveOrUpdateAttachment(attachment);

        attachment = shopService.loadCommentAttachment(attachment.getGuid());

        Assert.assertNotNull(attachment.getContents());
    }
}
