package com.example.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UploadForm {
	@NotNull
	private MultipartFile file;
	
	@NotNull
	@Size(min = 1,max = 200)
	private String comment;
}
