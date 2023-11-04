package com.brunobandeiraf.vacancy_management.modules.candidate;

import java.util.UUID;
import lombok.Data;

// @Data add para todos os atributos
@Data
public class CandidateEntity {

  private UUID id;
  private String name;
  private String username;
  private String email;
  private String password;
  private String description;
  private String curriculum;

  // Lombok 
  // baseado em anotações, não é preciso add os getters e setters
}
