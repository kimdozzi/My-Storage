package com.example.mystorage.files.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.mystorage.files.domain.Files;
import com.example.mystorage.files.service.FileSystemStorageService;

@RestController
@RequestMapping("/files")
public class FileController {

	private final FileSystemStorageService fileSystemStorageService;

	public FileController(FileSystemStorageService fileSystemStorageService) {
		this.fileSystemStorageService = fileSystemStorageService;
	}

	@PostMapping("/upload")
	@ResponseStatus(HttpStatus.CREATED)
	public Files uploadFile(@RequestParam("file") MultipartFile file,
		@RequestParam("ownerId") String ownerId) {
		return fileSystemStorageService.upload(file, ownerId);
	}
}
