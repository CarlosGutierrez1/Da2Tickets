package com.example.TicketsDemo.repository;

import com.example.TicketsDemo.model.Administracion;
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
    public String obtenerRolUsuarioPorCorreo(String correo);
    public List<Ticket> obtenerTicketsHechosPorUnUsuario(String correo);
    public List<Ticket> obtenerTodosLosTiketsConEstadoDisponible();
    public List<Ticket> obtenerTicketsAsignadosATecnico(Long idTecnico);
    public List<Ticket> obtenerTicketPorIdTicket(Long idTicket);
    public String obtenerTipoPrioridadPorId(Long idPrioridad);
    public List<Ticket> obtenerTicketPorNumTicket(String numTicket);
    public Boolean registrarUsuarioAdministracion(Administracion adminis, Long idUsuario);
    public List<Administracion> obtenerTodosLosTecnicos();
    public boolean asignarTecnicoATicket(Long idTecnico, Long idTicket);
    public Long obtenerIdUsuarioPorIdAdministracion(Long idAdministracion);
    public boolean marcarTicketComoResuelto(Long idTicket);
    public String obtenerCorreoClientePorIdUsuario(Long idUsuario);
    public String obtenerCorreoClientePorIdTicket(Long idTicket);

}
