package com.saketh.blog.services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.saketh.blog.services.FileService;

@Service
public class FileServiceImpl implements FileService{

	@Override
	public String uploadImage(String path, MultipartFile file) {
		
		// file name 
		
		String fname = file.getOriginalFilename();
		
		
		String randomId = UUID.randomUUID().toString();
		String newFilename = randomId.concat(fname.substring(fname.lastIndexOf(".")));
		
		// full path
		
		String fpath  = path + File.separator + newFilename;
		
		// create folder if not exist
		
		File f =new File(path);
		
		if(!f.exists())
		{
			f.mkdir();
		}
		
		// copy file
		
		try {
			Files.copy(file.getInputStream(),Paths.get(fpath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// TODO Auto-generated method stub
		return fname;
	}

	@Override
	public InputStream getREsourse(String path, String fileName)  {
			String fullpathString = path+File.separator+fileName;
			
			InputStream iStream=null;
			try {
				iStream = new FileInputStream(fullpathString);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return iStream;
		
	}
	
	

}









