package com.guitarradecero.preguntados_de_cero.model.difficulty;

import com.guitarradecero.preguntados_de_cero.model.theme.Theme;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.GenerationType.AUTO;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Difficulty {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @Column(unique = true)
    private Integer level;

    @OneToMany(mappedBy = "difficulty", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Theme> themes = new HashSet<>();

    public Difficulty(Integer level) {
        setLevel(level);
    }

    public void addTheme(Theme theme) {
        getThemes().add(theme);
        theme.addDifficulty(this);
    }
}
