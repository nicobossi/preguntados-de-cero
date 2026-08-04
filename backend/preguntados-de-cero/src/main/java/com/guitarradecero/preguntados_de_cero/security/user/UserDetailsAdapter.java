package com.guitarradecero.preguntados_de_cero.security.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserDetailsAdapter extends UserDetailsService {
    UserDetails loadUserById(Long id);
}
