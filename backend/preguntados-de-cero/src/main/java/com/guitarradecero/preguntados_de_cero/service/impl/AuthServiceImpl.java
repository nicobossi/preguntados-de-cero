package com.guitarradecero.preguntados_de_cero.service.impl;

import com.guitarradecero.preguntados_de_cero.configuration.security.userDetails.UserDetailsAdapter;
import com.guitarradecero.preguntados_de_cero.dto.auth.UserAuthRequestDTO;
import com.guitarradecero.preguntados_de_cero.dto.auth.UserAuthResponseDTO;
import com.guitarradecero.preguntados_de_cero.model.user.Role;
import com.guitarradecero.preguntados_de_cero.model.user.User;
import com.guitarradecero.preguntados_de_cero.persistence.sql.user.UserDAO;
import com.guitarradecero.preguntados_de_cero.service.AuthService;
import com.guitarradecero.preguntados_de_cero.service.JwtService;
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
    public UserAuthResponseDTO login(UserAuthRequestDTO request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.email(), request.password()));
        UserDetails user = userDetailsAdapterService.findUserByEmail(request.email());
        return new UserAuthResponseDTO(jwtService.getToken(user));
    }

    @Override
    public UserAuthResponseDTO register(UserAuthRequestDTO request) { // esto deberia retornar User
        User user = new User(request.email(), passwordEncoder.encode(request.password()), Role.ADMIN); // unico usuario
        UserDetails userDetails = new UserDetailsAdapter(getUserDAO().save(user)); // adapter?

        return new UserAuthResponseDTO(getJwtService().getToken(userDetails));

    }
}
