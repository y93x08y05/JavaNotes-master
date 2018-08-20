package com.jack.basic.Other1;

import java.util.Properties;

import javax.mail.*;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

/**
 * Created by zhangta on 1/26/2018.
 * 当用的代理是国外时，邮件是无法发送的
 * 切换回国内的网络，则邮件是可以发送的
 */
public class sendMailTest {
    public  static  void  main (String [] args) throws AddressException,MessagingException {
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.qq.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.debug", "true");
        Session mailSession = Session.getInstance(props);
        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress("1064807182@qq.com"));
        message.setRecipient(RecipientType.TO,
                new InternetAddress("190065838@qq.com"));
        message.setSubject("测试邮件");
        message.setContent("这是一封测试邮件", "text/html;charset=UTF-8");
        Transport transport = mailSession.getTransport();
        transport.connect("1064807182@qq.com", "zwvqdvmuwrbubdaj");
        transport.sendMessage(message, message.getAllRecipients());
    }
}
