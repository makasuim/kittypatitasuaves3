package com.mazanex.pago.service;

import com.mazanex.pago.dto.CrearPagoRequest;
import com.mazanex.pago.dto.PagoItemRequest;
import com.mazanex.pago.model.Pago;
import com.mazanex.pago.model.PagoItem;
import com.mazanex.pago.repository.PagoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoService {

    private final PagoRepository pagoRepository;

    public PagoService(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    public Pago crearPago(CrearPagoRequest req) {
    Pago pago = new Pago();
    pago.setSubtotal(req.getSubtotal());
    pago.setDescuento(req.getDescuento());
    pago.setTotal(req.getTotal());
    pago.setEstado(req.getEstado() != null ? req.getEstado() : "EXITOSO");
    pago.setNombreComprador(req.getNombreComprador());
    pago.setEmailComprador(req.getEmailComprador());
    pago.setTelefonoComprador(req.getTelefonoComprador());
    pago.setDireccionComprador(req.getDireccionComprador());

    if (req.getItems() != null) {
        for (PagoItemRequest itemReq : req.getItems()) {
            PagoItem item = new PagoItem();
            item.setProductoId(itemReq.getProductoId());
            item.setNombre(itemReq.getNombre());
            item.setPrecioUnitario(itemReq.getPrecio());
            item.setCantidad(itemReq.getCantidad());
            item.setImagen(itemReq.getImagen());
            item.setPago(pago);
            pago.getItems().add(item);
        }
    }

    return pagoRepository.save(pago);
}

    public Optional<Pago> obtenerPorId(Long id) {
        return pagoRepository.findById(id);
    }

    public List<Pago> listar() {
        return pagoRepository.findAll();
    }
}
