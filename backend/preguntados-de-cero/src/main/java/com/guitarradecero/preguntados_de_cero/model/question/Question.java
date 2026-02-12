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
    @JoinColumn(name = "id_theme")
    private Theme theme;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_question")
    private List<Option> options = new ArrayList<>();

    public Question(String text, List<Option> options) {
        setText(text);
        setOptions(options);
    }

    public void addTheme(Theme theme) {
        setTheme(theme);
    }
}
