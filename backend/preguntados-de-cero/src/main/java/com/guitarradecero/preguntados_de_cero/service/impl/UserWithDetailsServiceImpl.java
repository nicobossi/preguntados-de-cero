package com.guitarradecero.preguntados_de_cero.service.impl;

import com.guitarradecero.preguntados_de_cero.configuration.security.userDetails.UserDetailsImpl;
import com.guitarradecero.preguntados_de_cero.model.user.User;
import com.guitarradecero.preguntados_de_cero.persistence.sql.user.UserDAO;
import com.guitarradecero.preguntados_de_cero.service.UserWithDetailsService;
import com.guitarradecero.preguntados_de_cero.service.exception.NotFoundException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Setter
@Getter
@Service
@Transactional
public class UserWithDetailsServiceImpl implements UserWithDetailsService {

    private UserDAO userDAO;

    public UserWithDetailsServiceImpl(UserDAO dao){
        this.userDAO = dao;
    }

    @Override
    public UserDetails findUserByEmail(String email) {
        User user = getUserDAO().findByEmail(email)
                .orElseThrow(() -> new NotFoundException("User not found with email: " + email));
        return new UserDetailsImpl(user);
    }
}
