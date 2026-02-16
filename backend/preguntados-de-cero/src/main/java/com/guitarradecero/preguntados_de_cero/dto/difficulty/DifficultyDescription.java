package com.guitarradecero.preguntados_de_cero.dto.difficulty;


import java.util.List;

public interface DifficultyDescription {
        Long getId();
        Integer getLevel();
        List<String> getThemeNames();
}
