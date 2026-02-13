package com.guitarradecero.preguntados_de_cero.controller.errorHandler.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public abstract class ModelErrorController<T extends RuntimeException, E> {

    @ExceptionHandler()
    public ResponseEntity<E> errorHandler(RuntimeException exeption) {
        return ResponseEntity.status(statusError()).body(errorResponse(exeption));
    }

    protected abstract E errorResponse(RuntimeException exeption);

    protected abstract HttpStatus statusError();
}
