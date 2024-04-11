package com.recruitment.backend.modal;


import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Candidacy")
public class Candidacy implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1157669247980403162L;

	@EmbeddedId
    private CandidacyId id;
	
	@ManyToOne
	@MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;
	
	@ManyToOne
	@MapsId("offerId")
    @JoinColumn(name = "offer_id")
    private Offer offer;
	
	@Column(name = "description")
    private String desc;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cv_id")
	private CvFile cv;
	
	@Enumerated(EnumType.STRING)
    @Column(name = "status")
    private CandidateStatus status;
	
	// Constructors
	public Candidacy() {
		this.status = CandidateStatus.PENDING;
	}
	
	public Candidacy(User user, Offer offer, String desc, CvFile cv) {
		this.user = user;
		this.offer = offer;
		this.desc = desc;
		this.status = CandidateStatus.PENDING;
	}
	
	// Getters
	public CandidacyId getId() {
		return id;
	}
	
	public User getUser() {
		return user;
	}
	
	public Offer getOffer() {
		return offer;
	}
	
	public String getDesc() {
		return desc;
	}
	
	// Setters
	public void setId(CandidacyId id) {
		this.id = id;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public void setOffer(Offer offer) {
		this.offer = offer;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	// Embedded id
	@Embeddable
	public static class CandidacyId implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = -8940718596647155792L;

		@Column(name = "user_id")
	    private int userId;

	    @Column(name = "offer_id")
	    private int offerId;

	    //constructeurs
	    
	    public CandidacyId() {}
	    
	    public CandidacyId(int userId, int offerId) {
	    	this.userId = userId;
	    	this.offerId = offerId;
	    }
	    
	    //getters
	    
	    public int getUserId() {
	    	return userId;
	    }
	    
	    public int getOfferId() {
	    	return offerId;
	    }
	    
	    //setters
	    
	    public void setUserId(int userId) {
	    	this.userId = userId;
	    }
	    
	    public void setOfferId(int offerId) {
	    	this.offerId = offerId;
	    }
	}
	
	// Enum for status
    public enum CandidateStatus {
        PENDING,
        ACCEPTED,
        REJECTED;
    }

}
