package com.recruitment.backend.service;

import java.util.List;

import com.recruitment.backend.model.Offer;

public interface OfferService {
	public List<Offer> getAllOffers();
	public Offer findOfferById(int id);
	public Offer addOffer(Offer offer);
	public Offer updateOffer(Offer offer);
	public void deleteOffer(int id);
}
