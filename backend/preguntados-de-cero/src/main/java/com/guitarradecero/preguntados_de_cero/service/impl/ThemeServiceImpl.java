package com.guitarradecero.preguntados_de_cero.service.impl;

import com.guitarradecero.preguntados_de_cero.model.difficulty.Difficulty;
import com.guitarradecero.preguntados_de_cero.model.theme.Theme;
import com.guitarradecero.preguntados_de_cero.persistence.DifficultyDAO;
import com.guitarradecero.preguntados_de_cero.persistence.ThemeDAO;
import com.guitarradecero.preguntados_de_cero.service.ThemeService;
import com.guitarradecero.preguntados_de_cero.service.exception.DifficultyNotFoundException;
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

    public ThemeServiceImpl(ThemeDAO themeDAO, DifficultyDAO difficultyDAO){
        setThemeDAO(themeDAO);
        setDifficultyDAO(difficultyDAO);
    }

    @Override
    public List<Theme> getAllByDifficultyLevel(Integer level) {
        return getThemeDAO().findAllByDifficulty_Level(level);
    }

    @Override
    public Theme saveTheme(Theme theme, Long difficultyId) {
        Difficulty difficulty = difficultyDAO.findById(difficultyId)
                .orElseThrow(() -> new DifficultyNotFoundException(
                        "Difficulty not found with id: " + difficultyId)); // los mensajes deberian ir en esp?

        theme.asociateDifficulty(difficulty);

        return themeDAO.save(theme);
    }
}
