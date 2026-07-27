package com.guitarradecero.preguntados_de_cero.service.impl;

import com.guitarradecero.preguntados_de_cero.model.auth.Auth;
import com.guitarradecero.preguntados_de_cero.model.user.User;
import com.guitarradecero.preguntados_de_cero.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager manager;
    private UserDetailsService detailsService;

    public AuthServiceImpl(AuthenticationManager manager, UserDetailsService detailsService) {
        this.manager = manager;
        this.detailsService = detailsService;
    }

    @Override
    public void initAuthenticate(String email, String password) {
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(email, password);
        manager.authenticate(auth);
    }

    @Override
    public Auth authenticate(User user, String token) {
        return new Auth(user.getEmail(), user.getId(), user.getPassword(), token);
    }
}
