package com.guitarradecero.preguntados_de_cero.service;

import com.guitarradecero.preguntados_de_cero.model.user.User;

public interface AuthService {
    String register(User user);
    String login(User user);
}
