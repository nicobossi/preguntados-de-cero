package com.guitarradecero.preguntados_de_cero.service.impl;

import com.guitarradecero.preguntados_de_cero.model.difficulty.Difficulty;
import com.guitarradecero.preguntados_de_cero.persistence.sql.difficulty.DifficultyDAO;
import com.guitarradecero.preguntados_de_cero.model.difficulty.LevelRepeatException;
import com.guitarradecero.preguntados_de_cero.persistence.sql.theme.ThemeDAO;
import com.guitarradecero.preguntados_de_cero.service.DifficultyService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Setter(AccessLevel.PRIVATE)
@Getter(AccessLevel.PRIVATE)
@Service
@Transactional
public class DifficultyServiceImpl implements DifficultyService {

    private DifficultyDAO difficultyDao;
    private ThemeDAO themeDAO;

    public DifficultyServiceImpl(DifficultyDAO dao, ThemeDAO themeDAO){
        setThemeDAO(themeDAO);
        setDifficultyDao(dao);
    }

    @Override
    public List<Difficulty> allLevelsWithThemes() {
        return getDifficultyDao().findAllByOrderByLevel();
    }

    @Override
    public Difficulty save(Difficulty difficulty) {
        try {
            return getDifficultyDao().saveAndFlush(difficulty);
        }
        catch(DataIntegrityViolationException e){
            throw new LevelRepeatException("Level " + difficulty.getLevel() + " is already registered");
        }
    }

    void clearAll() {
        getThemeDAO().deleteAll();
        getDifficultyDao().deleteAll();
    }
}
