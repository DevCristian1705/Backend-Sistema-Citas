package com.sisCitas.controller;

import com.sisCitas.jwt.handler.ResponseHandler;
import com.sisCitas.persistence.entity.DiasAtencion;
import com.sisCitas.service.DiasAtencionService;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/diasatencion")
@RequiredArgsConstructor
public class DiasAtencionController {

    private final DiasAtencionService diasAtencionService;

    @GetMapping("/listar")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Object> get() {
        try {
            List<DiasAtencion> c = diasAtencionService.ListAll();
            return ResponseHandler.generateResponse("Datos listados con exito!.", HttpStatus.OK, c);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @GetMapping("/listar/{idusuariodoctor}")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Object> findAllByIdusuariodoctor(@PathVariable Long idusuariodoctor) {
        try {
            List<DiasAtencion> result = diasAtencionService.findAllByIdusuariodoctor(idusuariodoctor);
            return ResponseHandler.generateResponse("Dato listados por id doctor con exito!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }


    @PostMapping("/crear")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Object> save(@Valid @RequestBody List<DiasAtencion> diasAtencion) {
        try {
            boolean result = diasAtencionService.save(diasAtencion);
            return ResponseHandler.generateResponse("Datos registrados con exito!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PutMapping("/update")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Object> update(@Valid @RequestBody List<DiasAtencion> diasAtencion) {
        try {
            List<DiasAtencion> result = null;//diasAtencionService.save(diasAtencion);
            return ResponseHandler.generateResponse("Datos actualizados con exito!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @DeleteMapping("/delete/{idhorario}")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Object> delete(@PathVariable Long iddiasatencion) {
        try {
            Long result = diasAtencionService.delete(iddiasatencion);
            return ResponseHandler.generateResponse("Dato eliminado con exito!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }


}
