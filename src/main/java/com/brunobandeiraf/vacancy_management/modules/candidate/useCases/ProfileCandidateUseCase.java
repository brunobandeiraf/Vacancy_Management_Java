package com.brunobandeiraf.vacancy_management.modules.candidate.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.brunobandeiraf.vacancy_management.modules.candidate.CandidateRepository;
import com.brunobandeiraf.vacancy_management.modules.candidate.dto.ProfileCandidateResponseDTO;
import com.brunobandeiraf.vacancy_management.modules.candidate.dto.ProfileCandidateResponseDTO.ProfileCandidateResponseDTOBuilder;

@Service
public class ProfileCandidateUseCase {
  @Autowired
  private CandidateRepository candidateRepository;

  public ProfileCandidateResponseDTOBuilder execute(UUID idCandidate) {
    var candidate = this.candidateRepository.findById(idCandidate)
        .orElseThrow(() -> {
          throw new UsernameNotFoundException("User not found");
        });

    var candidateDTO = ProfileCandidateResponseDTO.builder()
        .description(candidate.getDescription())
        .username(candidate.getUsername())
        .email(candidate.getEmail())
        .name(candidate.getName())
        .id(candidate.getId());

    return candidateDTO;
  }
}