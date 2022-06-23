package com.sisCitas.service;

import com.sisCitas.persistence.entity.Usuario;
import java.util.List;
import java.util.Optional;


public interface UsuarioService {
    Usuario save(Usuario usuario);
    Usuario update(Usuario usuario);
    List<Usuario> ListAll();
    List<Usuario> ListUsuarioDoctor();
    List<Usuario> ListUsuarios();
    Long delete(Long idusuario);
    Optional<Usuario> getUsuarioId(Long idusuario);

}
