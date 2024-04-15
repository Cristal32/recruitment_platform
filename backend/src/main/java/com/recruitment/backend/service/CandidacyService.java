package com.recruitment.backend.service;

import java.util.List;

import com.recruitment.backend.model.Candidacy;

public interface CandidacyService {
	List<Candidacy> getAllCandidacies();
	Candidacy findCandidacyById(int offerId, int userId);
	List<Candidacy> findCandidaciesByOffer(int offerId);
	Candidacy addCandidacy(Candidacy candidacy);
	Candidacy updateCandidacy(Candidacy candidacy);
	void deleteCandidacy(int offerId, int userId);
}
