package com.guitarradecero.preguntados_de_cero.service.impl;

import com.guitarradecero.preguntados_de_cero.model.difficulty.Difficulty;
import com.guitarradecero.preguntados_de_cero.model.theme.Theme;
import com.guitarradecero.preguntados_de_cero.persistence.sql.difficulty.DifficultyDAO;
import com.guitarradecero.preguntados_de_cero.persistence.sql.theme.ThemeDAO;
import com.guitarradecero.preguntados_de_cero.service.ThemeService;
import com.guitarradecero.preguntados_de_cero.service.exception.NotFoundException;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Setter(AccessLevel.PRIVATE)
@Getter(AccessLevel.PRIVATE)
@Service
@Transactional
public class ThemeServiceImpl implements ThemeService {

    private ThemeDAO themeDao;
    private DifficultyDAO difficultyDao;

    public ThemeServiceImpl(ThemeDAO themeDAO, DifficultyDAO difficultyDAO) {
        setThemeDao(themeDAO);
        setDifficultyDao(difficultyDAO);
    }

    @Override
    public List<Theme> getAllByDifficulty(Long difficultyId) {
        return getThemeDao().findAllByDifficultyId(difficultyId);
    }

    @Override
    public Theme saveTheme(Theme theme, Long difficultyId) {
        Difficulty difficulty = difficultyDao.findById(difficultyId)
                .orElseThrow(() -> new NotFoundException(
                        "Difficulty not found with id: " + difficultyId));

        difficulty.addTheme(theme);

        return getThemeDao().save(theme);
    }
}
