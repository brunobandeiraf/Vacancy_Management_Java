package com.brunobandeiraf.vacancy_management.modules.candidate.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunobandeiraf.vacancy_management.modules.candidate.CandidateEntity;
import com.brunobandeiraf.vacancy_management.modules.candidate.CandidateRepository;
import com.brunobandeiraf.vacancy_management.exceptions.UserFoundException;

@Service
public class CreateCandidateUseCase {
  @Autowired
  private CandidateRepository candidateRepository;

  public CandidateEntity execute(CandidateEntity candidateEntity) {
    this.candidateRepository.findByUsernameOrEmail(candidateEntity.getUsername(),
        candidateEntity.getEmail()).ifPresent(user -> {
          throw new UserFoundException();
        });

    return this.candidateRepository.save(candidateEntity);
  }
}
