package com.saketh.blog.services;

import java.io.InputStream;

import javax.print.DocFlavor.INPUT_STREAM;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


public interface FileService {
	
	String uploadImage(String path,MultipartFile file);
	
	InputStream getREsourse(String path,String fileName);
}
