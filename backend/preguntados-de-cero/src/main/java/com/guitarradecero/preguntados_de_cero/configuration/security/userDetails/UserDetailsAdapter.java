package com.guitarradecero.preguntados_de_cero.configuration.security.userDetails;

import com.guitarradecero.preguntados_de_cero.model.user.Role;
import com.guitarradecero.preguntados_de_cero.model.user.User;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;

public class UserDetailsAdapter implements UserDetails {

    private final Long id;
    private final String email;
    private final String password;
    private final Role role;

    public UserDetailsAdapter(User user){
        this.id = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.role = user.getRole();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public @Nullable String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    // de aca para abajo lo revisa el jwtservice entonces no hacen falta estas verificaciones por eso el hardcodeo
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
