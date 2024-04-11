package com.recruitment.backend.modal;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "Offer")
public class Offer implements Serializable {

    private static final long serialVersionUID = -3901318998537521041L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "offer_id", unique = true, nullable = false)
    private int id;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "posterId")
	private User poster;

    @Column(name = "job_title")
    private String title;

    @Column(name = "company_hq")
    private String hq_location;

    @Column(name = "experience")
    private String exp_years;

    @Column(name = "job_desc")
    private String job_desc;

    @Column(name = "job_location")
    private String job_location;

    @Column(name = "company_desc")
    private String company_desc;

    @Column(name = "role_responsibilities")
    private String role_respos;

    @Column(name = "role_requirements")
    private String role_reqs;

    @Column(name = "start_date")
    private Date start_date;

    @Column(name = "post_date")
    private Date post_date;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OfferStatus status;

    // Constructors
    public Offer() {
    	this.status = OfferStatus.OPEN;
    }

    public Offer(User poster, String title, String hq_location, String exp_years, String job_desc, String job_location,
            String company_desc, String role_respos, String role_reqs, Date start_date, Date post_date) {
        this.poster = poster;
    	this.title = title;
        this.hq_location = hq_location;
        this.exp_years = exp_years;
        this.job_desc = job_desc;
        this.job_location = job_location;
        this.company_desc = company_desc;
        this.role_respos = role_respos;
        this.role_reqs = role_reqs;
        this.start_date = start_date;
        this.post_date = post_date;
        this.status = OfferStatus.OPEN;
    }

    // Getters
    public int getId() {
        return id;
    }
    
    public User getPoster() {
    	return poster;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getHq_location() {
        return hq_location;
    }
    
    public String getExp_years() {
        return exp_years;
    }
    
    public String getJob_desc() {
        return job_desc;
    }
    
    public String getJob_location() {
        return job_location;
    }

    public String getCompany_desc() {
        return company_desc;
    }

    public String getRole_respos() {
        return role_respos;
    }

    public Date getStart_date() {
        return start_date;
    }

    public Date getPost_date() {
        return post_date;
    }

    public OfferStatus getStatus() {
        return status;
    }
    
    // Setters

    public void setId(int id) {
        this.id = id;
    }
    
    public void setPoster(User poster) {
    	this.poster = poster;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setHq_location(String hq_location) {
        this.hq_location = hq_location;
    }
    
    public void setExp_years(String exp_years) {
        this.exp_years = exp_years;
    }

    public void setJob_desc(String job_desc) {
        this.job_desc = job_desc;
    }

    public void setJob_location(String job_location) {
        this.job_location = job_location;
    }

    public void setCompany_desc(String company_desc) {
        this.company_desc = company_desc;
    }

    public void setRole_respos(String role_respos) {
        this.role_respos = role_respos;
    }

    public String getRole_reqs() {
        return role_reqs;
    }

    public void setRole_reqs(String role_reqs) {
        this.role_reqs = role_reqs;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public void setPost_date(Date post_date) {
        this.post_date = post_date;
    }

    public void setStatus(OfferStatus status) {
        this.status = status;
    }

    // Enum for status
    public enum OfferStatus {
        OPEN,
        CLOSED;
    }
}
