package com.example.TicketsDemo.model;

public class Ticket {
    private Long idTicket;
    private Long idCliente;
    private Long idEncargado;
    private String tipoSoporte;
    private Long idPrioridad;
    private String numTicket;
    private String descripcion;
    private int estado;

    public Ticket() {
    }

    public Ticket(String tipoSoporte, Long idPrioridad, String descripcion) {
        this.tipoSoporte = tipoSoporte;
        this.idPrioridad = idPrioridad;
        this.descripcion = descripcion;
    }

    public Ticket(Long idTicket, Long idCliente, String tipoSoporte, Long idPrioridad, String numTicket, String descripcion, int estado) {
        this.idTicket = idTicket;
        this.idCliente = idCliente;
        this.tipoSoporte = tipoSoporte;
        this.idPrioridad = idPrioridad;
        this.numTicket = numTicket;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Ticket(Long idTicket, Long idCliente, Long idEncargado, String tipoSoporte, Long idPrioridad, String numTicket, String descripcion, int estado) {
        this.idTicket = idTicket;
        this.idCliente = idCliente;
        this.idEncargado = idEncargado;
        this.tipoSoporte = tipoSoporte;
        this.idPrioridad = idPrioridad;
        this.numTicket = numTicket;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Long getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Long idTicket) {
        this.idTicket = idTicket;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdEncargado() {
        return idEncargado;
    }

    public void setIdEncargado(Long idEncargado) {
        this.idEncargado = idEncargado;
    }

    public String getTipoSoporte() {
        return tipoSoporte;
    }

    public void setTipoSoporte(String tipoSoporte) {
        this.tipoSoporte = tipoSoporte;
    }

    public Long getIdPrioridad() {
        return idPrioridad;
    }

    public void setIdPrioridad(Long idPrioridad) {
        this.idPrioridad = idPrioridad;
    }

    public String getNumTicket() {
        return numTicket;
    }

    public void setNumTicket(String numTicket) {
        this.numTicket = numTicket;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
