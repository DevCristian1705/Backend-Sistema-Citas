package com.sisCitas.controller;

import com.sisCitas.dto.HorariosDoctorDto;
import com.sisCitas.jwt.handler.ResponseHandler;
import com.sisCitas.persistence.entity.Horario;
import com.sisCitas.service.HorarioService;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/horario")
@RequiredArgsConstructor

public class HorarioController {

    private final HorarioService horarioService;

    @GetMapping("/listar")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Object> get() {
        try {
            List<Horario> c = horarioService.ListAll();
            return ResponseHandler.generateResponse("Datos listados con exito!.", HttpStatus.OK, c);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @GetMapping("/listar/{idusuario}")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Object> getHorarios(@PathVariable Long idusuario) {
        try {
            List<HorariosDoctorDto> c = horarioService.obtenerHorariosPorIdDoctor(idusuario);
            return ResponseHandler.generateResponse("Datos listados los horarios por usuariodoctor  con exito!.", HttpStatus.OK, c);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PostMapping("/crear")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Object> save(@Valid @RequestBody List<Horario> horario) {
        try {
            boolean result = horarioService.save(horario);
            return ResponseHandler.generateResponse("Datos registrados con exito!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PutMapping("/update")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Object> update(@Valid @RequestBody List<Horario> horario) {
        try {
            Horario result = null; //horarioService.save(horario);
            return ResponseHandler.generateResponse("Datos actualizados con exito!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @DeleteMapping("/delete/{idhorario}")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Object> delete(@PathVariable Long idhorario) {
        try {
            Long result = horarioService.delete(idhorario);
            return ResponseHandler.generateResponse("Dato eliminado con exito!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
}
