package com.sisCitas.serviceImpl;

import com.sisCitas.persistence.entity.Usuario;
import com.sisCitas.persistence.repository.UsuarioRepository;
import com.sisCitas.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Override
    public Usuario save(Usuario usuario) {
        usuario.setIsactivo(true);
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario update(Usuario usuario) {
        usuario.setIsactivo(true);
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> ListAllByPage() {
        return usuarioRepository.findByIsactivo(true);
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
