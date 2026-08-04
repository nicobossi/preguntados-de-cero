package com.guitarradecero.preguntados_de_cero.service.impl;

import com.guitarradecero.preguntados_de_cero.model.auth.Auth;
import com.guitarradecero.preguntados_de_cero.model.user.User;
import com.guitarradecero.preguntados_de_cero.security.user.UserDetailsAdapter;
import com.guitarradecero.preguntados_de_cero.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager manager;
    private UserDetailsAdapter detailsService;

    public AuthServiceImpl(AuthenticationManager manager, UserDetailsAdapter detailsService) {
        this.manager = manager;
        this.detailsService = detailsService;
    }

    @Override
    public void initAuthenticate(String email, String password) {
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(email, password);
        manager.authenticate(auth);
    }

    @Override
    public Auth getAuth(User user, String token) {
        return new Auth(user.getEmail(), user.getId(), token);
    }

    @Override
    public void authenticate(Long id) {
        UserDetails details = detailsService.loadUserById(id);
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(details, null, details.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);
    }
}
