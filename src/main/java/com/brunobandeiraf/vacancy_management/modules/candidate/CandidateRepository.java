package com.brunobandeiraf.vacancy_management.modules.candidate;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

// < entidade , tipo>
public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID> {

}
