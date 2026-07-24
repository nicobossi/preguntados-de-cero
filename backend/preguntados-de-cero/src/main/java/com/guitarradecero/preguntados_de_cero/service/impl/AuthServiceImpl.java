package com.guitarradecero.preguntados_de_cero.service.impl;

import com.guitarradecero.preguntados_de_cero.model.user.User;
import com.guitarradecero.preguntados_de_cero.persistence.sql.user.UserDAO;
import com.guitarradecero.preguntados_de_cero.service.AuthService;
import com.guitarradecero.preguntados_de_cero.service.exception.NotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {
    private UserDAO dao;

    public AuthServiceImpl(UserDAO dao) {
        this.dao = dao;
    }

    @Override
    public User add(User user) {
        //String password = encoder.encode(user.getPassword());
        //user.updatePassword(password);
        return dao.save(user);
    }

    @Override
    public User getByEmail(String email) {
        return dao.getByEmail(email).orElseThrow(() -> new NotFoundException(getMessage(email)));
    }

    private String getMessage(String email) {
        return "El mail " + email + "no se encuentra regitrado";
    }

    void clearAll() {
        dao.deleteAll();
    }
}
