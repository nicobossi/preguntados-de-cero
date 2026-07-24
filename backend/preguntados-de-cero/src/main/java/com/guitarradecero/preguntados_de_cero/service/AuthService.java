package com.guitarradecero.preguntados_de_cero.service;

import com.guitarradecero.preguntados_de_cero.model.user.User;

public interface AuthService {
    User add(User user);

    User getByEmail(String email);
}
