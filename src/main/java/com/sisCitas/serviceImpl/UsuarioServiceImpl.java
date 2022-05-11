package com.sisCitas.serviceImpl;

import com.sisCitas.persistence.entity.Usuario;
import com.sisCitas.persistence.repository.UsuarioRepository;
import com.sisCitas.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Override
    public Usuario save(Usuario usuario) {
        usuario.setIsactivo(true);
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario update(Usuario usuario) {
        usuario.setIsactivo(true);
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> ListAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Long delete(Long idusuario) {
        Long rpta = 0L;
        Usuario c = usuarioRepository
                .findById(idusuario)
                .orElseThrow(EntityNotFoundException::new);
        c.setIsactivo(false);
       rpta = usuarioRepository.save(c) != null ? idusuario : 0L;
       return rpta;
    }
}
