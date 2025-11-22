package com.mazanex.inventario.controller;

import com.mazanex.inventario.dto.CrearProductoRequest;
import com.mazanex.inventario.dto.ProductoDTO;
import com.mazanex.inventario.dto.ProductoMapper;
import com.mazanex.inventario.model.Producto;
import com.mazanex.inventario.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/inventario")
@CrossOrigin("*")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @GetMapping("/productos")
    public ResponseEntity<List<ProductoDTO>> listar() {
        List<ProductoDTO> lista = inventarioService.listarProductos()
                .stream()
                .map(ProductoMapper::toDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<ProductoDTO> obtener(@PathVariable Long id) {
        return inventarioService.obtenerProductoPorId(id)
                .map(ProductoMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/productos")
    public ResponseEntity<ProductoDTO> crear(@RequestBody CrearProductoRequest req) {
        Producto nuevo = ProductoMapper.toEntity(req);
        Producto guardado = inventarioService.agregarProducto(nuevo);
        return ResponseEntity.ok(ProductoMapper.toDTO(guardado));
    }
}
