package com.guitarradecero.preguntados_de_cero.service.impl;

import com.guitarradecero.preguntados_de_cero.configuration.security.userDetails.UserDetailsAdapter;
import com.guitarradecero.preguntados_de_cero.model.user.Role;
import com.guitarradecero.preguntados_de_cero.model.user.User;
import com.guitarradecero.preguntados_de_cero.persistence.sql.user.UserDAO;
import com.guitarradecero.preguntados_de_cero.service.AuthService;
import com.guitarradecero.preguntados_de_cero.configuration.jwt.jwtService.JwtService;
import com.guitarradecero.preguntados_de_cero.service.UserDetailsAdapterService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Setter
@Getter
@Service
@Transactional
public class AuthServiceImpl implements AuthService {

    private UserDAO userDAO;
    private JwtService jwtService;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private UserDetailsAdapterService userDetailsAdapterService;

    public AuthServiceImpl(UserDAO dao, JwtService jwtService, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, UserDetailsAdapterService userDetailsAdapterService){
        this.userDAO = dao;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.userDetailsAdapterService = userDetailsAdapterService;
    }

    @Override
    public UserDetails login(User user) {
        getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
        return getUserDetailsAdapterService().findUserByEmail(user.getEmail());
    }

    @Override
    public UserDetails register(User user) {
        User persistedUser = getUserDAO().save(encryptPasswordAndSetRole(user));
        return new UserDetailsAdapter(persistedUser);
    }

    private User encryptPasswordAndSetRole(User user) {
        user.setPassword(getPasswordEncoder().encode(user.getPassword()));
        user.setRole(Role.ADMIN);
        return user;
    }
}
