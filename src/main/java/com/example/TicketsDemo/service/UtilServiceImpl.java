package com.example.TicketsDemo.service;

import com.example.TicketsDemo.model.Ticket;
import com.example.TicketsDemo.model.Usuario;
import com.example.TicketsDemo.repository.UtilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UtilServiceImpl implements UtilService{
    @Autowired
    UtilRepository utilRepository;

//    @Transactional(readOnly = true)
//    public List<Usuario> obtenerUsuarioConCredenciales(Usuario user){
//        return utilRepository.obtenerUsuarioConCredenciales(user);
//    }
//    @Transactional(readOnly = true)
//    public String registrarTicket(Ticket ticket){
//        return utilRepository.registrarTicket(ticket);
//    }


}
