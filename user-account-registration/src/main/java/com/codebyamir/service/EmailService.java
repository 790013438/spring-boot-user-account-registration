package com.codebyamir.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service("emailService")
public class EmailService {

    private JavaMailSender mailSender;
    @Value("${mail.fromMail.address}")
    private String fromMail;

    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Async
    public void sendEmail(SimpleMailMessage simpleMailMessage) {
        simpleMailMessage.setFrom(fromMail);
        mailSender.send(simpleMailMessage);
    }
}
