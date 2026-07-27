package com.guitarradecero.preguntados_de_cero.orchestrator.impl;

import com.guitarradecero.preguntados_de_cero.model.auth.Auth;
import com.guitarradecero.preguntados_de_cero.model.user.User;
import com.guitarradecero.preguntados_de_cero.orchestrator.AuthOrchestrator;
import com.guitarradecero.preguntados_de_cero.service.AuthService;
import com.guitarradecero.preguntados_de_cero.service.JwtService;
import com.guitarradecero.preguntados_de_cero.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class AuthOrchestratorImpl implements AuthOrchestrator {

    private JwtService jwtService;
    private AuthService authService;
    private UserService userService;

    public AuthOrchestratorImpl(JwtService jwtService, AuthService authService, UserService userService) {
        this.jwtService = jwtService;
        this.authService = authService;
        this.userService = userService;
    }

    @Override
    public Auth auth(String email, String password) {
        authService.initAuthenticate(email, password);
        User user = userService.getByEmail(email);
        String token = jwtService.generateToken(user);
        return authService.getAuth(user, token);
    }
}
