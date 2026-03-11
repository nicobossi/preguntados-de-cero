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
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

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

    Boolean existDifferentOptions() {

        List<Option> options = new ArrayList<>(getOptions());

        while(!options.isEmpty() && existDifferentOption(options.getFirst(), options)) {}

        return options.isEmpty();
    }

    private Boolean existDifferentOption(Option first, List<Option> options) {
        options.removeFirst();
        return options.stream().allMatch(option -> !Objects.equals(option.getText(), first.getText()));
    }

    public void addOption(Option option) {
        if(getHaveCorrectOption()) {
            throw new RepeatedCorrectOptionException(repeatedCorrectOptionMessage(option));
        }
        option.adddedQuestion(this);
    }

    String repeatedCorrectOptionMessage(Option option) {
        return "La opción " + option.getText() + " no puede ser la correcta porque la pregunta " + getText() + " ya tiene una opción correcta";
    }

    public void addCorrectOption(Option option) {
        getOptions().add(option);
        setHaveCorrectOption(true);
    }

    public void addFailOption(Option failOption) {
        getOptions().add(failOption);
    }
}
    /*
       a -> [] = true
       b -> [a] = b.text es unico en [a] && hay una opción correcta en [a]
       c -> [a, b] = c.text es unico en [a, b] && hay una opción correcta en [a, b]
       d -> [a, b, c] = d.text es unico en [a, b, c] && hay una opción correcta en [a, b, c]

       Observaciones:
        - Se hace la validación cada vez que se quiere agregar una nueva opción.
        - Permite no tener un objeto inconsistente en el dominio, a la primera que la opción no cumple
          hay error.
        - El peor caso en cuanto a la performance es que todas las opciones sean validas.


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
