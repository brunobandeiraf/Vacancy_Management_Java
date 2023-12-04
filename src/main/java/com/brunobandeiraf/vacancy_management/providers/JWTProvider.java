package com.brunobandeiraf.vacancy_management.providers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.JWT;

@Service
public class JWTProvider {

  @Value("${security.token.secret}")
  private String secretKey;

  public DecodedJWT validateToken(String token) {
    // Troca a expressão Bearer por espaço vazio
    token = token.replace("Bearer ", "");

    Algorithm algorithm = Algorithm.HMAC256(secretKey);

    try {

        // Verificar se o token é válido
        var tokenDecoded = JWT.require(algorithm)
          .build()
          .verify(token);

        return tokenDecoded;
    } catch (JWTVerificationException ex) {
      ex.printStackTrace();
      return null;
    }
  }
}
