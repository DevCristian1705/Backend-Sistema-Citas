package com.sisCitas.persistence.repository;


import com.sisCitas.persistence.entity.Usuario;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {

   Optional<Usuario> findOneByUsuario(String username);
}
