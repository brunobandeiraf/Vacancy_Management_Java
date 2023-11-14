package com.brunobandeiraf.vacancy_management.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  @Bean
  // Método dentro da classe já é gerenciado pelo Spring
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    // csrf - desabilita 
    http.csrf(csrf -> csrf.disable());
    return http.build();
  }
}
