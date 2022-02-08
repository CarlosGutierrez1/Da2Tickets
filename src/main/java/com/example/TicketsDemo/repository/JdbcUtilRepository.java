package com.example.TicketsDemo.repository;

import com.example.TicketsDemo.model.Cliente;
import com.example.TicketsDemo.model.Administracion;
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
    public Boolean registrarUsuarioAdministracion(Administracion adminis, Long idUsuario){
        int estado = jdbcTemplate.update("insert into Administracion(idUsuario) values(?)",idUsuario);
        return estado==1;
    }

    public Boolean registrarUsuario(Usuario user){
        Long existeUsuarioConMismoCorreo = obtenerIdUsuarioPorCorreo(user.getCorreo());
//        System.out.println(existeUsuarioConMismoCorreo);
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
//            System.out.println(jdbcTemplate.queryForObject("select idUsuario from Usuarios where correo=? limit 1",new Object[]{correo},Long.class));
            return jdbcTemplate.queryForObject("select idUsuario from Usuarios where correo=? limit 1",new Object[]{correo},Long.class);
        }catch (Exception e) {
            System.out.println("No se encontro el usuario " + e);
            return 0L;
        }
    }
    public String obtenerRolUsuarioPorCorreo(String correo){
        try {
            return jdbcTemplate.queryForObject("Select rol from Usuarios where correo=?",new Object[]{correo},String.class);
        }catch (Exception e){
            System.out.println("No se encontro al usuario, error: " + e);
            return "";
        }
    }

    public boolean existeNumTicket(String numTicket){
        int existe = jdbcTemplate.queryForObject("select count(1) from Tickets where numTicket=?",new Object[]{numTicket},Integer.class);
        return existe==1;
    }

    public boolean registrarTicket(Ticket ticket){
        int estado = jdbcTemplate.update("insert into Tickets(idCliente,tipoSoporte,idPrioridad,numTicket,descripcion,fechayhora,estado) values(?,?,?,?,?,?,?)",
                ticket.getIdCliente(),ticket.getTipoSoporte(),ticket.getIdPrioridad(),ticket.getNumTicket(),ticket.getDescripcion(),ticket.getFechayhora(),ticket.getEstado());
        return estado==1;
    }

    public List<Ticket> obtenerTicketsHechosPorUnUsuario(String correo){
        Long idUsuario = obtenerIdUsuarioPorCorreo(correo);
        if (idUsuario!=0){
            String sql = "select * from Tickets T inner join Prioridad P on T.idPrioridad=P.idPrioridad where T.idCliente="+idUsuario;
            return jdbcTemplate.query(sql,(rs,rowNum)->
                    new Ticket(
                            rs.getLong("idTicket"),
                            rs.getString("tipoSoporte"),
                            rs.getString("numTicket"),
                            rs.getString("descripcion"),
                            rs.getInt("estado"),
                            rs.getString("prioridad"),
                            rs.getString("fechayhora")
                    ));
        }else{
            System.out.println("No se encontro el usuario " + correo);
            return null;
        }
    }


    public List<Ticket> obtenerTodosLosTiketsConEstadoDisponible(){
            String sql = "select idTicket,idCliente, tipoSoporte, numTicket, descripcion, " +
                    "estado, prioridad,(U.correo) as creador from Tickets T inner join Prioridad P on T.idPrioridad=P.idPrioridad inner join Usuarios U on U.idUsuario=T.idCliente where T.estado=0";
            return jdbcTemplate.query(sql,(rs,rowNum)->
                    new Ticket(
                            rs.getLong("idTicket"),
                            rs.getLong("idCliente"),
                            rs.getString("tipoSoporte"),
                            rs.getString("numTicket"),
                            rs.getString("descripcion"),
                            rs.getInt("estado"),
                            rs.getString("prioridad"),
                            rs.getString("creador")
                    ));

    }

    public List<Ticket> obtenerTicketsAsignadosATecnico(Long idTecnico){
        String sql = "select idTicket,idCliente, tipoSoporte, numTicket, descripcion, " +
                "estado, prioridad,(U.correo) as creador from Tickets T inner join Prioridad P on T.idPrioridad=P.idPrioridad inner join Usuarios U on U.idUsuario=T.idCliente where T.idEncargado="+idTecnico+" and T.estado=2";
        return jdbcTemplate.query(sql,(rs,rowNum)->
                new Ticket(
                        rs.getLong("idTicket"),
                        rs.getLong("idCliente"),
                        rs.getString("tipoSoporte"),
                        rs.getString("numTicket"),
                        rs.getString("descripcion"),
                        rs.getInt("estado"),
                        rs.getString("prioridad"),
                        rs.getString("creador")
                ));
    }

    public List<Ticket> obtenerTicketPorIdTicket(Long idTicket){

        String sql = "select idTicket, tipoSoporte, numTicket, descripcion, estado, prioridad, fechayhora from Tickets T inner join Prioridad P on T.idPrioridad=P.idPrioridad where T.idTicket="+idTicket;
        return jdbcTemplate.query(sql,(rs,rowNum)->
                new Ticket(
                        rs.getLong("idTicket"),
                        rs.getString("tipoSoporte"),
                        rs.getString("numTicket"),
                        rs.getString("descripcion"),
                        rs.getInt("estado"),
                        rs.getString("prioridad"),
                        rs.getString("fechayhora")
                ));

    }

    public String obtenerTipoPrioridadPorId(Long idPrioridad){
        return jdbcTemplate.queryForObject("select prioridad from Prioridad where idPrioridad=?",new Object[]{idPrioridad},String.class);
    }

    public List<Ticket> obtenerTicketPorNumTicket(String numTicket){
        String sql = "select idTicket, tipoSoporte, numTicket, descripcion, estado, prioridad, fechayhora from Tickets T inner join Prioridad P on T.idPrioridad=P.idPrioridad where T.numTicket='"+numTicket+"'";
        try{
            return jdbcTemplate.query(sql,(rs,rowNum)->
                    new Ticket(
                            rs.getLong("idTicket"),
                            rs.getString("tipoSoporte"),
                            rs.getString("numTicket"),
                            rs.getString("descripcion"),
                            rs.getInt("estado"),
                            rs.getString("prioridad"),
                            rs.getString("fechayhora")
                    ));
        } catch (Exception e){
            System.out.println("No se encontro el ticket -> " + e);
            return null;
        }

    }

    public List<Administracion> obtenerTodosLosTecnicos(){
        String sql ="Select U.idUsuario,rol,correo,nombre,idAdministracion from Usuarios U inner join Administracion A on A.idUsuario=U.idUsuario where U.rol='ROL_T'";
        return jdbcTemplate.query(sql,(rs,rowNum)->
                new Administracion(
                        rs.getLong("idUsuario"),
                        rs.getString("rol"),
                        rs.getString("correo"),
                        rs.getString("nombre"),
                        rs.getLong("idAdministracion")

                ));
    }

    public boolean asignarTecnicoATicket(Long idTecnico, Long idTicket){
        int estado = jdbcTemplate.update("update Tickets set idEncargado=?,estado=? where idTicket=?",idTecnico,2,idTicket);
        return estado==1;
    }
    public Long obtenerIdUsuarioPorIdAdministracion(Long idAdministracion){
        return jdbcTemplate.queryForObject("select U.idUsuario from Usuarios U inner join Administracion A on U.idUsuario=A.idUsuario where A.idAdministracion=?",new Object[]{idAdministracion},Long.class);
    }

    public boolean marcarTicketComoResuelto(Long idTicket){
        int estado = jdbcTemplate.update("update Tickets set estado=? where idTicket=?",1,idTicket);
        return estado==1;
    }

    public String obtenerCorreoClientePorIdUsuario(Long idUsuario){
        return jdbcTemplate.queryForObject("Select correo from Usuarios where idUsuario=?",new Object[]{idUsuario},String.class);
    }

    public String obtenerCorreoClientePorIdTicket(Long idTicket){
        return jdbcTemplate.queryForObject("Select U.correo from Usuarios U inner join Tickets T on T.idCliente=U.idUsuario where T.idTicket=?",new Object[]{idTicket},String.class);
    }

}
