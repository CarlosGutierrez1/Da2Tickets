package com.example.TicketsDemo.model;

public class Administracion extends Usuario{
    private Long idAdministracion;
    private Long idUsuario;

    public Administracion() {
    }

    public Administracion(Long idUsuario, String contrasena, String rol, String correo, String nombre, int disponible) {
        super(idUsuario, contrasena, rol, correo, nombre, disponible);
    }

    public Administracion(Long idUsuario, String contrasena, String rol, String correo, String nombre, int disponible, Long idAdministracion) {
        super(idUsuario,  contrasena, rol, correo, nombre, disponible);
        this.idAdministracion = idAdministracion;
        this.idUsuario = idUsuario;
    }

    public Administracion(String contrasena, String correo, String nombre) {
        super(contrasena, correo, nombre);
    }

    public Administracion(Long idUsuario, String rol, String correo, String nombre, Long idAdministracion) {
        super(idUsuario, rol, correo, nombre);
        this.idAdministracion = idAdministracion;
    }

    public Long getIdAdministracion() {
        return idAdministracion;
    }

    public void setIdAdministracion(Long idAdministracion) {
        this.idAdministracion = idAdministracion;
    }

    @Override
    public Long getIdUsuario() {
        return idUsuario;
    }

    @Override
    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
