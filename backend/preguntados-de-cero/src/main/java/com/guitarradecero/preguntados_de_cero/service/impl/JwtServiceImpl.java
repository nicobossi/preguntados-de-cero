package com.guitarradecero.preguntados_de_cero.service.impl;

import com.guitarradecero.preguntados_de_cero.model.user.User;
import com.guitarradecero.preguntados_de_cero.security.TokenException;
import com.guitarradecero.preguntados_de_cero.service.JwtService;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.SignatureException;
import java.util.Date;

@Service
public class JwtServiceImpl implements JwtService {

    @Value("${jwt.secret}")
    private String key;

    private Key getKey() {
        return Keys.hmacShaKeyFor(key.getBytes());
    }

    @Override
    public String generateToken(User user) {
        return Jwts
                .builder()
                .subject(user.getId().toString())
                .expiration(new Date(System.currentTimeMillis() + 3600000))
                .issuedAt(new Date())
                .signWith(getKey())
                .compact();
    }

    @Override
    public String getPayload(String token) {
        try {
            Jws<Claims> claims = getClaimsJws(token.substring(7));
            return claims.getPayload().getSubject();
        }
        catch(ExpiredJwtException e) {
            throw new TokenException("El token se encuentra expirado");
        }
        catch(MalformedJwtException e) {
            throw new TokenException("El token está mal formado");
        }
        catch(UnsupportedJwtException e) {
            throw new TokenException("El formato del token no es soportado");
        }
        catch(StringIndexOutOfBoundsException e) {
            throw new TokenException("El token se encuentra vacio");
        }
    }

    private Jws<Claims> getClaimsJws(String token) {
        return Jwts.parser().
                verifyWith((SecretKey) getKey()).
                build().
                parseSignedClaims(token);
    }
}
