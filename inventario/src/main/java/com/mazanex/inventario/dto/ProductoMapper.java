package com.mazanex.inventario.dto;

import com.mazanex.inventario.model.Producto;

public class ProductoMapper {

    public static ProductoDTO toDTO(Producto p) {
        ProductoDTO dto = new ProductoDTO();
        dto.setId(p.getId());
        dto.setNombre(p.getNombre());
        dto.setStock(p.getStock());   // si tu ProductoDTO aún tiene "cantidad", pon setCantidad
        dto.setPrecio(p.getPrecio());
        return dto;
    }

    public static Producto toEntity(CrearProductoRequest req) {
        Producto p = new Producto();
        p.setNombre(req.getNombre());
        p.setDescripcion(req.getDescripcion());
        p.setStock(req.getStock());
        p.setPrecio(req.getPrecio());
        p.setCategoria(req.getCategoria());
        p.setImagen(req.getImagen());
        return p;
    }
}
