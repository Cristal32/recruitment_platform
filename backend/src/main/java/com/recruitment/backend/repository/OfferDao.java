package com.recruitment.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recruitment.backend.model.Offer;

@Repository
public interface OfferDao extends JpaRepository<Offer, Integer> {
	Optional<Offer> findOfferById(int id);
}
