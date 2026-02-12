package com.guitarradecero.preguntados_de_cero.controller.errorHandler.model;

import com.guitarradecero.preguntados_de_cero.persistence.LevelRepeatException;
import com.guitarradecero.preguntados_de_cero.service.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class ModelErrorHandler {

    @ExceptionHandler(LevelRepeatException.class)
    public ResponseEntity<ErrorModelResponse> repeatLevelErrorResponse(LevelRepeatException exception) {
        ErrorModelResponse errorResponse = new ErrorModelResponse(exception.getMessage(), new Date());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorModelResponse> notFoundResponse(NotFoundException exception) {
        ErrorModelResponse errorResponse = new ErrorModelResponse(exception.getMessage(), new Date());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
