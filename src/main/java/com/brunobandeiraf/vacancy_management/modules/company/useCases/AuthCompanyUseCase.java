package com.brunobandeiraf.vacancy_management.modules.company.useCases;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.brunobandeiraf.vacancy_management.modules.company.dto.AuthCompanyDTO;
import com.brunobandeiraf.vacancy_management.modules.company.repositories.CompanyRepository;

@Service
public class AuthCompanyUseCase {

  @Autowired
  private CompanyRepository companyRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public void execute(AuthCompanyDTO authCompanyDTO) throws AuthenticationException {
    
    // Verifica se o usuário existe
    var company = this.companyRepository.findByUsername(authCompanyDTO.getUsername())
        .orElseThrow(() -> {
            // Se não encontrar, dispara a exceção
            throw new UsernameNotFoundException("Company not found");
    });

    // Verifica se as senhas são iguais - criptogradas
    // authCompanyDTO - é a senha não criptografada
    // company.getPassword() - é a senha que vem do db
    var passwordMatches = this.passwordEncoder.matches(authCompanyDTO.getPassword(), company.getPassword());

    if (!passwordMatches) {
      throw new AuthenticationException();
    }
  }
}
