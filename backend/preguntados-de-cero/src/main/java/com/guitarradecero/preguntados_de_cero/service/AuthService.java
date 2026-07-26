package com.guitarradecero.preguntados_de_cero.service;

import com.guitarradecero.preguntados_de_cero.model.auth.Auth;
import com.guitarradecero.preguntados_de_cero.model.user.User;

public interface AuthService {
    void initAuthenticate(User user);
    Auth authenticate(User user, String token);
}
