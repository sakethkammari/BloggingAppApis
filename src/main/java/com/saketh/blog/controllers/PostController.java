package com.saketh.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saketh.blog.payloads.Api_Response;
import com.saketh.blog.payloads.PostDto;
import com.saketh.blog.payloads.postResponse;
import com.saketh.blog.services.PostService;

@RestController
@RequestMapping("/api")
public class PostController {
	
	 @Autowired
	 private PostService postService; 
	 
	
	
	@PostMapping("/users/{uid}/category/{catid}/posts")
	private ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,@PathVariable Integer uid,@PathVariable Integer catid)
	{
		PostDto createdPost = this.postService.createPost(uid, catid, postDto);
		return new ResponseEntity<PostDto>(createdPost,HttpStatus.CREATED);
	}
	
	@PutMapping("/post/{pid}")
	private ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable Integer pid)
	{
		PostDto newpostDto = this.postService.updatePost(pid, postDto);
		
		return new ResponseEntity<PostDto>(newpostDto,HttpStatus.OK);
	}
	
	@DeleteMapping("/post/{pid}")
	private ResponseEntity<Api_Response> deletePost(@PathVariable Integer pid)
	{
		this.postService.deletePost(pid);
		
		return new ResponseEntity<Api_Response>(new Api_Response("post deleted","sucessfully"),HttpStatus.OK);
	}
	
	@GetMapping("/post/{pid}")
	private ResponseEntity<PostDto> getSinglePost(@PathVariable Integer pid)
	{
		PostDto pDto1  = this.postService.getSinglePost(pid);
		
		return new ResponseEntity<PostDto>(pDto1,HttpStatus.OK);
	}
// old default
	
//	@GetMapping("/post")
//	private ResponseEntity<List<PostDto>> getALlPOsts(
//			
//			@RequestParam(value = "pageNumber" , defaultValue = "1",required =false)Integer pageNumber,
//			@RequestParam(value = "pageSize" , defaultValue = "2",required =false) Integer pageSize
//			
//			
//			)
//	{
//		List<PostDto> list_posts = this.postService.getAllPosts(pageSize,pageNumber);
//		
//		return new ResponseEntity<List<PostDto>>(list_posts,HttpStatus.OK);
//	}
	
	// sending as post response (content,page number,total pages etc)
	
//	@GetMapping("/post")
//	private ResponseEntity<postResponse> getALlPOsts(
//			
//			@RequestParam(value = "pageNumber" , defaultValue = "1",required =false)Integer pageNumber,
//			@RequestParam(value = "pageSize" , defaultValue = "2",required =false) Integer pageSize
//			
//			
//			)
//	{
//		  postResponse allPosts = this.postService.getAllPosts(pageSize,pageNumber);
//		
//		return new ResponseEntity<postResponse>(allPosts,HttpStatus.OK);
//	}
	
	// get all by sort 
	
	@GetMapping("/post")
	private ResponseEntity<postResponse> getALlPOsts(
			
			@RequestParam(value = "pageNumber" , defaultValue = "1",required =false)Integer pageNumber,
			@RequestParam(value = "pageSize" , defaultValue = "5",required =false) Integer pageSize,
			@RequestParam(value = "sortBy" , defaultValue = "title",required =false) String sortBy
			
			
			
			)
	{
		  postResponse allPosts = this.postService.getAllPosts(pageSize,pageNumber,sortBy);
		
		return new ResponseEntity<postResponse>(allPosts,HttpStatus.OK);
	}
	
	@GetMapping("/post_user/{uid}")
	private ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Integer uid)
	{
		 List<PostDto> resDtos = this.postService.getAllPostsByUser(uid);
		 
		 return new ResponseEntity<List<PostDto>>(resDtos,HttpStatus.OK);
	}
	
	@GetMapping("/post_catgo/{cid}")
	private ResponseEntity<List<PostDto>> getPostsByCatgo(@PathVariable Integer cid)
	{
		 List<PostDto> resDtos = this.postService.getAllPostsByUser(cid);
		 
		 return new ResponseEntity<List<PostDto>>(resDtos,HttpStatus.OK);
	}
	
	// search 
	
	@GetMapping("/post/search")
	private ResponseEntity<List<PostDto>> searchPosts(
			@RequestParam(value = "searchBy" , defaultValue = "title",required =false) String searchBy)
	{
		List<PostDto> resDtos =  this.postService.searchPost(searchBy);
			
		return new ResponseEntity<List<PostDto>>(resDtos,HttpStatus.OK);
	}
	
	

}


















