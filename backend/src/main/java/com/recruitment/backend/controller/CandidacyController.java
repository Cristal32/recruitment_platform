package com.recruitment.backend.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.recruitment.backend.model.Candidacy;
import com.recruitment.backend.model.FileData;
import com.recruitment.backend.service.CandidacyService;
import com.recruitment.backend.service.FileDataService;

import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/candidacy")
public class CandidacyController {
	@Autowired
	private final CandidacyService candidacyService;
	
	@Autowired
	private final FileDataService fileDataService;
	
	//constructeur
	public CandidacyController(CandidacyService candidacyService, FileDataService fileDataService) {
		this.candidacyService = candidacyService;
		this.fileDataService = fileDataService;
	}
	
	// ================================= GET Mapping =================================
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Candidacy>> getAllCandidacies(){
		List<Candidacy> candidacies = candidacyService.getAllCandidacies();
		return new ResponseEntity<>(candidacies, HttpStatus.OK);
	}
	
	@GetMapping("/get/{offerId}/{userId}")
	public ResponseEntity<Candidacy> getCandidacyById(@PathVariable int offerId, @PathVariable int userId){
		Candidacy candidacy = candidacyService.findCandidacyById(offerId, userId);
		return new ResponseEntity<>(candidacy, HttpStatus.OK);
	}
	
	@GetMapping("/getByOffer/{offerId}")
	public ResponseEntity<List<Candidacy>> getCandidacyByOffer(@PathVariable int offerId){
		List<Candidacy> candidacies = candidacyService.findCandidaciesByOffer(offerId);
		return new ResponseEntity<>(candidacies, HttpStatus.OK);
	}
	
	@GetMapping("/getByUser/{userId}")
	public ResponseEntity<List<Candidacy>> getCandidacyByUser(@PathVariable int userId){
		List<Candidacy> candidacies = candidacyService.findCandidaciesByUser(userId);
		return new ResponseEntity<>(candidacies, HttpStatus.OK);
	}
	// ================================= POST Mapping =================================
	
	@PostMapping("/add")
	public ResponseEntity<Candidacy> addCandidacy(@RequestBody Candidacy candidacy){
		Candidacy new_candidacy = candidacyService.addCandidacy(candidacy);
		return new ResponseEntity<>(new_candidacy, HttpStatus.CREATED); 
	}
	
	@PostMapping(value = "/addWithCv", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<?> addCandidateWithCv(@RequestPart("candidateData") Candidacy candidacy, @RequestPart("file") MultipartFile cvFile) throws IOException{
		try {
			if(cvFile != null && !cvFile.isEmpty()) {
				FileData uploadFile = fileDataService.uploadFile(cvFile);
				candidacy.setCv(uploadFile);
			}
			Candidacy newCandidacy = candidacyService.addCandidacy(candidacy);
			 return ResponseEntity.status(HttpStatus.CREATED).body("Candidate created : " + newCandidacy);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error : " + e.getMessage());
		}
	}
	
	// ================================= PUT Mapping =================================
	
	@PutMapping("/update")
	public ResponseEntity<Candidacy> updateCandidacy(@RequestBody Candidacy candidacy){
		Candidacy updated_candidacy = candidacyService.updateCandidacy(candidacy);
		return new ResponseEntity<>(updated_candidacy, HttpStatus.OK); 
	}
	
	@PutMapping("/validate/{offerId}/{userId}")
	public ResponseEntity<String> validateCandidacy(@PathVariable int offerId, @PathVariable int userId) {
        boolean isValidated = candidacyService.validateCandidacy(offerId, userId);
        if (isValidated) {
            return ResponseEntity.ok("Candidacy validated successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	@PutMapping("/reject/{offerId}/{userId}")
	public ResponseEntity<String> rejectCandidacy(@PathVariable int offerId, @PathVariable int userId) {
        boolean isRejected = candidacyService.rejectCandidacy(offerId, userId);
        if (isRejected) {
            return ResponseEntity.ok("Candidacy rejected successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	// ================================= DELETE Mapping =================================
	@Transactional
	@DeleteMapping("/delete/{offerId}/{userId}")
	public ResponseEntity<?> deleteCandidacy(@PathVariable int offerId, @PathVariable int userId){
		candidacyService.deleteCandidacy(offerId, userId);
		return new ResponseEntity<>(HttpStatus.OK); 
	}
}
