package com.recruitment.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recruitment.backend.model.Candidacy;

@Repository
public interface CandidacyDao extends JpaRepository<Candidacy, Candidacy.CandidacyId> {
	Optional<Candidacy> findCandidacyById(Candidacy.CandidacyId id);
	List<Candidacy> findCandidacyByOfferId(int offerId);
}
