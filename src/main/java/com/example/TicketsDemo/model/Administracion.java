package com.example.TicketsDemo.model;

public class Administracion extends Usuario{
    private Long idAdministracion;
    private Long idUsuario;

    public Administracion() {
    }

    public Administracion(Long idUsuario, String contrasena, String rol, String correo, String nombre, int disponible) {
        super(idUsuario, contrasena, rol, correo, nombre, disponible);
    }

    public Administracion(Long idUsuario,  String contrasena, String rol, String correo, String nombre, int disponible, Long idAdministracion) {
        super(idUsuario,  contrasena, rol, correo, nombre, disponible);
        this.idAdministracion = idAdministracion;
        this.idUsuario = idUsuario;
    }
}
