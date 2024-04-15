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
    
    // ---------------------------- validate/reject candidacy ----------------------------
    @Override
    public boolean validateCandidacy(int offerId, int userId) {
        Candidacy candidacy = findCandidacyById(offerId, userId);
        if (candidacy != null) {
            candidacy.setStatus(Candidacy.CandidateStatus.ACCEPTED);
            candidacyDao.save(candidacy);
            return true; // Operation successful
        } else {
            return false; // Candidacy not found
        }
    }

    @Override
    public boolean rejectCandidacy(int offerId, int userId) {
        Candidacy candidacy = findCandidacyById(offerId, userId);
        if (candidacy != null) {
            candidacy.setStatus(Candidacy.CandidateStatus.REJECTED);
            candidacyDao.save(candidacy);
            return true; // Operation successful
        } else {
            return false; // Candidacy not found
        }
    }
}
