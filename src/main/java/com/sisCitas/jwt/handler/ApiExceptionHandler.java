/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisCitas.jwt.handler;

import com.sisCitas.exception.BussinesRuleException;
import com.sisCitas.exception.StandarizedApiExceptionResponse;
import com.sisCitas.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.UnknownHostException;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice//Indicate that this class assit a controller class and can have a body in response
public class ApiExceptionHandler {

    @ExceptionHandler(UnknownHostException.class)
    public ResponseEntity<StandarizedApiExceptionResponse> handleUnknownHostException(UnknownHostException ex) {
        StandarizedApiExceptionResponse response = StandarizedApiExceptionResponse
                .builder()
                .title("Error de conexion")
                .code(String.valueOf(HttpStatus.PARTIAL_CONTENT.value()))
                .detail(ex.getMessage())
                .build();

        return new ResponseEntity(response, HttpStatus.PARTIAL_CONTENT);
    }

    @ExceptionHandler(BussinesRuleException.class)
    public ResponseEntity<StandarizedApiExceptionResponse> handleBussinesRuleException(BussinesRuleException ex) {
        StandarizedApiExceptionResponse response = StandarizedApiExceptionResponse
                .builder()
                .title("Error de validacion")
                .code(ex.getCode())
                .detail(ex.getMessage())
                .build();

        return new ResponseEntity(response, HttpStatus.PARTIAL_CONTENT);
    }

    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorDTO methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        return processFieldErrors(fieldErrors);
    }

    private ErrorDTO processFieldErrors(List<FieldError> fieldErrors) {
        ErrorDTO errorDTO = new ErrorDTO(BAD_REQUEST.value(), "@Valid Error");
        for (FieldError fieldError : fieldErrors) {
            errorDTO.addFieldError(fieldError.getObjectName(), fieldError.getField(), fieldError.getDefaultMessage());
        }
        return errorDTO;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandarizedApiExceptionResponse> handlerContentException(Exception ex) {
        StandarizedApiExceptionResponse response = StandarizedApiExceptionResponse
                .builder()
                .title("Error inesperado")
                .code(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                .detail(ex.getMessage())
                .build();

        return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
