package com.guitarradecero.preguntados_de_cero.security.user;

import com.guitarradecero.preguntados_de_cero.model.user.User;
import com.guitarradecero.preguntados_de_cero.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsAdapter {
    private UserService service;

    public UserDetailsServiceImpl(UserService service) {
        this.service = service;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = service.getByEmail(username);
        return new UserDetailsImpl(user);
    }

    @Override
    public UserDetails loadUserById(Long id) {
        User user = service.getById(id);
        return new UserDetailsImpl(user);
    }
}
