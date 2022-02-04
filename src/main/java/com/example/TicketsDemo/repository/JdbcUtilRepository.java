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
        Long existeUsuarioConMismoCorreo = obtenerIdUsuarioPorCorreo(user.getCorreo());
        System.out.println(existeUsuarioConMismoCorreo);
        if (existeUsuarioConMismoCorreo.equals(0) || existeUsuarioConMismoCorreo==0L || existeUsuarioConMismoCorreo==null){
            int estado = jdbcTemplate.update("insert into Usuarios(contrasena,rol,correo,nombre,disponible) values(?,?,?,?,?)",user.getContrasena(),user.getRol()
                    ,user.getCorreo(),user.getNombre(),1);
            return estado==1;

        }else{
            return false;
        }
    }
    public Long obtenerIdUsuarioPorCorreo(String correo){
        try{
            System.out.println(jdbcTemplate.queryForObject("select idUsuario from Usuarios where correo=? limit 1",new Object[]{correo},Long.class));
            return jdbcTemplate.queryForObject("select idUsuario from Usuarios where correo=? limit 1",new Object[]{correo},Long.class);
        }catch (Exception e) {
            System.out.println("No se encontro el usuario " + e);
            return 0L;
        }
    }

    public boolean existeNumTicket(String numTicket){
        int existe = jdbcTemplate.queryForObject("select count(1) from Tickets where numTicket=?",new Object[]{numTicket},Integer.class);
        return existe==1;
    }

    public boolean registrarTicket(Ticket ticket){
        int estado = jdbcTemplate.update("insert into Tickets(idCliente,tipoSoporte,idPrioridad,numTicket,descripcionSoporte,estado) values(?,?,?,?,?,?)",
                ticket.getIdCliente(),ticket.getTipoSoporte(),ticket.getIdPrioridad(),ticket.getNumTicket(),ticket.getDescripcion(),ticket.getEstado());
        return estado==1;
    }

    public List<Ticket> obtenerTicketsHechosPorUnUsuario(String correo){
        Long idUsuario = obtenerIdUsuarioPorCorreo(correo);
        if (idUsuario!=0){
            String sql = "select * from Tickets T inner join Prioridad P on T.idPrioridad=P.idPrioridad where T.idCliente="+idUsuario;
            return jdbcTemplate.query(sql,(rs,rowNum)->
                    new Ticket(
                            rs.getLong("idTicket"),
                            rs.getLong("idCliente"),
                            rs.getString("tipoSoporte"),
                            rs.getLong("idPrioridad"),
                            rs.getString("numTicket"),
                            rs.getString("descripcion"),
                            rs.getInt("estado")
                    ));
        }else{
            System.out.println("No se encontro el usuario " + correo);
            return null;
        }
    }


}
