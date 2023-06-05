package com.saketh.blog.services;

import java.util.List;

import com.saketh.blog.payloads.Api_Response;
import com.saketh.blog.payloads.PostDto;
import com.saketh.blog.payloads.postResponse;

public interface PostService {
	
	// create 
	
	PostDto createPost(Integer uid,Integer catid,PostDto postDto);
	
	// update 
	
	PostDto updatePost(Integer postid,PostDto postDto);
	
	// delete
	
	 void deletePost(Integer postid);
	
	// get single post 
	
	PostDto getSinglePost(Integer postid);
	
	// get all posts 
	
	  // default one
	//List<PostDto> getAllPosts(Integer pageSize,Integer pageNumber);
	
	postResponse getAllPosts(Integer pageSize,Integer pageNumber,String sortBy);
	
	
	
	// get post of all Users 
	
	List<PostDto> getAllPostsByUser(Integer uid);
	
	// get post of all categories 
	
	List<PostDto> getAllPostsByCategory(Integer catid);
	
	// search 
	
	List<PostDto> searchPost(String searchBy);
	
	
	
}

















