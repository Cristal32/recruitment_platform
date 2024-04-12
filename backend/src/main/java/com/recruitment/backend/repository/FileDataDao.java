package com.recruitment.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recruitment.backend.model.FileData;

public interface FileDataDao extends JpaRepository<FileData, Long>{
	Optional<FileData> findByFileName(String filename);
}
