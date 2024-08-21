package com.example.mystorage.files.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
public class Files {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; // 고유 식별자

	private String fileName; // 사용자가 업로드한 원본 파일명
	private String storedFileName; // 서버에 저장된 파일명 (고유 데이터)
	private long fileSize;
	private String fileType; // MIME 타입
	private String fileUrl; // 서버에 저장된 파일의 경로
	private String ownerId; // 파일을 업로드한 사용자의 ID
	private LocalDateTime uploadTime;


	@Builder
	public Files(String fileName, String storedFileName, long fileSize, String fileType, String fileUrl,
		String ownerId, LocalDateTime uploadTime) {
		this.fileName = fileName;
		this.storedFileName = storedFileName;
		this.fileSize = fileSize;
		this.fileType = fileType;
		this.fileUrl = fileUrl;
		this.ownerId = ownerId;
		this.uploadTime = uploadTime;
	}
}
