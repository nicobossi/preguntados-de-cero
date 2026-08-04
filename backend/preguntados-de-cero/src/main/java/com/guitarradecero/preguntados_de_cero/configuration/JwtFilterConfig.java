package com.guitarradecero.preguntados_de_cero.configuration;

import com.guitarradecero.preguntados_de_cero.security.exceptions.TokenExceptionEntrypoint;
import com.guitarradecero.preguntados_de_cero.security.filters.JwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.ExceptionTranslationFilter;

@Configuration
public class JwtFilterConfig {

    private JwtFilter jwtFilter;
    private TokenExceptionEntrypoint tokenException;

    public JwtFilterConfig(JwtFilter jwtFilter, TokenExceptionEntrypoint tokenException) {
        this.jwtFilter = jwtFilter;
        this.tokenException = tokenException;
    }

    @Bean
    @Order(1)
    public SecurityFilterChain chainJwtFilter(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/api/**")
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        auth -> auth
                                .requestMatchers("/api/difficulty/add").authenticated()
                                .requestMatchers("/api/theme/add/*").authenticated()
                                .requestMatchers("/api/question/add/*").authenticated()
                                .anyRequest().permitAll())
                .exceptionHandling(exception -> exception.authenticationEntryPoint(tokenException))
                .addFilterAfter(jwtFilter, ExceptionTranslationFilter.class);


        return http.build();
    }
}
