package com.sisCitas.serviceImpl;

import com.sisCitas.dto.UserDto;

import com.sisCitas.persistence.entity.Usuario;
import com.sisCitas.persistence.repository.UserRepository;
import com.sisCitas.utils.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public Usuario signup(UserDto userDto) {
        Usuario user = Usuario.builder()
                .usuario(userDto.getUsuario())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .isactivo(true)
                .build();

        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public Optional<Usuario> getUserWithAuthorities(String username) {
        return userRepository.findOneByUsuario(username);
    }

    @Transactional(readOnly = true)
    public Optional<Usuario> getMyUserWithAuthorities() {
        return SecurityUtil.getCurrentUsername().flatMap(userRepository::findOneByUsuario);
    }
}
