package com.guitarradecero.preguntados_de_cero.service;

import com.guitarradecero.preguntados_de_cero.model.user.User;

public interface UserService {
    User add(User user);
    User getByEmail(String email);
    User getById(Long username);
}
