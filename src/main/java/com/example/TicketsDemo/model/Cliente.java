package com.example.TicketsDemo.model;

public class Cliente extends Usuario{
    private Long idCliente;
    private Long idUsuario;
    private int numDoc;
    private String tipoDoc;
    private String empresa;
    private String cargo;

    public Cliente() {
    }

    public Cliente(Long idUsuario, String usuario, String contrasena, String rol,
                   String correo, String nombre, int disponible) {
        super(idUsuario, usuario, contrasena, rol, correo, nombre, disponible);
        this.idUsuario = idUsuario;
    }

    public Cliente(Long idUsuario, String usuario, String contrasena, String rol,
                   String correo, String nombre, int disponible, Long idCliente,
                   int numDoc, String tipoDoc, String empresa, String cargo) {
        super(idUsuario, usuario, contrasena, rol, correo, nombre, disponible);
        this.idCliente = idCliente;
        this.idUsuario = idUsuario;
        this.numDoc = numDoc;
        this.tipoDoc = tipoDoc;
        this.empresa = empresa;
        this.cargo = cargo;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public Long getIdUsuario() {
        return idUsuario;
    }

    @Override
    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(int numDoc) {
        this.numDoc = numDoc;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
