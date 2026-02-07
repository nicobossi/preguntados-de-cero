package com.guitarradecero.preguntados_de_cero.persistence.sql.question;

import com.guitarradecero.preguntados_de_cero.persistence.sql.option.OptionEntity;

import java.util.List;

public record QuestionEntity(
        Integer id,
        String text,
        List<OptionEntity> options
) {}
