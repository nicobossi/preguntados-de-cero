package com.guitarradecero.preguntados_de_cero.service;

import com.guitarradecero.preguntados_de_cero.model.question.Question;

import java.util.List;

public interface QuestionService {
    List<Question> findQuestionsByTheme(Long themeId);

    Question add(Question question, Long themeId);
}
