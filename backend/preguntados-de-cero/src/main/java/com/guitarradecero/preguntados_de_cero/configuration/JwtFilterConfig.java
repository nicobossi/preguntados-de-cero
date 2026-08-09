package com.guitarradecero.preguntados_de_cero.configuration;

import com.guitarradecero.preguntados_de_cero.security.exceptions.TokenExceptionEntrypoint;
import com.guitarradecero.preguntados_de_cero.security.filters.JwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

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
                .cors(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        auth -> auth
                                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                                .requestMatchers("/api/difficulty/add").authenticated()
                                .requestMatchers("/api/theme/add/*").authenticated()
                                .requestMatchers("/api/question/add/*").authenticated()
                                .requestMatchers("/api/user/me").authenticated()
                                .anyRequest().permitAll())
                .exceptionHandling(exception -> exception.authenticationEntryPoint(tokenException))
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);


        return http.build();
    }
}
