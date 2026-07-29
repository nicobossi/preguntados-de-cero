package com.guitarradecero.preguntados_de_cero.security.filters;

import com.guitarradecero.preguntados_de_cero.service.AuthService;
import com.guitarradecero.preguntados_de_cero.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpMethod;
import org.springframework.security.web.servlet.util.matcher.PathPatternRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private JwtService jwtService;
    private AuthService authService;

    public JwtFilter(JwtService jwtService, AuthService authService) {
        this.jwtService = jwtService;
        this.authService = authService;
    }

    private static final List<RequestMatcher> PROTECTED_ENDPOINTS = List.of(
            PathPatternRequestMatcher.withDefaults().matcher(HttpMethod.POST, "/api/difficulty/add"),
            PathPatternRequestMatcher.withDefaults().matcher(HttpMethod.POST, "/api/theme/add/*"),
            PathPatternRequestMatcher.withDefaults().matcher(HttpMethod.POST, "/api/question/add/*")
    );

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return PROTECTED_ENDPOINTS.stream().noneMatch(path -> path.matches(request));
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        String username = jwtService.getPayload(token);
        authService.authenticate(Long.valueOf(username));
        filterChain.doFilter(request, response);
    }
}
