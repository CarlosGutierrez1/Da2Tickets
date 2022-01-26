package com.example.TicketsDemo.model;

public class Ticket {
    private Long idTicket;
    private String nombreEquipo;
    private String codigoEquipo;
    private Long idCreador;
    private int estado;

    public Ticket() {
    }

    public Ticket(Long idTicket, String nombreEquipo, String codigoEquipo, Long idCreador, int estado) {
        this.idTicket = idTicket;
        this.nombreEquipo = nombreEquipo;
        this.codigoEquipo = codigoEquipo;
        this.idCreador = idCreador;
        this.estado = estado;
    }

    public Long getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Long idTicket) {
        this.idTicket = idTicket;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getCodigoEquipo() {
        return codigoEquipo;
    }

    public void setCodigoEquipo(String codigoEquipo) {
        this.codigoEquipo = codigoEquipo;
    }

    public Long getIdCreador() {
        return idCreador;
    }

    public void setIdCreador(Long idCreador) {
        this.idCreador = idCreador;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
