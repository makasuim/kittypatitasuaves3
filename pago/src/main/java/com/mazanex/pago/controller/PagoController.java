package com.mazanex.pago.controller;

import com.mazanex.pago.dto.CrearPagoRequest;
import com.mazanex.pago.dto.PagoItemRequest;
import com.mazanex.pago.dto.PagoResponse;
import com.mazanex.pago.model.Pago;
import com.mazanex.pago.model.PagoItem;
import com.mazanex.pago.service.PagoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pagos")
@CrossOrigin("*")
public class PagoController {

    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @PostMapping
    public ResponseEntity<PagoResponse> crear(@RequestBody CrearPagoRequest req) {
        Pago pago = pagoService.crearPago(req);
        return ResponseEntity.ok(toResponse(pago));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagoResponse> obtener(@PathVariable Long id) {
        return pagoService.obtenerPorId(id)
                .map(this::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<PagoResponse>> listar() {
        List<PagoResponse> lista = pagoService.listar()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    private PagoResponse toResponse(Pago p) {
    PagoResponse resp = new PagoResponse();
    resp.setId(p.getId());
    resp.setSubtotal(p.getSubtotal());
    resp.setDescuento(p.getDescuento());
    resp.setTotal(p.getTotal());
    resp.setEstado(p.getEstado());
    resp.setMotivo(p.getMotivo());
    resp.setFechaHora(p.getFechaHora());
    resp.setNombreComprador(p.getNombreComprador());
    resp.setEmailComprador(p.getEmailComprador());
    resp.setTelefonoComprador(p.getTelefonoComprador());
    resp.setDireccionComprador(p.getDireccionComprador());

    List<PagoItemRequest> items = p.getItems().stream().map(it -> {
        PagoItemRequest dto = new PagoItemRequest();
        dto.setProductoId(it.getProductoId());
        dto.setNombre(it.getNombre());
        dto.setPrecio(it.getPrecioUnitario());
        dto.setCantidad(it.getCantidad());
        dto.setImagen(it.getImagen());
        return dto;
    }).collect(Collectors.toList());

    resp.setItems(items);
    return resp;
}
}
