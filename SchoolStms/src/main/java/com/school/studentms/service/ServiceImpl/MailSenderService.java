package com.school.studentms.service.ServiceImpl;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService {
    @Autowired
    private JavaMailSender mailSender;

    public  void sendNewMail(String to, String subject, String body) throws MessagingException {
       /* SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message); */

        MimeMessage message = mailSender.createMimeMessage();


        message.setRecipients(MimeMessage.RecipientType.TO, to);
        message.setSubject(subject);


        message.setContent(body, "text/html; charset=utf-8");

        mailSender.send(message);
    }
}
