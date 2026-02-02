package com.guitarradecero.preguntados_de_cero.model.theme;

import com.guitarradecero.preguntados_de_cero.model.difficulty.Difficulty;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.AUTO;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)

@Entity
public class Theme {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "difficulty_id", nullable = false)
    private Difficulty difficulty;

    public Theme(String name, String description){
        setName(name);
        setDescription(description);
    }

    public void asociateDifficulty(Difficulty difficulty){
        setDifficulty(difficulty);
    }

    public Integer getDifficultyLevel() {
        return getDifficulty().getLevel();
    }
}
