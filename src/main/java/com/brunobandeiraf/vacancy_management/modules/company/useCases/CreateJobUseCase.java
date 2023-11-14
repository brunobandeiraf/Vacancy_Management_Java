package com.brunobandeiraf.vacancy_management.modules.company.useCases;

import org.springframework.stereotype.Service;

import com.brunobandeiraf.vacancy_management.modules.company.entities.JobEntity;
import com.brunobandeiraf.vacancy_management.modules.company.repositories.JobRepository;

@Service
public class CreateJobUseCase {
  private JobRepository jobRepository;

  public JobEntity execute(JobEntity jobEntity) {
    return this.jobRepository.save(jobEntity);
  }
}
