package com.guitarradecero.preguntados_de_cero.service;

import com.guitarradecero.preguntados_de_cero.persistence.sql.question.QuestionEntity;

import java.util.List;

public interface QuestionService {
    List<QuestionEntity> findQuestionsBy(Long themeId);
}
