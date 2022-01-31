package com.example.TicketsDemo.service;

import com.example.TicketsDemo.model.Cliente;
import com.example.TicketsDemo.model.Ticket;
import com.example.TicketsDemo.model.Usuario;

import java.util.List;

public interface UtilService {
    public Boolean registrarCliente(Cliente cliente);
    public String generadorRandomTicket();
    public boolean verificarSiNumTicketExiste(String numTicket);
    public boolean registrarTicket(Ticket ticket,String correoUsuario);
    public void enviarEmailConTicket(Ticket ticket, String correoUsuario);

}
