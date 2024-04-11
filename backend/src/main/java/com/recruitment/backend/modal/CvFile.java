package com.recruitment.backend.modal;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "Cv_file")
public class CvFile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7330516441682957127L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_name")
    private String fileName;
    
    @Column(name = "file_path")
    private String filePath;
    
  //constructeurs
    public CvFile() {}
    
    public CvFile(String fileName, String filePath) {
    	this.fileName = fileName;
    	this.filePath = filePath;
    }
    
  //getters
    public Long getFileId() {
		return id;
	}
    
    public String getFileName() {
		return fileName;
	}
    
    public String getFilePath() {
		return filePath;
	}
    
  //setters
    public void setFileId(Long id) {
		this.id = id;
	}
    
    public void setFileName(String fileName) {
		this.fileName = fileName;
	}
    
    public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
    
 // Builder inner class
    public static class Builder {
        private String fileName;
        private String filePath;

        public Builder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public Builder filePath(String filePath) {
            this.filePath = filePath;
            return this;
        }

        public CvFile build() {
        	CvFile cvFile = new CvFile();
        	cvFile.fileName = this.fileName;
        	cvFile.filePath = this.filePath;
            return cvFile;
        }
    }

    // Static method to obtain a new builder instance
    public static Builder builder() {
        return new Builder();
    }
}
