package com.guitarradecero.preguntados_de_cero.configuration;

import com.guitarradecero.preguntados_de_cero.model.difficulty.Difficulty;
import com.guitarradecero.preguntados_de_cero.model.option.Option;
import com.guitarradecero.preguntados_de_cero.model.question.Question;
import com.guitarradecero.preguntados_de_cero.model.theme.Theme;
import com.guitarradecero.preguntados_de_cero.service.DifficultyService;
import com.guitarradecero.preguntados_de_cero.service.QuestionService;
import com.guitarradecero.preguntados_de_cero.service.ThemeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final DifficultyService difficultyService;
    private final ThemeService themeService;
    private final QuestionService questionService;

    @Override
    public void run(String... args) throws Exception {

        // niveles
        Difficulty persistedDifficulty1 = difficultyService.save(new Difficulty(1));

        // temas
        Theme persistedTheme1 = themeService.saveTheme(new Theme("Prueba dataseeder", "tema de prueba para ver el funcionamiento del dataseeder") , persistedDifficulty1.getId());

        // preguntas
        List<Option> options = new ArrayList<>();
        options.add(new Option("aaa", false));
        options.add(new Option("bbb", true));
        options.add(new Option("ccc", false));
        options.add(new Option("ddd", false));

        questionService.add(new Question("Esta es una pregunta de prueba para ver si funciona el dataseeder", options), persistedTheme1.getId());

        System.out.println("DATA SEEDER FINALIZO SU TRABAJO");
    }
}
