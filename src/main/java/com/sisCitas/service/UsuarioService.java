package com.sisCitas.service;

import com.sisCitas.persistence.entity.Usuario;
import java.util.List;


public interface UsuarioService {
    Usuario save(Usuario usuario);
    Usuario update(Usuario usuario);
    List<Usuario> ListAll();
    Long delete(Long idusuario);






}
