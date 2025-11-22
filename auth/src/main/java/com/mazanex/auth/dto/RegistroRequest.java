package com.mazanex.auth.dto;

import java.util.List;

public class RegistroRequest {

    private String nombreCompleto;
    private String correoElectronico;
    private String contrasenaRegistro;
    private String telefono;
    private String region;
    private String comuna;
    private List<MascotaDTO> mascotas;

    public RegistroRequest() {}

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

    public String getContrasenaRegistro() {
        return contrasenaRegistro;
    }

    public void setContrasenaRegistro(String contrasenaRegistro) {
        this.contrasenaRegistro = contrasenaRegistro;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public List<MascotaDTO> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<MascotaDTO> mascotas) {
        this.mascotas = mascotas;
    }
}
