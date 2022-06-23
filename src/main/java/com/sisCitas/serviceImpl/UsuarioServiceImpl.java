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
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Override
    public Usuario save(Usuario usuario) {
        if(usuario.isIsdoctor()){
            usuario.setIsdoctoractivo(true);
        }
        usuario.setIsactivo(true);
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario update(Usuario usuario) {
        if(usuario.isIsdoctor()){
            usuario.setIsdoctoractivo(true);
        }
        usuario.setIsactivo(true);
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> ListAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public List<Usuario> ListUsuarioDoctor() {
        return usuarioRepository.findAllByIsdoctorTrueAndIsdoctoractivoTrue();
    }

    @Override
    public List<Usuario> ListUsuarios() {
        return usuarioRepository.findAllByIsdoctorFalseAndIsadminFalseAndIsactivoTrue();
    }


    @Override
    public Optional<Usuario> getUsuarioId(Long idusuario) {
        Optional<Usuario> data = usuarioRepository.findByIdusuarioAndIsactivoTrue(idusuario);
        return data;
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
