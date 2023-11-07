package com.brunobandeiraf.vacancy_management.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
// Cria os construtores
public class ErrorMessageDTO {

  private String message;
  private String field;
}