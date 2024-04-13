package com.recruitment.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recruitment.backend.model.Offer;
import com.recruitment.backend.service.OfferService;

import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/offer")
public class OfferController {
	@Autowired
	private final OfferService offerService;
	
	//constructeur
	public OfferController(OfferService offerService) {
		this.offerService = offerService;
	}
	
	// ================================= GET Mapping =================================
	
	@GetMapping("/getAll")
//	@PreAuthorize("hasAuthority('GET_USERS')")
	public ResponseEntity<List<Offer>> getAllOffers(){
		List<Offer> offers = offerService.getAllOffers();
		return new ResponseEntity<>(offers, HttpStatus.OK);
	}
	
	@GetMapping("/getId/{id}")
	// @PreAuthorize("hasAuthority('GET_USERS')")
	public ResponseEntity<Offer> getOfferById(@PathVariable("id") int id){
		Offer offer = offerService.findOfferById(id);
		return new ResponseEntity<>(offer, HttpStatus.OK);
	}
	
	// ================================= POST Mapping =================================
	
	@PostMapping("/add")
	// @PreAuthorize("hasAuthority('MANAGE_USERS')")
	public ResponseEntity<Offer> addOffer(@RequestBody Offer offer){
		Offer newOffer = offerService.addOffer(offer);
		return new ResponseEntity<>(newOffer, HttpStatus.CREATED); 
	}
	
	// ================================= PUT Mapping =================================
	
	@PutMapping("/update")
	// @PreAuthorize("hasAuthority('MANAGE_USERS')")
	public ResponseEntity<Offer> updateOffer(@RequestBody Offer offer){
		Offer updateOffer = offerService.updateOffer(offer);
		return new ResponseEntity<>(updateOffer, HttpStatus.OK); 
	}
	
	// ================================= DELETE Mapping =================================
	@Transactional
	@DeleteMapping("/delete/{id}")
	// @PreAuthorize("hasAuthority('MANAGE_USERS')")
	public ResponseEntity<?> deleteOffer(@PathVariable("id") int id){
		offerService.deleteOffer(id);
		return new ResponseEntity<>(HttpStatus.OK); 
	}
}
