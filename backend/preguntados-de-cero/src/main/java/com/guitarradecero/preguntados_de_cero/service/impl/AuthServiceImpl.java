package com.guitarradecero.preguntados_de_cero.service.impl;

import com.guitarradecero.preguntados_de_cero.model.auth.Auth;
import com.guitarradecero.preguntados_de_cero.model.user.User;
import com.guitarradecero.preguntados_de_cero.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager manager;

    public AuthServiceImpl(AuthenticationManager manager) {
        this.manager = manager;
    }

    @Override
    public void initAuthenticate(User user) {
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
        manager.authenticate(auth);
    }

    @Override
    public Auth authenticate(User user, String token) {
        return new Auth(user.getEmail(), user.getId(), user.getPassword(), token);
    }
}
