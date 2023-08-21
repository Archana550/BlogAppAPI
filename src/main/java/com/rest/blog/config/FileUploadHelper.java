package com.rest.blog.config;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	public  final String upload_dir= "C:\\Users\\KARCHANA\\eclipse-workspace\\BlogAppAPI\\src\\main\\resources\\static\\images";
	 //public String upload_dir= new ClassPathResource("/static/images/").getFile().getAbsolutePath();
	
	FileUploadHelper() throws IOException{}
	
	public boolean uploadFile(MultipartFile file) throws IOException{
		boolean send = false;
		Files.copy(file.getInputStream(), Paths.get(upload_dir+File.separator+file.getOriginalFilename()),
						StandardCopyOption.REPLACE_EXISTING);
		send=true;
		return send;
	}
		
}
