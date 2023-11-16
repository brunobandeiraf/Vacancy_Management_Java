package com.brunobandeiraf.vacancy_management.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Bean;

@Configuration
public class SecurityConfig {

  @Bean
  // Método dentro da classe já é gerenciado pelo Spring
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    // csrf - desabilita 
    http.csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> {
          auth.requestMatchers("/candidate/").permitAll()
              .requestMatchers("/company/").permitAll()
              .requestMatchers("/auth/company").permitAll();
          auth.anyRequest().authenticated();
          // Qualquer outra rota, solicita autenticação.
        });

    return http.build();
  }

  // criptografar a senha
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
