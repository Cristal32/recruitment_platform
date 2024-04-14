package com.recruitment.backend.model;

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
@Table(name = "file_data")
public class FileData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7330516441682957127L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_name")
    private String fileName;
    
    @Column(name = "file_type")
    private String fileType;
    
    @Column(name = "file_path")
    private String filePath;
    
  //constructeurs
    public FileData() {}
    
    public FileData(String fileName, String filePath, String fileType) {
    	this.fileName = fileName;
    	this.filePath = filePath;
    	this.fileType = fileType;
    }
    
  //getters
    public Long getId() {
		return id;
	}
    
    public String getName() {
		return fileName;
	}
    
    public String getType() {
		return fileName;
	}
    
    public String getPath() {
		return filePath;
	}
    
  //setters
    public void setId(Long id) {
		this.id = id;
	}
    
    public void setName(String fileName) {
		this.fileName = fileName;
	}
    
    public void setType(String fileType) {
		this.fileType = fileType;
	}
    
    public void setPath(String filePath) {
		this.filePath = filePath;
	}
    
 // Builder inner class
    public static class Builder {
        private String fileName;
        private String fileType;
        private String filePath;

        public Builder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }
        
        public Builder fileType(String fileType) {
            this.fileType = fileType;
            return this;
        }

        public Builder filePath(String filePath) {
            this.filePath = filePath;
            return this;
        }

        public FileData build() {
        	FileData file = new FileData();
        	file.fileName = this.fileName;
        	file.filePath = this.filePath;
        	file.fileType = this.fileType;
            return file;
        }
    }

    // Static method to obtain a new builder instance
    public static Builder builder() {
        return new Builder();
    }
}
