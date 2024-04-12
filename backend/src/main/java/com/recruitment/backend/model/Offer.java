package com.recruitment.backend.model;

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
    
    public String getHqLocation() {
        return hq_location;
    }
    
    public String getExpYears() {
        return exp_years;
    }
    
    public String getJobDesc() {
        return job_desc;
    }
    
    public String getJobLocation() {
        return job_location;
    }

    public String getCompanyDesc() {
        return company_desc;
    }

    public String getRoleRespos() {
        return role_respos;
    }

    public String getRoleReqs() {
        return role_reqs;
    }

    public Date getStartDate() {
        return start_date;
    }

    public Date getPostDate() {
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

    public void setHqLocation(String hq_location) {
        this.hq_location = hq_location;
    }
    
    public void setExpYears(String exp_years) {
        this.exp_years = exp_years;
    }

    public void setJobDesc(String job_desc) {
        this.job_desc = job_desc;
    }

    public void setJobLocation(String job_location) {
        this.job_location = job_location;
    }

    public void setCompanyDesc(String company_desc) {
        this.company_desc = company_desc;
    }

    public void setRoleRespos(String role_respos) {
        this.role_respos = role_respos;
    }

    public void setRoleReqs(String role_reqs) {
        this.role_reqs = role_reqs;
    }

    public void setStartDate(Date start_date) {
        this.start_date = start_date;
    }

    public void setPostDate(Date post_date) {
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
