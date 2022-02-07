package com.example.TicketsDemo.model;

import sun.jvm.hotspot.debugger.win32.coff.OptionalHeaderStandardFields;

import java.util.Optional;

public class Ticket {
    private Long idTicket;
    private Long idCliente;
    private String creador;
    private Long idEncargado;
    private String tipoSoporte;
    private Long idPrioridad;
    private String prioridad;
    private String numTicket;
    private String descripcion;
    private int estado;
    private String estadoLetras;

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

    public Ticket(Long idTicket, Long idCliente, String tipoSoporte, String numTicket, String descripcion, int estado, String prioridad) {
        this.idTicket = idTicket;
        this.idCliente = idCliente;
        this.tipoSoporte = tipoSoporte;
        this.numTicket = numTicket;
        this.descripcion = descripcion;
        this.estado = estado;
        this.prioridad = prioridad;
    }

    public Ticket(Long idTicket, Long idCliente, String tipoSoporte, Long idPrioridad, String numTicket, String descripcion, int estado, String prioridad) {
        this.idTicket = idTicket;
        this.idCliente = idCliente;
        this.tipoSoporte = tipoSoporte;
        this.idPrioridad = idPrioridad;
        this.numTicket = numTicket;
        this.descripcion = descripcion;
        this.estado = estado;
        this.prioridad = prioridad;
    }
    public Ticket(Long idTicket, Long idCliente, String tipoSoporte, Long idPrioridad, String numTicket, String descripcion, int estado, String prioridad, String creador) {
        this.idTicket = idTicket;
        this.idCliente = idCliente;
        this.tipoSoporte = tipoSoporte;
        this.idPrioridad = idPrioridad;
        this.numTicket = numTicket;
        this.descripcion = descripcion;
        this.estado = estado;
        this.prioridad = prioridad;
        this.creador = creador;
    }
    public Ticket(Long idTicket, Long idCliente, String tipoSoporte, String numTicket, String descripcion, int estado, String prioridad, String creador) {
        this.idTicket = idTicket;
        this.idCliente = idCliente;
        this.tipoSoporte = tipoSoporte;
        this.numTicket = numTicket;
        this.descripcion = descripcion;
        this.estado = estado;
        this.prioridad = prioridad;
        this.creador = creador;
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

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getEstadoLetras() {
        return estadoLetras;
    }

    public void setEstadoLetras(String estadoLetras) {
        this.estadoLetras = estadoLetras;
    }
}
