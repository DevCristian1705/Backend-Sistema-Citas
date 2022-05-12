package com.sisCitas.controller;

import com.sisCitas.jwt.handler.ResponseHandler;
import com.sisCitas.persistence.entity.Doctor;
import com.sisCitas.service.DoctorService;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/doctor")
@RequiredArgsConstructor

public class DoctorController {

    private  final DoctorService doctorService;
    @GetMapping("/listar")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Object> get(){
        try{
            List<Doctor> c = doctorService.ListAll();
            return  ResponseHandler.generateResponse("Datos listados con exito!.", HttpStatus.OK, c);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PostMapping("/crear")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Object> save(@Valid @RequestBody Doctor doctor){
        try{
            Doctor result = doctorService.save(doctor);
            return ResponseHandler.generateResponse("Datos registrados con exito!", HttpStatus.OK, result);
        } catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PutMapping("/update")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Object> update(@Valid @RequestBody Doctor doctor){
        try{
            Doctor result = doctorService.update(doctor);
            return ResponseHandler.generateResponse("Datos actualizados con exito!", HttpStatus.OK, result);
        } catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }



    @DeleteMapping("/delete/{iddoctor}")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Object> delete(@PathVariable Long iddoctor) {
        try {
            Long result = doctorService.delete(iddoctor);
            return ResponseHandler.generateResponse("Dato eliminado con exito!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }


}
