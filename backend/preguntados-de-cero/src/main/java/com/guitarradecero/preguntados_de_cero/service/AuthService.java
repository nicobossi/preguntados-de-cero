package com.guitarradecero.preguntados_de_cero.service;

import com.guitarradecero.preguntados_de_cero.model.auth.Auth;
import com.guitarradecero.preguntados_de_cero.model.user.User;

public interface AuthService {
    void initAuthenticate(String email, String password);
    Auth getAuth(User user, String token);
    void authenticate(Long id);
}
