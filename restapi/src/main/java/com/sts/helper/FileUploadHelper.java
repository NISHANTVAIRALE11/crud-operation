package com.sts.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.aspectj.apache.bcel.util.ClassPath;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	// public final String dir_file="C:\\Users\\HP\\Documents\\"
	 //		+ "workspace-spring-tool-suite-4-4.14.0.RELEASE\\restapi\\src\\main\\resources\\static\\image";
	
	public final String dir_file=new ClassPathResource("static/image/").getFile().getAbsolutePath();
			
	public FileUploadHelper() throws IOException {
		
	}
	 public boolean uploadFile(MultipartFile multipartfile) {
		 
		 boolean f=false;
		 
		 try {
//			InputStream is=multipart.getInputStream();
//			byte []data=new byte[is.available()];
//			is.read(data);
//			
//			// write the data
//			FileOutputStream fos=new FileOutputStream(dir_file+File.separator+multipart.getOriginalFilename());
//			 fos.write(data);
//			 
//			 fos.flush();
//			 fos.close();
//			
			 
			 Files.copy(multipartfile.getInputStream(),Paths.get(dir_file+File.separator+multipartfile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			 f=true;
		} catch (Exception e) {
		  e.printStackTrace();
		}
		  return f;
		  }
	 
	 
}
