package com.example.TicketsDemo.model;

public class Usuario {
   private Long idUsuario;
   private String contrasena;
   private String rol;
   private String correo;
   private String nombre;
   private int disponible;

    public Usuario() {
    }

    public Usuario(String contrasena,  String correo, String nombre) {
        this.contrasena = contrasena;
        this.rol = "ROL_C";
        this.correo = correo;
        this.nombre = nombre;
        this.disponible = 1;
    }

    public Usuario(String contrasena, String rol, String correo, String nombre, int disponible) {
        this.contrasena = contrasena;
        this.rol = rol;
        this.correo = correo;
        this.nombre = nombre;
        this.disponible = disponible;
    }

    public Usuario(Long idUsuario, String contrasena, String rol, String correo, String nombre, int disponible) {
        this.idUsuario = idUsuario;
        this.contrasena = contrasena;
        this.rol = rol;
        this.correo = correo;
        this.nombre = nombre;
        this.disponible = disponible;
    }

    public Usuario(Long idUsuario, String rol, String correo, String nombre) {
        this.idUsuario = idUsuario;
        this.rol = rol;
        this.correo = correo;
        this.nombre = nombre;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }



    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDisponible() {
        return disponible;
    }

    public void setDisponible(int disponible) {
        this.disponible = disponible;
    }
}
