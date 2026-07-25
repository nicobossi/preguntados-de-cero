package com.guitarradecero.preguntados_de_cero.configuration.seeders;

import com.guitarradecero.preguntados_de_cero.model.difficulty.Difficulty;
import com.guitarradecero.preguntados_de_cero.model.option.CorrectOption;
import com.guitarradecero.preguntados_de_cero.model.option.FailOption;
import com.guitarradecero.preguntados_de_cero.model.option.Option;
import com.guitarradecero.preguntados_de_cero.model.question.Question;
import com.guitarradecero.preguntados_de_cero.model.theme.Theme;
import com.guitarradecero.preguntados_de_cero.service.DifficultyService;
import com.guitarradecero.preguntados_de_cero.service.QuestionService;
import com.guitarradecero.preguntados_de_cero.service.ThemeService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;

import java.util.*;

//@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final DifficultyService difficultyService;
    private final ThemeService themeService;
    private final QuestionService questionService;
    private Random random = new Random();

    @Override
    public void run(String... args) throws Exception {

        // niveles (dificultad)
        Difficulty persistedDifficulty1 = difficultyService.save(new Difficulty(1));
        Difficulty persistedDifficulty2 = difficultyService.save(new Difficulty(2));
        Difficulty persistedDifficulty3 = difficultyService.save(new Difficulty(3));
        //id de los niveles de dif
        Long idDifficulty1 = persistedDifficulty1.getId();
        Long idDifficulty2 = persistedDifficulty2.getId();
        Long idDifficulty3 = persistedDifficulty3.getId();

        //####################################################################

        // temas (tematica)
        // temas niv 1
        Theme persistedThemeA1 = themeService.saveTheme(new Theme("Tema A1", randomThemeDescription()) , idDifficulty1);
        Theme persistedThemeB1 = themeService.saveTheme(new Theme("Tema B1", randomThemeDescription()) , idDifficulty1);
        Theme persistedThemeC1 = themeService.saveTheme(new Theme("Tema C1", randomThemeDescription()) , idDifficulty1);
        Theme persistedThemeD1 = themeService.saveTheme(new Theme("Tema D1", randomThemeDescription()) , idDifficulty1);
        Theme persistedThemeE1 = themeService.saveTheme(new Theme("Tema E1", randomThemeDescription()) , idDifficulty1);
        Theme persistedThemeF1 = themeService.saveTheme(new Theme("Tema F1", randomThemeDescription()) , idDifficulty1);
        // temas niv 2
        Theme persistedThemeA2 = themeService.saveTheme(new Theme("Tema A2", randomThemeDescription()) , idDifficulty2);
        Theme persistedThemeB2 = themeService.saveTheme(new Theme("Tema B2", randomThemeDescription()) , idDifficulty2);
        Theme persistedThemeC2 = themeService.saveTheme(new Theme("Tema C2", randomThemeDescription()) , idDifficulty2);
        Theme persistedThemeD2 = themeService.saveTheme(new Theme("Tema D2", randomThemeDescription()) , idDifficulty2);
        Theme persistedThemeE2 = themeService.saveTheme(new Theme("Tema E2", randomThemeDescription()) , idDifficulty2);
        Theme persistedThemeF2 = themeService.saveTheme(new Theme("Tema F2", randomThemeDescription()) , idDifficulty2);
        // temas niv 3
        Theme persistedThemeA3 = themeService.saveTheme(new Theme("Tema A3", randomThemeDescription()) , idDifficulty3);
        Theme persistedThemeB3 = themeService.saveTheme(new Theme("Tema B3", randomThemeDescription()) , idDifficulty3);
        Theme persistedThemeC3 = themeService.saveTheme(new Theme("Tema C3", randomThemeDescription()) , idDifficulty3);
        Theme persistedThemeD3 = themeService.saveTheme(new Theme("Tema D3", randomThemeDescription()) , idDifficulty3);
        Theme persistedThemeE3 = themeService.saveTheme(new Theme("Tema E3", randomThemeDescription()) , idDifficulty3);
        Theme persistedThemeF3 = themeService.saveTheme(new Theme("Tema F3", randomThemeDescription()) , idDifficulty3);
        //ids de los temas por nivel
        // niv 1
        Long idThemeA1 = persistedThemeA1.getId();
        Long idThemeB1 = persistedThemeB1.getId();
        Long idThemeC1 = persistedThemeC1.getId();
        Long idThemeD1 = persistedThemeD1.getId();
        Long idThemeE1 = persistedThemeE1.getId();
        Long idThemeF1 = persistedThemeF1.getId();
        // niv 2
        Long idThemeA2 = persistedThemeA2.getId();
        Long idThemeB2 = persistedThemeB2.getId();
        Long idThemeC2 = persistedThemeC2.getId();
        Long idThemeD2 = persistedThemeD2.getId();
        Long idThemeE2 = persistedThemeE2.getId();
        Long idThemeF2 = persistedThemeF2.getId();
        // niv 3
        Long idThemeA3 = persistedThemeA3.getId();
        Long idThemeB3 = persistedThemeB3.getId();
        Long idThemeC3 = persistedThemeC3.getId();
        Long idThemeD3 = persistedThemeD3.getId();
        Long idThemeE3 = persistedThemeE3.getId();
        Long idThemeF3 = persistedThemeF3.getId();

        //####################################################################

        // preguntas
        // para el tema A1
        questionService.add(new Question(randomQuestionText()), idThemeA1, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeA1, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeA1, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeA1, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeA1, randomOptionList());
        // para el tema A2
        questionService.add(new Question(randomQuestionText()), idThemeA2, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeA2, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeA2, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeA2, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeA2, randomOptionList());
        // para el tema A3
        questionService.add(new Question(randomQuestionText()), idThemeA3, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeA3, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeA3, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeA3, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeA3, randomOptionList());

        // para el tema B1
        questionService.add(new Question(randomQuestionText()), idThemeB1, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeB1, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeB1, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeB1, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeB1, randomOptionList());
        // para el tema B2
        questionService.add(new Question(randomQuestionText()), idThemeB2, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeB2, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeB2, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeB2, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeB2, randomOptionList());
        // para el tema B3
        questionService.add(new Question(randomQuestionText()), idThemeB3, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeB3, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeB3, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeB3, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeB3, randomOptionList());

        // para el tema C1
        questionService.add(new Question(randomQuestionText()), idThemeC1, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeC1, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeC1, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeC1, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeC1, randomOptionList());
        // para el tema C2
        questionService.add(new Question(randomQuestionText()), idThemeC2, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeC2, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeC2, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeC2, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeC2, randomOptionList());
        // para el tema C3
        questionService.add(new Question(randomQuestionText()), idThemeC3, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeC3, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeC3, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeC3, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeC3, randomOptionList());

        // para el tema D1
        questionService.add(new Question(randomQuestionText()), idThemeD1, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeD1, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeD1, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeD1, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeD1, randomOptionList());
        // para el tema D2
        questionService.add(new Question(randomQuestionText()), idThemeD2, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeD2, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeD2, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeD2, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeD2, randomOptionList());
        // para el tema D3
        questionService.add(new Question(randomQuestionText()), idThemeD3, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeD3, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeD3, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeD3, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeD3, randomOptionList());

        // para el tema E1
        questionService.add(new Question(randomQuestionText()), idThemeE1, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeE1, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeE1, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeE1, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeE1, randomOptionList());
        // para el tema E2
        questionService.add(new Question(randomQuestionText()), idThemeE2, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeE2, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeE2, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeE2, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeE2, randomOptionList());
        // para el tema E3
        questionService.add(new Question(randomQuestionText()), idThemeE3, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeE3, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeE3, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeE3, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeE3, randomOptionList());

        // para el tema F1
        questionService.add(new Question(randomQuestionText()), idThemeF1, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeF1, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeF1, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeF1, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeF1, randomOptionList());
        // para el tema F2
        questionService.add(new Question(randomQuestionText()), idThemeF2, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeF2, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeF2, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeF2, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeF2, randomOptionList());
        // para el tema F3
        questionService.add(new Question(randomQuestionText()), idThemeF3, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeF3, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeF3, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeF3, randomOptionList());
        questionService.add(new Question(randomQuestionText()), idThemeF3, randomOptionList());

        System.out.println("DATA SEEDER FINALIZO SU TRABAJO");
    }

    //####################################################################

    // auxs
    private String randomThemeDescription(){
        int index = random.nextInt(5); // entre 0 y 4

        String[] loremImpsum =
                {
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                        "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                        "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.",
                        "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                        "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo."
                };

        return loremImpsum[index];
    }

    private String randomQuestionText(){
        int index = random.nextInt(5); // entre 0 y 4

        String[] loremImpsum =
                {
                        "¿Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua?",
                        "¿Quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat?",
                        "¿Quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? ",
                        "¿Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit?",
                        "¿Natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis?"
                };

        return loremImpsum[index];
    }

    private String randomAnswerOptionText(){
        int index = random.nextInt(5); // entre 0 y 4

        String[] loremImpsum =
                {
                        "Lorem ipsum dolor in reprehenderit ut labore et dolore magna aliqua varius.",
                        "Excepteur sint dolor sit amet cupidatat non proident sed tempor incididunt.",
                        "Ut enim ad minim veniam in voluptate velit esse cillum dolore magna.",
                        "Duis aute irure dolor in lorem ipsum exercitation ullamco laboris nisi.",
                        "Sed do eiusmod tempor occaecat cupidatat non proident anim laborum nulla."
                };

        return loremImpsum[index];
    }

    private List<Option> randomOptionList(){
        Set<Option> set = new HashSet<>();
        agregarSi(set, randomAnswerOptionText(), false);
        agregarSi(set, randomAnswerOptionText(), false);
        agregarSi(set, randomAnswerOptionText(), false);
        agregarSi(set, randomAnswerOptionText(), true);

        return new ArrayList<>(set);
    }

    private void agregarSi(Set<Option> setOp, String op, boolean bool){ // peligrosa, es solo una prueba para no tener texto repetido pero puede llevar a stack overflow en el peor caso...
        if(setOp.stream().anyMatch(option -> option.getText().equals(op))){
            agregarSi(setOp, randomAnswerOptionText(), bool);
        } else {
            setOp.add(createOptionFor(op, bool));
        }
    }

    private Option createOptionFor(String text, boolean bool){
        if(bool){
            return new CorrectOption(text);
        } else {
            return new FailOption(text);
        }
    }
}
