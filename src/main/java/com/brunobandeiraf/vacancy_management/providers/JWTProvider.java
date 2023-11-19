package com.brunobandeiraf.vacancy_management.providers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

@Service
public class JWTProvider {

  @Value("${security.token.secret}")
  private String secretKey;

  public String validateToken(String token) {
    // Troca a expressão Bearer por espaço vazio
    token = token.replace("Bearer ", "");

    Algorithm algorithm = Algorithm.HMAC256(secretKey);

    try {

        // Verificar se o token é válido
      var subject = JWT.require(algorithm)
          .build()
          .verify(token)
          .getSubject();

      return subject;
    } catch (JWTVerificationException ex) {
      ex.printStackTrace();
      return "";
    }
  }
}
