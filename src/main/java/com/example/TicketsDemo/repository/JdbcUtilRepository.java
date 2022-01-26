package com.example.TicketsDemo.repository;

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

    public List<Usuario> obtenerUsuarioConCredenciales(Usuario user){
        String sql = "select * from Usuarios  where usuario="+"'"+user.getUsuario()+"'"+"  AND  contrasena="+"'"+user.getContrasena()+"'";
        return jdbcTemplate.query(sql,(rs,rowNum)->
                new Usuario(
                        rs.getLong("idUsuario"),
                        rs.getString("usuario"),
                        rs.getString("contrasena"),
                        rs.getString("rol"),
                        rs.getString("nombre"),
                        rs.getString("direccion"),
                        rs.getString("tel"),
                        rs.getString("correo")
                ));
    }

    public String registrarTicket(Ticket ticket){
        try{
            int estado = jdbcTemplate.update("insert into Tickets(nombreEquipo,codigoEquipo,idcreador,estado) values (?,?,?,?)",ticket.getNombreEquipo(),ticket.getCodigoEquipo(),ticket.getIdCreador(),ticket.getEstado());
            if (estado==1){
                return "Done";
            }else {
                return "Not registered";
            }
        }catch (Exception e){
            return e.toString();
        }

    }
}
