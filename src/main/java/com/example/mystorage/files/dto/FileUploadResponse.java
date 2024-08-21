package com.example.mystorage.files.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder
public record FileUploadResponse(
	long id,
	String fileName,
	String storedFileName,
	long fileSize,
	String fileType,
	String fileUrl,
	String ownerId,
	LocalDateTime uploadTime
) {
	public static FileUploadResponse of(long id, String fileName, String storedFileName, long fileSize, String fileType, String fileUrl,
			String ownerId, LocalDateTime uploadTime) {
		return FileUploadResponse.builder()
			.id(id)
			.fileName(fileName)
			.storedFileName(storedFileName)
			.fileSize(fileSize)
			.fileType(fileType)
			.fileUrl(fileUrl)
			.ownerId(ownerId)
			.uploadTime(uploadTime)
			.build();
	}
}
