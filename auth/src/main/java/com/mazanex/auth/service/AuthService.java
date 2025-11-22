package com.mazanex.auth.service;

import com.mazanex.auth.dto.LoginRequest;
import com.mazanex.auth.dto.MascotaDTO;
import com.mazanex.auth.dto.RegistroRequest;
import com.mazanex.auth.model.Mascota;
import com.mazanex.auth.model.Usuario;
import com.mazanex.auth.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
            return null;
        }

        Usuario usuario = new Usuario();
        usuario.setNombreCompleto(request.getNombreCompleto());
        usuario.setCorreoElectronico(request.getCorreoElectronico());
        usuario.setContrasena(request.getContrasenaRegistro());
        usuario.setTelefono(request.getTelefono());
        usuario.setRegion(request.getRegion());
        usuario.setComuna(request.getComuna());

        List<Mascota> mascotas = new ArrayList<>();
        if (request.getMascotas() != null) {
            for (MascotaDTO dto : request.getMascotas()) {
                if (dto.getTipo() != null && !dto.getTipo().isBlank()
                        && dto.getNombre() != null && !dto.getNombre().isBlank()) {
                    Mascota mascota = new Mascota();
                    mascota.setTipo(dto.getTipo());
                    mascota.setNombre(dto.getNombre());
                    mascota.setUsuario(usuario);
                    mascotas.add(mascota);
                }
            }
        }

        usuario.setMascotas(mascotas);

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

    public List<MascotaDTO> mapMascotasToDTO(Usuario usuario) {
        List<MascotaDTO> lista = new ArrayList<>();
        if (usuario.getMascotas() != null) {
            for (Mascota m : usuario.getMascotas()) {
                lista.add(new MascotaDTO(m.getTipo(), m.getNombre()));
            }
        }
        return lista;
    }

    
}
