package com.guitarradecero.preguntados_de_cero.service;

import com.guitarradecero.preguntados_de_cero.model.user.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthService {
    UserDetails register(User user);
    UserDetails login(User user);
}
