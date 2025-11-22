package com.mazanex.auth.dto;

import java.util.List;

public class AuthResponse {

    private boolean exito;
    private String mensaje;
    private Long usuarioId;
    private String nombreCompleto;
    private String correoElectronico;
    private List<MascotaDTO> mascotas;

    public AuthResponse() {
    }

    public AuthResponse(boolean exito,
                        String mensaje,
                        Long usuarioId,
                        String nombreCompleto,
                        String correoElectronico,
                        List<MascotaDTO> mascotas) {
        this.exito = exito;
        this.mensaje = mensaje;
        this.usuarioId = usuarioId;
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.mascotas = mascotas;
    }

    public boolean isExito() {
        return exito;
    }

    public void setExito(boolean exito) {
        this.exito = exito;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public List<MascotaDTO> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<MascotaDTO> mascotas) {
        this.mascotas = mascotas;
    }
}
