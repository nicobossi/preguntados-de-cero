package com.guitarradecero.preguntados_de_cero.persistence;

import com.guitarradecero.preguntados_de_cero.model.theme.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThemeDAO extends JpaRepository<Theme,Long> {
    List<Theme> findAllByDifficulty_Level(Integer difficultyLevel);

    List<Theme> findAllByDifficultyId(Long difficultyId);
}
