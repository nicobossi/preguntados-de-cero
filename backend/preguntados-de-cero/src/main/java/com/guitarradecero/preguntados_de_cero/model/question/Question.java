package com.guitarradecero.preguntados_de_cero.model.question;

import com.guitarradecero.preguntados_de_cero.model.option.Option;
import com.guitarradecero.preguntados_de_cero.model.theme.Theme;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Question {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    private String text;

    @ManyToOne
    @JoinColumn(name = "theme_id")
    private Theme theme;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_question")
    private List<Option> options = new ArrayList<>();

    @Getter(AccessLevel.PRIVATE)
    @Transient
    private Boolean haveCorrectOption;

    public Question(String text, List<Option> options) {
        setText(text);
        //setOptions(options);
        setOptions(new ArrayList<>());
        setHaveCorrectOption(false);
    }

    public void addTheme(Theme theme) {
        setTheme(theme);
    }

    public void addOption(Option option) {
        if(isCandidatedOption(option)) {
            throw new RepeatedCorrectOptionException(repeatedCorrectOptionMessage(option));
        }
        option.adddedQuestion(this);
    }

    public void addCorrectOption(Option option) {
        getOptions().add(option);
        setHaveCorrectOption(true);
    }

    public void addFailOption(Option failOption) {
        getOptions().add(failOption);
    }

    public List<String> optionsStatements() {
        return getOptions().stream().map(Option::getText).toList();
    }

    private Boolean isCandidatedOption(Option option) {
        return getHaveCorrectOption() && option.getIsCorrect();
    }

    String repeatedCorrectOptionMessage(Option option) {
        return "La opción " + option.getText() + " no puede ser la correcta porque la pregunta " + getText() + " ya tiene una opción correcta";
    }
}
    /*
        Final:
            - Recibir una opción por parametro para agregar.
            - Si existe una opción correcta en el campo Optional, lanzar excepción.
            - Validar si el enunciado de la opción a agregar es único. Si lo es agregarla, sino lanzar error.
                1. Delegar en la opción, pasarle la pregunta.
                2. Hacer que la pregunta devuelva todos los enunciados para la opción.
                3. Comparar si alguna es igual al de la opción actual.
                    - Si es lanzar excepción
                    - Sino agregar la opción
            - Sí la opción es correcta, agregarla a la lista y a la variable de instancia optional.
            - Si la opción es incorrecta, agregarla solo a la lista.
    */
