package com.brunobandeiraf.vacancy_management.modules.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
// Construtor com todos os argumentos
public class AuthCompanyDTO {

  private String password;
  private String username;
}
