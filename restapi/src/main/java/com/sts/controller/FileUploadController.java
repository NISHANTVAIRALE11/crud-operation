package com.sts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sts.helper.FileUploadHelper;

@RestController
public class FileUploadController
{

	@Autowired
	private FileUploadHelper fileuploadhelper;

	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file)
	{

		try {
			if (file.isEmpty())
			{
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("file should not be empty");
			}
			boolean f = fileuploadhelper.uploadFile(file);
			if (f) 
			{
				//return ResponseEntity.ok("successfull");
				// to return the image with localhost path to the postman
				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
			}

		  } catch (Exception e)
		    {
			e.printStackTrace();
		    }

		return ResponseEntity.ok("working");
	}
}
