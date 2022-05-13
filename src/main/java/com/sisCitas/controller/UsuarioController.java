package com.sisCitas.controller;

import com.sisCitas.jwt.handler.ResponseHandler;
import com.sisCitas.persistence.entity.Usuario;
import com.sisCitas.persistence.repository.UsuarioRepository;
import com.sisCitas.service.UsuarioService;
import com.sisCitas.utils.SecurityUtil;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final UsuarioRepository usuarioRepository;


    @GetMapping("/listar")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Object> get() {
        try {
            List<Usuario> c = usuarioService.ListAll();
            return ResponseHandler.generateResponse("Datos listados con exito!", HttpStatus.OK, c);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @GetMapping("/listardoctores")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Object> findAllByIsdoctorTrueAndIsactivoTrue() {
        try {
            List<Usuario> c = usuarioService.findAllByIsdoctorTrueAndIsactivoTrue();
            return ResponseHandler.generateResponse("Datos listados con exito!", HttpStatus.OK, c);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }




    @PostMapping("/crear")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Object> save(@Valid @RequestBody Usuario usuario) {
        try {
            Usuario result = usuarioService.save(usuario);
            return ResponseHandler.generateResponse("Datos registrados con exito!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PutMapping("/update")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Object> update(@Valid @RequestBody Usuario usuario) {
        try {
            Usuario result = usuarioService.update(usuario);
            return ResponseHandler.generateResponse("Datos actualizados con exito!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @DeleteMapping("/delete/{idusuario}")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Object> delete(@PathVariable Long idusuario) {
        try {
            Long result = usuarioService.delete(idusuario);
            return ResponseHandler.generateResponse("Dato eliminado con exito!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }


    @Transactional(readOnly = true)
    public Optional<Usuario> getUserWithAuthorities(String usuario) {
        return usuarioRepository.findOneByUsuario(usuario);
    }

    @Transactional(readOnly = true)
    public Optional<Usuario> getMyUserWithAuthorities() {
        return SecurityUtil.getCurrentUsername().flatMap(usuarioRepository::findOneByUsuario);
    }


}
