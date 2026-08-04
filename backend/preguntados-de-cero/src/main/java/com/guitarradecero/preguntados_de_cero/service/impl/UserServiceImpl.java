package com.guitarradecero.preguntados_de_cero.service.impl;

import com.guitarradecero.preguntados_de_cero.model.user.User;
import com.guitarradecero.preguntados_de_cero.persistence.sql.user.UserDAO;
import com.guitarradecero.preguntados_de_cero.service.UserService;
import com.guitarradecero.preguntados_de_cero.service.exception.NotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserDAO dao;
    private PasswordEncoder encoder;

    public UserServiceImpl(UserDAO dao, PasswordEncoder encoder) {
        this.dao = dao;
        this.encoder = encoder;
    }

    @Override
    public User add(User user) {
        String password = encoder.encode(user.getPassword());
        user.updatePassword(password);
        return dao.save(user);
    }

    @Override
    public User getByEmail(String email) {
        return dao.getByEmail(email).orElseThrow(() -> new NotFoundException(getEmailErrorMessage(email)));
    }

    @Override
    public User getById(Long id) {
        return dao.findById(id).orElseThrow(() -> new NotFoundException(getIdErrorMessage(id)));
    }

    @Override
    public boolean existsByEmail(String email) {
        return dao.getByEmail(email).isPresent();
    }

    private String getEmailErrorMessage(String email) {
        return "El mail " + email + "no se encuentra regitrado";
    }

    private String getIdErrorMessage(Long id) {
        return "El mail " + id + "no se encuentra regitrado";
    }

    void clearAll() {
        dao.deleteAll();
    }
}
