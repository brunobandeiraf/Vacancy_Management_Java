package com.brunobandeiraf.vacancy_management.modules.candidate.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunobandeiraf.vacancy_management.exceptions.JobNotFoundException;
import com.brunobandeiraf.vacancy_management.exceptions.UserNotFoundException;
import com.brunobandeiraf.vacancy_management.modules.candidate.CandidateRepository;
import com.brunobandeiraf.vacancy_management.modules.company.repositories.JobRepository;

@Service
public class ApplyJobCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobRepository jobRepository;

    // ID do candidato
    // ID da vaga
    public void execute(UUID idCandidate, UUID idJob){
        // Validar se o candidato existe
        this.candidateRepository.findById(idCandidate)
        .orElseThrow(() -> {
            throw new UserNotFoundException();
        });

        // Validar se a vaga existe
        this.jobRepository.findById(idJob)
        .orElseThrow(() -> {
            throw new JobNotFoundException();
        });

        // Candidato se inscrever na vaga
    }
}
