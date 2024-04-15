package com.recruitment.backend.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recruitment.backend.model.Candidacy;
import com.recruitment.backend.repository.CandidacyDao;
import com.recruitment.backend.service.CandidacyService;

@Service
public class CandidacyServiceImpl implements CandidacyService {
	@Autowired
    private CandidacyDao candidacyDao;

 // ---------------------------- get all candidacies  ----------------------------
    
    @Override
    public List<Candidacy> getAllCandidacies() {
        return candidacyDao.findAll();
    }

 // ---------------------------- find candidacy ----------------------------
    
    @Override
    public Candidacy findCandidacyById(int offerId, int userId) {
    	Candidacy.CandidacyId id = new Candidacy.CandidacyId(offerId, userId);
        return candidacyDao.findCandidacyById(id).orElse(null);
    }
    
    @Override
    public List<Candidacy> findCandidaciesByOffer(int offerId) {
        return candidacyDao.findCandidacyByOfferId(offerId);
    }

 // ---------------------------- add candidacy ----------------------------
    
    @Override
    public Candidacy addCandidacy(Candidacy candidacy) {
        return candidacyDao.save(candidacy);
    }

 // ---------------------------- update candidacy ----------------------------
    
    @Override
    public Candidacy updateCandidacy(Candidacy candidacy) {
        return candidacyDao.save(candidacy);
    }

 // ---------------------------- delete candidacy ----------------------------
    
    @Override
    public void deleteCandidacy(int offerId, int userId) {
    	Candidacy.CandidacyId id = new Candidacy.CandidacyId(offerId, userId);
        candidacyDao.deleteById(id);
    }
}
