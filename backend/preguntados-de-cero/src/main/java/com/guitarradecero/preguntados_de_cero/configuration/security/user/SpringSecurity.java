package com.guitarradecero.preguntados_de_cero.configuration.security.user;

import com.guitarradecero.preguntados_de_cero.service.impl.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SpringSecurity {

    @Bean
    public SecurityFilterChain permitedRoutes(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth ->
                auth.requestMatchers("/api/auth/**").permitAll().anyRequest().authenticated()
        );
        return http.build();
    }

    @Bean
    public AuthenticationManager manager(AuthenticationConfiguration configuration) {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public AuthenticationProvider provider(
            UserDetailsServiceImpl service,
            PasswordEncoder encoder
    ) {
        DaoAuthenticationProvider dao = new DaoAuthenticationProvider(service);
        dao.setPasswordEncoder(encoder);
        return dao;
    }
}
