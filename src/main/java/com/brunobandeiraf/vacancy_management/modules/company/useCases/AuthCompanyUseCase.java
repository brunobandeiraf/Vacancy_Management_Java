package com.brunobandeiraf.vacancy_management.modules.company.useCases;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.naming.AuthenticationException;

import com.brunobandeiraf.vacancy_management.modules.company.dto.AuthCompanyDTO;
import com.brunobandeiraf.vacancy_management.modules.company.repositories.CompanyRepository;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Service
public class AuthCompanyUseCase {

  // @Value busca a variável de ambiente criada no properties
  @Value("${security.token.secret}")
  private String secretKey;

  @Autowired
  private CompanyRepository companyRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public String execute(AuthCompanyDTO authCompanyDTO) throws AuthenticationException {
    
    // Verifica se o usuário existe
    var company = this.companyRepository.findByUsername(authCompanyDTO.getUsername())
        .orElseThrow(() -> {
            // Se não encontrar, dispara a exceção
            throw new UsernameNotFoundException("Username/password incorrect");
    });

    // Verifica se as senhas são iguais - criptogradas
    // authCompanyDTO - é a senha não criptografada
    // company.getPassword() - é a senha que vem do db
    var passwordMatches = this.passwordEncoder.matches(authCompanyDTO.getPassword(), company.getPassword());

    // Se não for igual - Erro
    if (!passwordMatches) {
      throw new AuthenticationException();
    }

    // Se for igual - Gerar o token
    // O tipo do algoritmo do token
    Algorithm algorithm = Algorithm.HMAC256(secretKey);

    // Geração de token
    var token = JWT.create().withIssuer("javagas")
        .withSubject(company.getId().toString()).sign(algorithm);

    return token;

  }
}
