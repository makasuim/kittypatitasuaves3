package com.mazanex.auth.dto;

import java.util.List;

public class AuthResponse {

    private boolean success;
    private String message;
    private Long userId;
    private String nombreCompleto;
    private String correoElectronico;
    private List<?> mascotas; // o List<MascotaDTO>
    private String token;

    public AuthResponse(boolean success,
                        String message,
                        Long userId,
                        String nombreCompleto,
                        String correoElectronico,
                        List<?> mascotas,
                        String token) {
        this.success = success;
        this.message = message;
        this.userId = userId;
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.mascotas = mascotas;
        this.token = token;
    }

    // Getters y setters obligatorios
    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public String getCorreoElectronico() { return correoElectronico; }
    public void setCorreoElectronico(String correoElectronico) { this.correoElectronico = correoElectronico; }

    public List<?> getMascotas() { return mascotas; }
    public void setMascotas(List<?> mascotas) { this.mascotas = mascotas; }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
}
