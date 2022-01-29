package com.example.TicketsDemo.service;

import com.example.TicketsDemo.model.Email;
import org.springframework.context.annotation.Bean;

public interface EmailService {
    public void enviarEmailSimple(Email email);
}
