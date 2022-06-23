package com.sisCitas.persistence.repository;


import com.sisCitas.persistence.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

   Optional<Usuario> findOneByUsuario(String username);
   Optional<Usuario> findOneWithAuthoritiesByUsuario(String usuario);
   List<Usuario> findAllByIsdoctorTrueAndIsdoctoractivoTrue();
   List<Usuario> findAllByIsdoctorFalseAndIsadminFalseAndIsactivoTrue();
   Optional<Usuario> findByIdusuarioAndIsactivoTrue(Long idusuario);
}