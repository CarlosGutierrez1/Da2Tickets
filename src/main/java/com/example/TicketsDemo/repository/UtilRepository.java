package com.example.TicketsDemo.repository;

import com.example.TicketsDemo.model.Cliente;
import com.example.TicketsDemo.model.Ticket;
import com.example.TicketsDemo.model.Usuario;

import java.util.List;

public interface UtilRepository {
    public Boolean registrarUsuarioCliente(Cliente cliente, Long idUsuario);
    public Boolean registrarUsuario(Usuario user);
    public Long obtenerIdUsuarioPorCorreo(String correo);
    public boolean existeNumTicket(String numTicket);
    public boolean registrarTicket(Ticket ticket);

}
