package com.mazanex.pago.dto;

import java.util.List;

public class PagoRequest {

    private Long usuarioId;
    private List<ItempagoRequest> items;

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public List<ItempagoRequest> getItems() {
        return items;
    }

    public void setItems(List<ItempagoRequest> items) {
        this.items = items;
    }

    public static class ItempagoRequest {
        private Long productoId;
        private int cantidad;

        public Long getProductoId() {
            return productoId;
        }

        public void setProductoId(Long productoId) {
            this.productoId = productoId;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }
    }
}
