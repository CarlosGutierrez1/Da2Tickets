package com.example.TicketsDemo.service;

import com.example.TicketsDemo.model.Administracion;
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
    public List<Ticket> obtenerTicketsHechosPorUnUsuario(String correo);
    public List<Ticket> obtenerTodosLosTiketsConEstadoDisponible();
    public String obtenerRolUsuarioPorCorreo(String correo);
    public List<Ticket> obtenerTicketsAsignadosATecnico(String correo);
    public Ticket obtenerTicketPorIdTicket(Long idTicket);
    public String obtenerTipoPrioridadPorId(Long idPrioridad);
    public Ticket obtenerTicketPorNumTicket(String numTicket);
    public Boolean registrarAdministracion(Administracion adminis);
    public List<Administracion> obtenerTodosLosTecnicos();
    public boolean asignarTecnicoATicket(Long idTecnico, Long idTicket);
    public boolean marcarTicketComoResuelto(Long idTicket);

}
