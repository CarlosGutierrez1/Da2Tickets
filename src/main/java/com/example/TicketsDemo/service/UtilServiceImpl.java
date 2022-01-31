package com.example.TicketsDemo.service;

import com.example.TicketsDemo.model.Cliente;
import com.example.TicketsDemo.model.Email;
import com.example.TicketsDemo.model.Ticket;
import com.example.TicketsDemo.model.Usuario;
import com.example.TicketsDemo.repository.UtilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


}
