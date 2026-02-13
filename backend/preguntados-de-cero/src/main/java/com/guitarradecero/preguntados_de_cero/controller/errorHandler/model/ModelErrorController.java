package com.guitarradecero.preguntados_de_cero.controller.errorHandler.model;

import com.guitarradecero.preguntados_de_cero.model.ModelException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public abstract class ModelErrorController<T extends ModelException, E> {

    @ExceptionHandler()
    public ResponseEntity<E> errorHandler(ModelException exeption) {
        return ResponseEntity.status(statusError()).body(errorResponse(exeption));
    }

    protected abstract E errorResponse(ModelException exeption);

    protected abstract HttpStatus statusError();
}
