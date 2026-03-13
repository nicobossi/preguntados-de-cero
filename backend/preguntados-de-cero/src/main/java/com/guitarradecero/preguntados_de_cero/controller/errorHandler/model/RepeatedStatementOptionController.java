package com.guitarradecero.preguntados_de_cero.controller.errorHandler.model;

import com.guitarradecero.preguntados_de_cero.model.ModelException;
import com.guitarradecero.preguntados_de_cero.model.option.RepeatedStatementOptionException;
import org.springframework.http.HttpStatus;

import java.util.Date;

public class RepeatedStatementOptionController extends ModelErrorController<RepeatedStatementOptionException, ErrorModelResponse>{

    @Override
    protected ErrorModelResponse errorResponse(ModelException exeption) {
        return new ErrorModelResponse(exeption.getMessage(), new Date());
    }

    @Override
    protected HttpStatus statusError() {
        return HttpStatus.BAD_REQUEST;
    }
}
