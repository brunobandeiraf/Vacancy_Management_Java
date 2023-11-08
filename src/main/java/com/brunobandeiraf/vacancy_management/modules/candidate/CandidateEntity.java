package com.brunobandeiraf.vacancy_management.modules.candidate;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

// @Data add para todos os atributos
@Data
@Entity(name = "candidate")
// Nome da Tabela
public class CandidateEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  //@Column(name="nome_usuário")
  private String name;

  //@Pattern(regexp = "^(?!\\s*$).+", message = "O campo [username] não deve conter espaço")
  @NotBlank
  @Pattern(regexp = "\\S+", message = "O campo [username] não deve conter espaço")
  private String username;

  @Email(message = "O campo (email) deve conter um e-mail válido")
  private String email;

  @Length(min = 10, max = 100, message = "A senha deve conter entre (10) e (100) caracteres")
  private String password;
  private String description;
  private String curriculum;


  @CreationTimestamp
  private LocalDateTime createdAt;

  // Lombok 
  // baseado em anotações, não é preciso add os getters e setters
}
