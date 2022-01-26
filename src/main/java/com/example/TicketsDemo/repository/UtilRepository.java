package com.example.TicketsDemo.repository;

import com.example.TicketsDemo.model.Ticket;
import com.example.TicketsDemo.model.Usuario;

import java.util.List;

public interface UtilRepository {
    public List<Usuario> obtenerUsuarioConCredenciales(Usuario user);
    public String registrarTicket(Ticket ticket);
}
