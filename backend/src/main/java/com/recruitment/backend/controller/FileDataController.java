package com.recruitment.backend.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.recruitment.backend.model.FileData;
import com.recruitment.backend.service.FileDataService;


@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/file")
public class FileDataController {
	@Autowired
	private FileDataService fileDataService;
	
	//contructeur
	public FileDataController(FileDataService fileDataService) {
		this.fileDataService = fileDataService;
	}
	
	// ================================= get a file =================================
	
	@GetMapping("/getByFileName/{filename}")
//	@PreAuthorize("hasAuthority('MANAGE_FILES')")
	public ResponseEntity<FileData> getFileByFileName(@PathVariable("filename") String filename){
		FileData fileData = fileDataService.findFileDataByFileName(filename);
		return new ResponseEntity<>(fileData, HttpStatus.OK);
	}
	
	// ================================= download a file =================================
	
	@GetMapping("/download/{fileName}")
//	@PreAuthorize("hasAuthority('MANAGE_FILES')")
	public ResponseEntity<?> downloadFile(@PathVariable String fileName) throws IOException {
		try {
	        FileData fileData = fileDataService.findFileDataByFileName(fileName);
	        if (fileData == null) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File not found: " + fileName);
	        }

	        byte[] fileContent = fileDataService.downloadFile(fileName);
	        
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.parseMediaType(fileData.getType()));
	        headers.setContentDisposition(ContentDisposition.builder("attachment").filename(fileName).build());

	        return ResponseEntity.ok()
	        		.headers(headers)
	                .body(fileContent);
	    } catch (IOException e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error reading file: " + fileName);
	    }
	}

	
	// to simply display the file in browser and not download it
	/*
	@GetMapping("/load/{fileName}")
	public ResponseEntity<?> downloadFile(@PathVariable String fileName) throws IOException {
		try {
	        FileData fileData = storageService.findFileDataByFileName(fileName);
	        if (fileData == null) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File not found: " + fileName);
	        }

	        byte[] fileContent = storageService.downloadFile(fileName);

	        return ResponseEntity.ok()
	                .contentType(MediaType.parseMediaType(fileData.getFileType()))
	                .body(fileContent);
	    } catch (IOException e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error reading file: " + fileName);
	    }
	}
	*/
	
	// ================================= upload a file =================================
	
	@PostMapping("/upload")
//	@PreAuthorize("hasAuthority('MANAGE_FILES')")
	public ResponseEntity<?> uploadFile(@RequestParam("file")MultipartFile file) throws IOException{
		try {
			FileData uploadFile = fileDataService.uploadFile(file);
			return ResponseEntity.status(HttpStatus.OK).body(uploadFile);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading file: " + e.getMessage());
		}
	}
}
