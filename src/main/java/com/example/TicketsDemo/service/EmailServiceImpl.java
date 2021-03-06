package com.example.TicketsDemo.service;

import com.example.TicketsDemo.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{
    @Autowired
    private JavaMailSender mailSender;

    public void enviarEmailSimple(Email email){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(email.getSentFrom());
        message.setTo(email.getToEmail());
        message.setText(email.getBody());
        message.setSubject(email.getSubject());
        mailSender.send(message);
    }

}
