package com.ligh.test;

import com.ligh.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by ${ligh} on 2018/12/7 上午9:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSpringbootEmail {

    @Resource
    MailService mailService;

    /**
     *  简单文本邮件发送
     */
    @Test
    public void sendSimpleMailTest(){
        mailService.sendSimpleMail("liguohui@huluwa.cc","简单文本邮件","这是我的第一封邮件,哈哈...");
    }

    /**
     *  HTML邮件发送
     *
     * @throws Exception
     */
    @Test
    public void sendHtmlMailTest() throws Exception{
        String content = "<html>\n"+
                        "<body>\n" +
                            "<h1 style=\"color: red\"> hello world , 这是一封HTML邮件</h1>"+
                        "</body>\n"+
                        "</html>";


        mailService.sendHtmlMail("liguohui@huluwa.cc","Html邮件发送",content);
    }

    @Test
    public void sendAttachmentMailTest() throws Exception{
        String filepath = "/Users/fish/Desktop/linux 常用命令.pdf";

        mailService.sendAttachmentMail("liguohui@huluwa.cc","发送副本","这是一篇带附件的邮件",filepath);


    }

}
