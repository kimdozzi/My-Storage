package com.example.mystorage.files.service;

import org.springframework.web.multipart.MultipartFile;

import com.example.mystorage.files.domain.Files;

public interface StorageService {

	Files upload(MultipartFile file, String ownerId);
}
