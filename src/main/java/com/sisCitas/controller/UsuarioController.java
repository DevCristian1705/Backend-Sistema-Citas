package com.sisCitas.controller;

import com.sisCitas.handler.ResponseHandler;
import com.sisCitas.persistence.entity.Usuario;
import com.sisCitas.service.UsuarioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/usuario")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @PostMapping("/save")
    @ApiOperation("Post save - guarda datos de nuevo usuario")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Object> save(@Valid @RequestBody Usuario usuario) {
        try {
            Usuario result = usuarioService.save(usuario);
            return ResponseHandler.generateResponse("Datos registrados con exito!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @GetMapping("/list")
    @ApiOperation("Get list - lista todos las personas registradas")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Object> get(Pageable pageable) {
        try {
            List<Usuario> c = usuarioService.ListAllByPage();
            return ResponseHandler.generateResponse("Datos listados con exito!", HttpStatus.OK, c);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PutMapping("/update")
    @ApiOperation("Put update - actualiza datos del usuario")
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
    @ApiOperation("Delete - eliminar usuario")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Object>delete(@PathVariable Long idusuario) {
        try {
            Long result = usuarioService.delete(idusuario);
            return ResponseHandler.generateResponse("Dato eliminado con exito!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
}
