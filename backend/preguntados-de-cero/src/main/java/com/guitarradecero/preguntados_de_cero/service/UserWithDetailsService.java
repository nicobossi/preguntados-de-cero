package com.guitarradecero.preguntados_de_cero.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserWithDetailsService {
    UserDetails findUserByEmail(String email);
}
