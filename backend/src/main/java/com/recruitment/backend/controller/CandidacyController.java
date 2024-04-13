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

import com.recruitment.backend.model.Candidacy;
import com.recruitment.backend.service.CandidacyService;

import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/candidacy")
public class CandidacyController {
	@Autowired
	private final CandidacyService candidacyService;
	
	//constructeur
	public CandidacyController(CandidacyService candidacyService) {
		this.candidacyService = candidacyService;
	}
	
	// ================================= GET Mapping =================================
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Candidacy>> getAllCandidacies(){
		List<Candidacy> candidacies = candidacyService.getAllCandidacies();
		return new ResponseEntity<>(candidacies, HttpStatus.OK);
	}
	
	@GetMapping("/get/{offerId}/{userId}")
	public ResponseEntity<Candidacy> getAcquerirById(@PathVariable int offerId, @PathVariable int userId){
		Candidacy candidacy = candidacyService.findCandidacyById(offerId, userId);
		return new ResponseEntity<>(candidacy, HttpStatus.OK);
	}
	// ================================= POST Mapping =================================
	
	@PostMapping("/add")
	public ResponseEntity<Candidacy> addCandidacy(@RequestBody Candidacy candidacy){
		Candidacy new_candidacy = candidacyService.addCandidacy(candidacy);
		return new ResponseEntity<>(new_candidacy, HttpStatus.CREATED); 
	}
	
	// ================================= PUT Mapping =================================
	
	@PutMapping("/update")
	public ResponseEntity<Candidacy> updateCandidacy(@RequestBody Candidacy candidacy){
		Candidacy updated_candidacy = candidacyService.updateCandidacy(candidacy);
		return new ResponseEntity<>(updated_candidacy, HttpStatus.OK); 
	}
	
	// ================================= DELETE Mapping =================================
	@Transactional
	@DeleteMapping("/delete/{offerId}/{userId}")
	public ResponseEntity<?> deleteCandidacy(@PathVariable int offerId, @PathVariable int userId){
		candidacyService.deleteCandidacy(offerId, userId);
		return new ResponseEntity<>(HttpStatus.OK); 
	}
}
