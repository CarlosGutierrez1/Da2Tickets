package com.example.TicketsDemo.model;

public class Prioridad {
    private Long idPrioridad;
    private String prioridad;

    public Prioridad() {
    }

    public Prioridad(Long idPrioridad, String prioridad) {
        this.idPrioridad = idPrioridad;
        this.prioridad = prioridad;
    }

    public Long getIdPrioridad() {
        return idPrioridad;
    }

    public void setIdPrioridad(Long idPrioridad) {
        this.idPrioridad = idPrioridad;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }
}
