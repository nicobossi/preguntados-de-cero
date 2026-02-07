package com.guitarradecero.preguntados_de_cero.service.impl;

import com.guitarradecero.preguntados_de_cero.persistence.sql.question.QuestionDAO;
import com.guitarradecero.preguntados_de_cero.persistence.sql.question.QuestionEntity;
import com.guitarradecero.preguntados_de_cero.service.QuestionService;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter(AccessLevel.PRIVATE)
@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionDAO dao;

    QuestionServiceImpl(QuestionDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<QuestionEntity> findQuestionsBy(Long themeId) {
        return getDao().findAllByTheme_Id(themeId);
    }
}
