package com.guitarradecero.preguntados_de_cero.controller.errorHandler.client;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class BodyErrorController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorBodyResponse>> bodyError(MethodArgumentNotValidException exeption, BindingResult errorResult) {
        List<ErrorBodyResponse> errors =  errorResult.getFieldErrors().stream().map(error -> new ErrorBodyResponse(error.getField(), error.getDefaultMessage())).toList();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorBodyResponse> parseJsonError(HttpMessageNotReadableException exeption) {
        ErrorBodyResponse error = new ErrorBodyResponse(exeption.getCause().getMessage(), exeption.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
