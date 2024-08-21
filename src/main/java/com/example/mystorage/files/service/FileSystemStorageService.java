package com.example.mystorage.files.service;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.mystorage.files.domain.Files;
import com.example.mystorage.files.dto.FileUploadResponse;
import com.example.mystorage.files.exception.StorageException;
import com.example.mystorage.files.repository.FileRepository;

@Service
public class FileSystemStorageService implements StorageService {

	private final FileRepository fileRepository;

	@Value("${file.upload.path}")
	private String uploadDir;

	public FileSystemStorageService(FileRepository fileRepository) {
		this.fileRepository = fileRepository;
	}

	public FileUploadResponse upload(MultipartFile file, String ownerId) {
		try {
			if (file.isEmpty()) {
				throw new StorageException("Failed to store empty file.");
			}
			String storedFileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
			Path destinationPath = Paths.get(uploadDir, storedFileName);
			file.transferTo(destinationPath);

			// 메타 데이터 저장
			Files fileMetadata = Files.builder()
				.fileName(file.getName())
				.storedFileName(storedFileName)
				.fileSize(file.getSize())
				.fileType(file.getContentType())
				.fileUrl(destinationPath.toString())
				.ownerId(ownerId)
				.uploadTime(LocalDateTime.now())
				.build();

			Files uploadedFile = fileRepository.save(fileMetadata);
			return uploadedFile.toFileUploadResponse();

		} catch (IOException e) {
			throw new StorageException("Cannot store file outside current directory.");
		}
	}
}
