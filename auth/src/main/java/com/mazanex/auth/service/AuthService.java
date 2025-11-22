package com.mazanex.auth.service;

import com.mazanex.auth.dto.LoginRequest;
import com.mazanex.auth.dto.RegistroRequest;
import com.mazanex.auth.model.Usuario;
import com.mazanex.auth.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;

    public AuthService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario registrar(RegistroRequest request) {

        Optional<Usuario> existente =
                usuarioRepository.findByCorreoElectronico(request.getCorreoElectronico());

        if (existente.isPresent()) {
            // ya existe un usuario con ese correo
            return null;
        }

        Usuario usuario = new Usuario();
        usuario.setNombreCompleto(request.getNombreCompleto());
        usuario.setCorreoElectronico(request.getCorreoElectronico());
        usuario.setContrasena(request.getContrasenaRegistro());
        usuario.setTelefono(request.getTelefono());
        usuario.setRegion(request.getRegion());
        usuario.setComuna(request.getComuna());

        return usuarioRepository.save(usuario);
    }

    public Usuario login(LoginRequest request) {

        Optional<Usuario> opt =
                usuarioRepository.findByCorreoElectronico(request.getCorreoElectronico());

        if (opt.isEmpty()) {
            return null;
        }

        Usuario usuario = opt.get();

        if (!usuario.getContrasena().equals(request.getContrasena())) {
            return null;
        }

        return usuario;
    }
}
