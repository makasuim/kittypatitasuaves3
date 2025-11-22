package com.mazanex.pago.dto;

import java.time.LocalDateTime;
import java.util.List;

public class PagoResponse {

    private Long id;
    private double subtotal;
    private double descuento;
    private double total;
    private String estado;
    private String motivo;
    private LocalDateTime fechaHora;
    private List<PagoItemRequest> items;

    public PagoResponse() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public List<PagoItemRequest> getItems() {
        return items;
    }

    public void setItems(List<PagoItemRequest> items) {
        this.items = items;
    }
}
