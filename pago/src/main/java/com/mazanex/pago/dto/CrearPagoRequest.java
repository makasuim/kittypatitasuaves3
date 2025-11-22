package com.mazanex.pago.dto;

import java.util.List;

public class CrearPagoRequest {

    private double subtotal;
    private double descuento;
    private double total;
    private String estado;   // "EXITOSO" o "RECHAZADO"
    private String motivo;   // opcional
    private List<PagoItemRequest> items;

    public CrearPagoRequest() {}

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

    public List<PagoItemRequest> getItems() {
        return items;
    }

    public void setItems(List<PagoItemRequest> items) {
        this.items = items;
    }
}
