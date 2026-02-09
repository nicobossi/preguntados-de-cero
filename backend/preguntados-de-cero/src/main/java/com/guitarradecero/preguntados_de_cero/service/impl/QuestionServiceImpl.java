package com.guitarradecero.preguntados_de_cero.service.impl;

import com.guitarradecero.preguntados_de_cero.model.question.Question;
import com.guitarradecero.preguntados_de_cero.model.theme.Theme;
import com.guitarradecero.preguntados_de_cero.persistence.sql.question.QuestionDAO;
import com.guitarradecero.preguntados_de_cero.persistence.sql.theme.ThemeDAO;
import com.guitarradecero.preguntados_de_cero.service.QuestionService;
import com.guitarradecero.preguntados_de_cero.service.exception.NotFoundException;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter(AccessLevel.PRIVATE)
@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionDAO dao;
    private ThemeDAO themeDao;

    QuestionServiceImpl(QuestionDAO dao, ThemeDAO themeDao) {
        this.dao = dao;
        this.themeDao = themeDao;
    }

    @Override
    public List<Question> findQuestionsByTheme(Long themeId) {
        return getDao().findAllByThemeId(themeId);
    }

    @Override
    public Question add(Question question, Long themeId) {
        Theme theme = getThemeDao().
                findById(themeId).
                    orElseThrow(() -> new NotFoundException("Theme not found with id:" + themeId));

        question.addTheme(theme);

        return getDao().save(question);
    }

    void crearAll() {
        getDao().deleteAll();
        getThemeDao().deleteAll();
    }
}
