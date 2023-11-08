package com.brunobandeiraf.vacancy_management.modules.candidate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brunobandeiraf.vacancy_management.exceptions.UserFoundException;
import com.brunobandeiraf.vacancy_management.modules.candidate.CandidateEntity;
import com.brunobandeiraf.vacancy_management.modules.candidate.CandidateRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

  @Autowired
  private CandidateRepository candidateRepository;
  // Spring é responsável por instanciar o componente

  @PostMapping("/")
  public CandidateEntity create(@Valid @RequestBody CandidateEntity candidateEntity) {
        this.candidateRepository.findByUsernameOrEmail(candidateEntity.getUsername(),
            candidateEntity.getEmail()).ifPresent(user -> {
              throw new UserFoundException();
        });

    return this.candidateRepository.save(candidateEntity);
  }
}
