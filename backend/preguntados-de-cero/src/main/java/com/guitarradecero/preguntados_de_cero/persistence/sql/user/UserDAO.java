package com.guitarradecero.preguntados_de_cero.persistence.sql.user;

import com.guitarradecero.preguntados_de_cero.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
    Optional<User> getByEmail(String email);
}
