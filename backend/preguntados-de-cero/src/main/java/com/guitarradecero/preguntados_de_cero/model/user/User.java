package com.guitarradecero.preguntados_de_cero.model.user;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jspecify.annotations.Nullable;

import static jakarta.persistence.GenerationType.AUTO;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "admin")
public class User {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @Column(unique = true)
    private String email;

    private String password;

    public User(String email, String password){
        this.email = email;
        this.password = password;
    }

    public void updatePassword(String encode) {
        setPassword(encode);
    }
}
