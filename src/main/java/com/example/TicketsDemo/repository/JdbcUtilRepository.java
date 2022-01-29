package com.example.TicketsDemo.repository;

import com.example.TicketsDemo.model.Cliente;
import com.example.TicketsDemo.model.Ticket;
import com.example.TicketsDemo.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class JdbcUtilRepository implements UtilRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Boolean registrarUsuarioCliente(Cliente cliente,Long idUsuario){
        int estado = jdbcTemplate.update("insert into Clientes(idUsuario,numDoc, tipoDoc,empresa,cargo) values(?,?,?,?,?)",idUsuario,cliente.getNumDoc(),
                cliente.getTipoDoc(),cliente.getEmpresa(),cliente.getCargo());
        return estado==1;
    }

    public Boolean registrarUsuario(Usuario user){
        int estado = jdbcTemplate.update("insert into Usuarios(contrasena,rol,correo,nombre,disponible) values(?,?,?,?,?)",user.getContrasena(),user.getRol()
                ,user.getCorreo(),user.getNombre(),1);
        return estado==1;
    }
    public Long obtenerIdUsuarioPorCorreo(String correo){
        try{
            return jdbcTemplate.queryForObject("select idUsuario from Usuarios where correo=? limit 1",new Object[]{correo},Long.class);
        }catch (Exception e) {
            System.out.println("No se encontro el usuario");
            return 0L;
        }
    }

    public boolean existeNumTicket(String numTicket){
        int existe = jdbcTemplate.queryForObject("select count(1) from Tickets where numTicket=?",new Object[]{numTicket},Integer.class);
        return existe==1;
    }

    public boolean registrarTicket(Ticket ticket){
        int estado = jdbcTemplate.update("insert into Tickets(idCliente,tipoSoporte,prioridad,numTicket,descripcionSoporte,estado) values(?,?,?,?,?,?)",
                ticket.getIdCliente(),ticket.getTipoSoporte(),ticket.getPrioridad(),ticket.getNumTicket(),ticket.getDescripcion(),ticket.getEstado());
        return estado==1;
    }



}
