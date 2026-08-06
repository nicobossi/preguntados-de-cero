package com.guitarradecero.preguntados_de_cero.service.impl;

import com.guitarradecero.preguntados_de_cero.dto.question.QuestionWithOptions;
import com.guitarradecero.preguntados_de_cero.model.option.Option;
import com.guitarradecero.preguntados_de_cero.model.question.Question;
import com.guitarradecero.preguntados_de_cero.model.theme.Theme;
import com.guitarradecero.preguntados_de_cero.persistence.sql.question.QuestionDAO;
import com.guitarradecero.preguntados_de_cero.persistence.sql.theme.ThemeDAO;
import com.guitarradecero.preguntados_de_cero.service.QuestionService;
import com.guitarradecero.preguntados_de_cero.service.exception.NotFoundException;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Getter(AccessLevel.PRIVATE)
@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

    private QuestionDAO questionDao;
    private ThemeDAO themeDao;

    QuestionServiceImpl(QuestionDAO dao, ThemeDAO themeDao) {
        this.questionDao = dao;
        this.themeDao = themeDao;
    }

    @Override
    public List<QuestionWithOptions> findQuestionsByTheme(Long themeId) {
        return getQuestionDao().findByThemeId(themeId);
    }

    @Override
    public Question add(Question question, Long themeId, List<Option> options) {
        Theme theme = getThemeDao().
                findById(themeId).
                    orElseThrow(() -> new NotFoundException("Theme not found with id: " + themeId));

        question.addTheme(theme);
        question.verifyCandidatesOptions(options);

        return getQuestionDao().save(question);
    }

    void clearAll() {
        getThemeDao().deleteAll();
        getQuestionDao().deleteAll();
    }
}
