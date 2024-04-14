package com.recruitment.backend.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recruitment.backend.model.Offer;
import com.recruitment.backend.repository.OfferDao;
import com.recruitment.backend.service.OfferService;

@Service
public class OfferServiceImpl implements OfferService{
	
	@Autowired
	private OfferDao offerDao;
	
	// ---------------------------- get all offers ----------------------------
	@Override
	public List<Offer> getAllOffers(){
		return offerDao.findAll();
	}
	
	// ---------------------------- get offer by id ----------------------------
	@Override
	public Offer findOfferById(int id) {
		return offerDao.findOfferById(id).orElse(null);
	}
	
	// ---------------------------- get offer by poster ----------------------------
	@Override
	public List<Offer> findOffersByPosterId(int posterId) {
	    return offerDao.findOffersByPosterId(posterId);
	}
	
	// ---------------------------- add offer ----------------------------
	
	@Override
	public Offer addOffer(Offer offer) {
		return offerDao.save(offer);
	}
	
	// ---------------------------- update offer ----------------------------
	@Override
	public Offer updateOffer(Offer offer) {
		return offerDao.save(offer);
	}
	
	// ---------------------------- delete offer ----------------------------
	@Override
	public void deleteOffer(int id) {
		offerDao.deleteById(id);
	}

}
