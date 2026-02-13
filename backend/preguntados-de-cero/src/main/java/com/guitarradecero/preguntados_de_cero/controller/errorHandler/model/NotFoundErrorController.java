package com.guitarradecero.preguntados_de_cero.controller.errorHandler.model;

import com.guitarradecero.preguntados_de_cero.service.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class NotFoundErrorController extends ModelErrorController<NotFoundException, ErrorModelResponse> {

    @Override
    protected ErrorModelResponse errorResponse(RuntimeException exeption) {
        return new ErrorModelResponse(exeption.getMessage(), new Date());
    }

    @Override
    protected HttpStatus statusError() {
        return HttpStatus.NOT_FOUND;
    }
}
