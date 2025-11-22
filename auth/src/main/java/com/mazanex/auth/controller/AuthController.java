package com.mazanex.auth.controller;

import com.mazanex.auth.dto.AuthResponse;
import com.mazanex.auth.dto.LoginRequest;
import com.mazanex.auth.dto.RegistroRequest;
import com.mazanex.auth.model.Usuario;
import com.mazanex.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/registro")
    public ResponseEntity<AuthResponse> registrar(@RequestBody RegistroRequest request) {

        Usuario nuevo = authService.registrar(request);

        if (nuevo == null) {
            AuthResponse resp = new AuthResponse(
                    false,
                    "El correo ya está registrado",
                    null,
                    null,
                    null
            );
            return ResponseEntity.status(HttpStatus.CONFLICT).body(resp);
        }

        AuthResponse resp = new AuthResponse(
                true,
                "Usuario registrado correctamente",
                nuevo.getId(),
                nuevo.getNombreCompleto(),
                nuevo.getCorreoElectronico()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {

        Usuario usuario = authService.login(request);

        if (usuario == null) {
            AuthResponse resp = new AuthResponse(
                    false,
                    "Credenciales incorrectas",
                    null,
                    null,
                    null
            );
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(resp);
        }

        AuthResponse resp = new AuthResponse(
                true,
                "Inicio de sesión exitoso",
                usuario.getId(),
                usuario.getNombreCompleto(),
                usuario.getCorreoElectronico()
        );

        return ResponseEntity.ok(resp);
    }
}
