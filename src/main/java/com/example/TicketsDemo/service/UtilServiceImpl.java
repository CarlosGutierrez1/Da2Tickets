package com.example.TicketsDemo.service;

import com.example.TicketsDemo.model.*;
import com.example.TicketsDemo.repository.UtilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class UtilServiceImpl implements UtilService{
    @Autowired
    UtilRepository utilRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    EmailService emailService;

    public Boolean registrarCliente(Cliente cliente){
        Usuario user = new Usuario(passwordEncoder.encode(cliente.getContrasena()),"ROL_C",cliente.getCorreo(),cliente.getNombre(),1);
        boolean b = utilRepository.registrarUsuario(user);
        if(b){
            Long idUsuario = utilRepository.obtenerIdUsuarioPorCorreo(cliente.getCorreo());
            if (idUsuario!=0L){
                return utilRepository.registrarUsuarioCliente(cliente,idUsuario);
            }else{
                return false;
            }
        }else{
            return false;
        }

    }
    public Boolean registrarAdministracion(Administracion adminis){
        Usuario user = new Usuario(passwordEncoder.encode(adminis.getContrasena()),adminis.getRol(),adminis.getCorreo(),adminis.getNombre(),1);
        boolean b = utilRepository.registrarUsuario(user);
        if(b){
            Long idUsuario = utilRepository.obtenerIdUsuarioPorCorreo(adminis.getCorreo());
            if (idUsuario!=0L){
                return utilRepository.registrarUsuarioAdministracion(adminis,idUsuario);
            }else{
                return false;
            }
        }else{
            return false;
        }

    }

    public String generadorRandomTicket(){
        String numeros = "1234567890";
        int tamanoDelTicket = 20;
        boolean existe=true;
        StringBuilder sb= new StringBuilder(tamanoDelTicket);
        while (existe) {
            sb.setLength(0);
            for (int i = 0; i < tamanoDelTicket; i++) {
                int posicionRandom = (int) (numeros.length() * Math.random());
                sb.append(numeros.charAt(posicionRandom));
            }
            existe=verificarSiNumTicketExiste(sb.toString());
        }
        System.out.println("Este es el ticket "+sb);
        return sb.toString();
    }
    public boolean verificarSiNumTicketExiste(String numTicket){
        return utilRepository.existeNumTicket(numTicket);
    }
    public boolean registrarTicket(Ticket ticket,String correoUsuario){
        Long idCliente = utilRepository.obtenerIdUsuarioPorCorreo(correoUsuario);
        ticket.setNumTicket(generadorRandomTicket());
        ticket.setEstado(0);
        ticket.setPrioridad(utilRepository.obtenerTipoPrioridadPorId(ticket.getIdPrioridad()));
        ticket.setFechayhora(obtenerFechaYhoraActual());
        if (idCliente!=0L){ticket.setIdCliente(idCliente);}
        else{return false;}
        enviarEmailConTicket(ticket,correoUsuario);
//        if(utilRepository.registrarTicket(ticket)){
//            return ticket;
//        }else{ return tr;}
        return utilRepository.registrarTicket(ticket);

    }
    public void enviarEmailConTicket(Ticket ticket, String correoUsuario){
        String body = "Su solicitud de soporte hecha desde el correo: "+correoUsuario+" fue correctamente generada. \n"+
                "Los detalles son: \n"+"Tipo de soporte: "+ticket.getTipoSoporte()+"\nPrioridad: "+ticket.getPrioridad()+"\n"+
                "Ticket #"+ticket.getNumTicket()+"\n"+"Descripcion: "+ticket.getDescripcion()+"\n";
        String subject = "Solicitud linea de soporte grupo Da2";
        Email email = new Email(correoUsuario,body,subject);
        try{
            emailService.enviarEmailSimple(email);
        }catch (Exception e){
            System.out.println("Error enviando email... Detalle -> " +e);
        }

    }
    public void enviarEmailPersonalizado(Email email ){
        try{
            emailService.enviarEmailSimple(email);
        }catch (Exception e){
            System.out.println("Error enviando email... Detalle -> " +e);
        }
    }
    public String obtenerRolUsuarioPorCorreo(String correo){
        return utilRepository.obtenerRolUsuarioPorCorreo(correo);
    }
    public List<Administracion> obtenerTodosLosTecnicos(){
        return utilRepository.obtenerTodosLosTecnicos();
    }
    public List<Ticket> obtenerTicketsHechosPorUnUsuario(String correo){
        List<Ticket> tickets = utilRepository.obtenerTicketsHechosPorUnUsuario(correo);
        for (int i = 0; i < tickets.size(); i++) {
            tickets.get(i).setCreador(correo);
            if (tickets.get(i).getEstado()==0){tickets.get(i).setEstadoLetras("Abierto");}
            else if(tickets.get(i).getEstado()==2){tickets.get(i).setEstadoLetras("Asignado");}
            else{tickets.get(i).setEstadoLetras("Cerrado");}
        }
        return tickets;
    }
    public List<Ticket> obtenerTodosLosTiketsConEstadoDisponible(){
        List<Ticket> tickets = utilRepository.obtenerTodosLosTiketsConEstadoDisponible();
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getEstado()==0){tickets.get(i).setEstadoLetras("Abierto");}
            else if(tickets.get(i).getEstado()==2){tickets.get(i).setEstadoLetras("Asignado");}
            else{tickets.get(i).setEstadoLetras("Cerrado");}
        }
        return tickets;
    }
    public List<Ticket> obtenerTicketsAsignadosATecnico(String correo){
        Long id = utilRepository.obtenerIdUsuarioPorCorreo(correo);
        List<Ticket> tickets = utilRepository.obtenerTicketsAsignadosATecnico(id);
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getEstado()==0){tickets.get(i).setEstadoLetras("Abierto");}
            else if(tickets.get(i).getEstado()==2){tickets.get(i).setEstadoLetras("Asignado");}
            else{tickets.get(i).setEstadoLetras("Cerrado");}
        }
        return tickets;
    }

    public Ticket obtenerTicketPorIdTicket(Long idTicket){
        List<Ticket> t = utilRepository.obtenerTicketPorIdTicket(idTicket);
        if (t.get(0).getEstado()==0){t.get(0).setEstadoLetras("Abierto");}
        else if(t.get(0).getEstado()==2){t.get(0).setEstadoLetras("Asignado");}
        else{t.get(0).setEstadoLetras("Cerrado");}
        return t.get(0);
    }
    public String obtenerTipoPrioridadPorId(Long idPrioridad){
        return utilRepository.obtenerTipoPrioridadPorId(idPrioridad);
    }
    public Ticket obtenerTicketPorNumTicket(String numTicket){
        List<Ticket> t = utilRepository.obtenerTicketPorNumTicket(numTicket);
        if (t.size()==0 || t.isEmpty()){
            return null;
        }else{
            if (t.get(0).getEstado()==0){t.get(0).setEstadoLetras("Abierto");}
            else if (t.get(0).getEstado()==2){t.get(0).setEstadoLetras("Asignado");}
            else{t.get(0).setEstadoLetras("Cerrado");}
            return t.get(0);
        }
    }
    public boolean asignarTecnicoATicket(Long idTecnico, Long idTicket){
        return utilRepository.asignarTecnicoATicket(utilRepository.obtenerIdUsuarioPorIdAdministracion(idTecnico),idTicket);
    }
    public boolean marcarTicketComoResuelto(Long idTicket){
        if(utilRepository.marcarTicketComoResuelto(idTicket)){
            List<Ticket> t = utilRepository.obtenerTicketPorIdTicket(idTicket);
            String correoCliente = utilRepository.obtenerCorreoClientePorIdTicket(t.get(0).getIdTicket());
            String body = "El ticket#"+t.get(0).getNumTicket()+" con detalles: \n"+
                    "Prioridad: "+t.get(0).getPrioridad()+"\n"+
                    "Tipo de soporte: "+t.get(0).getTipoSoporte()+"\n"+
                    "Descripcion: "+t.get(0).getDescripcion()+"\n"+
                    "Fue correctamente resuelto";
            String subject = "Solicitud linea de soporte grupo Da2";

            Email e = new Email(correoCliente,body,subject);
            enviarEmailPersonalizado(e);
            return true;
        }else{ return false;}
    }

    public String obtenerFechaYhoraActual(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return (dtf.format(now));
    }
}
