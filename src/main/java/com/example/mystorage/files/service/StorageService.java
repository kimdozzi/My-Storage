package com.example.mystorage.files.service;

import org.springframework.web.multipart.MultipartFile;

import com.example.mystorage.files.dto.FileUploadResponse;

public interface StorageService {
	FileUploadResponse upload(MultipartFile file, String ownerId);
}
