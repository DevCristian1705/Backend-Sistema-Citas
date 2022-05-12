package com.sisCitas.controller;

import com.sisCitas.jwt.handler.ResponseHandler;
import com.sisCitas.persistence.entity.Cita;
import com.sisCitas.service.CitaService;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/cita")
@RequiredArgsConstructor
public class CitaController {

    private final CitaService citaService;

    @GetMapping("/listar")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Object> get(){
        try{
            List<Cita> c = citaService.ListAll();
            return  ResponseHandler.generateResponse("Datos listados con exito!.", HttpStatus.OK, c);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
    @PostMapping("/crear")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Object> save(@Valid @RequestBody Cita cita){
        try{
            Cita result = citaService.save(cita);
            return ResponseHandler.generateResponse("Datos registrados con exito!", HttpStatus.OK, result);
        } catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PutMapping("/update")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Object> update(@Valid @RequestBody Cita cita){
        try{
            Cita result = citaService.save(cita);
            return ResponseHandler.generateResponse("Datos actualziados con exito!", HttpStatus.OK, result);
        } catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @DeleteMapping("/delete/{idcita}")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Object> delete(@PathVariable Long idcita) {
        try {
            Long result = citaService.delete(idcita);
            return ResponseHandler.generateResponse("Dato eliminado con exito!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
}
