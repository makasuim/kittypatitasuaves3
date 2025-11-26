package com.mazanex.auth.controller;

import com.mazanex.auth.dto.AuthResponse;
import com.mazanex.auth.dto.LoginRequest;
import com.mazanex.auth.dto.RegistroRequest;
import com.mazanex.auth.model.Usuario;
import com.mazanex.auth.security.JwtUtil;
import com.mazanex.auth.service.AuthService;

import io.jsonwebtoken.Claims;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/registro")
    public ResponseEntity<AuthResponse> registrar(@RequestBody RegistroRequest request) {

        Usuario nuevo = authService.registrar(request);

        if (nuevo == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                    new AuthResponse(
                            false,
                            "El correo ya está registrado",
                            null,
                            null,
                            null,
                            null,
                            null
                    )
            );
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(
                new AuthResponse(
                        true,
                        "Usuario registrado correctamente",
                        nuevo.getId(),
                        nuevo.getNombreCompleto(),
                        nuevo.getCorreoElectronico(),
                        authService.mapMascotasToDTO(nuevo),
                        null
                )
        );
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {

        Usuario usuario = authService.login(request);

        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                    new AuthResponse(
                            false,
                            "Credenciales incorrectas",
                            null,
                            null,
                            null,
                            null,
                            null
                    )
            );
        }

        // 🔥 GENERAR TOKEN
        String token = jwtUtil.generarToken(usuario.getId(), usuario.getCorreoElectronico());

        return ResponseEntity.ok(
                new AuthResponse(
                        true,
                        "Inicio de sesión exitoso",
                        usuario.getId(),
                        usuario.getNombreCompleto(),
                        usuario.getCorreoElectronico(),
                        authService.mapMascotasToDTO(usuario),
                        token  // ← ← ← 🔥 AHORA SÍ SE ENVÍA EL TOKEN
                )
        );
    }

    @PostMapping("/validate")
    public ResponseEntity<?> validarToken(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
    try {
        String jwt = token.replace("Bearer ", "");
        Claims claims = jwtUtil.validarToken(jwt);
        return ResponseEntity.ok(claims);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token inválido");
    }
}

}
