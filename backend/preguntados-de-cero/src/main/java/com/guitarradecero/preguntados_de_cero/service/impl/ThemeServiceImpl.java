package com.guitarradecero.preguntados_de_cero.service.impl;

import com.guitarradecero.preguntados_de_cero.model.theme.Theme;
import com.guitarradecero.preguntados_de_cero.persistence.DifficultyDAO;
import com.guitarradecero.preguntados_de_cero.persistence.ThemeDAO;
import com.guitarradecero.preguntados_de_cero.service.ThemeService;
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

    private ThemeDAO themeDAO;
    private DifficultyDAO difficultyDAO;

    public ThemeServiceImpl(ThemeDAO themeDAO){
        setThemeDAO(themeDAO);
    }

    @Override
    public List<Theme> getAllByDifficultyLevel(Integer level) {
        return getThemeDAO().findAllByDifficulty_Level(level);
    }

    @Override
    public Theme saveTheme(Theme theme, Integer difficultyLevel) {
        getDifficultyDAO().findByLevel(difficultyLevel);

        return getThemeDAO().save(theme);
    }
}
