package com.guitarradecero.preguntados_de_cero.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.AUTO;

@Getter
@Setter
@NoArgsConstructor

@Entity
public class Nivel {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    private String nombre;

}
