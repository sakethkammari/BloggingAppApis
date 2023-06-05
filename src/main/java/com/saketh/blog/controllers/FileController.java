package com.saketh.blog.controllers;

import java.awt.PageAttributes.MediaType;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.hibernate.engine.jdbc.StreamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.saketh.blog.payloads.FileResponse;
import com.saketh.blog.payloads.PostDto;
import com.saketh.blog.services.FileService;
import com.saketh.blog.services.PostService;

import net.bytebuddy.asm.Advice.Return;

@RestController
@RequestMapping("/file")
public class FileController {
	
		@Autowired
		private FileService fileService;
		
		@Autowired
		private PostService postService;
		
		@Value("${project.image}")
		private String path;

		// general one
//			@PostMapping("/upload")
//			public ResponseEntity<FileResponse> fileUpload(
//					@RequestParam("image") MultipartFile image)
//			{
//				String filename = this.fileService.uploadImage(path, image);
//				return new ResponseEntity<FileResponse>( new FileResponse("file created sucesfully"),HttpStatus.CREATED);
//			}
			
		
		
		@PostMapping("/upload/{postId}")
		public ResponseEntity<PostDto> fileUpload(
				@RequestParam("image") MultipartFile image,
				@PathVariable Integer postId)
		{
			String filename = this.fileService.uploadImage(path, image);
			
			PostDto postDto = this.postService.getSinglePost(postId);
				postDto.setImageName(filename);
				
		PostDto updateDto = 	this.postService.updatePost(postId, postDto);
			
			return new ResponseEntity<PostDto>( updateDto,HttpStatus.OK);
		}	
		
		
			
			
			
		@GetMapping(value = "/images/{imageName}",produces = org.springframework.http.MediaType.IMAGE_JPEG_VALUE)
		public void downloadImage(
			@PathVariable("imageName") String imageName , 
			HttpServletResponse response) throws IOException
		{
			 InputStream resourse = this.fileService.getREsourse(path, imageName);
			 
			 response.setContentType(org.springframework.http.MediaType.IMAGE_JPEG_VALUE);
			 
			 StreamUtils.copy(resourse, response.getOutputStream());
			 	
		}
		
			
}








