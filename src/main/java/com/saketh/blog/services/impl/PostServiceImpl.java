package com.saketh.blog.services.impl;

//import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.saketh.blog.entities.Category;
import com.saketh.blog.entities.Post;
import com.saketh.blog.entities.User;
import com.saketh.blog.exceptions.ResourceNotFoundException;
import com.saketh.blog.payloads.Api_Response;
import com.saketh.blog.payloads.CategoryDto;
import com.saketh.blog.payloads.PostDto;
import com.saketh.blog.payloads.postResponse;
import com.saketh.blog.repositories.CategoryRepo;
import com.saketh.blog.repositories.PostRepo;
import com.saketh.blog.repositories.UserRepo;
import com.saketh.blog.services.PostService;

import net.bytebuddy.asm.Advice.This;


@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userrepo;
	
	@Autowired
	private CategoryRepo categoryrepo;
	
	@Autowired
	private postResponse postResponse;
	
	
	@Override
	public PostDto createPost(Integer uid, Integer catid, PostDto postDto) {
	
	Post newpost = this.modelMapper.map(postDto, Post.class);
		
		User newuser = this.userrepo.findById(uid).orElseThrow(()-> new ResourceNotFoundException("user", "userid", uid));
		
	newpost.setUser(newuser);
		
		Category newcatCategory = this.categoryrepo.findById(catid).orElseThrow(()-> new ResourceNotFoundException("category", "category id", catid));
		
	newpost.setCategory(newcatCategory);
	
	newpost.setAddeDate(new Date());
	newpost.setImageName("defaut.png");
	
	this.postRepo.save(newpost);
	
	return this.modelMapper.map(newpost, PostDto.class);
		
		
		
		
		
		
		
		
		
		//return null;
	}

	@Override
	public PostDto updatePost(Integer postid, PostDto postDto) {
		// TODO Auto-generated method stub
		
		
		Post newpost = this.postRepo.findById(postid).orElseThrow(()->new ResourceNotFoundException("post","post id", postid));
		
		newpost.setAddeDate(new Date());
		
		newpost.setContent(postDto.getContent());
		newpost.setImageName(postDto.getImageName());
		newpost.setTitle(postDto.getTitle());
		
		Post resPost =  this.postRepo.save(newpost);
		
		return this.modelMapper.map(resPost, PostDto.class);
		
		
		
		
		
		//return null;
	}

	@Override
	public void deletePost(Integer postid) {
		
		Post post = this.postRepo.findById(postid).orElseThrow(()->new ResourceNotFoundException("post","post id", postid));
				
		this.postRepo.delete(post);
		
	//	return new Api_Response("post deletion"," sucessfully");
		
	}

	@Override
	public PostDto getSinglePost(Integer postid) {
			
		Post post = this.postRepo.findById(postid).orElseThrow(()->new ResourceNotFoundException("post","post id", postid));
		
		return this.modelMapper.map(post, PostDto.class);
	}

	
	
	// normal get all posts
//	@Override
//	public List<PostDto> getAllPosts() {
//		
//		List<Post> posts = this.postRepo.findAll();
//		
//		List<PostDto> pdto= posts.stream().map(   (post)->this.modelMapper.map(post, PostDto.class) ).collect(Collectors.toList());
//		
//		return pdto;
//	}
	
	// get all posts using pagination
	@Override
	public postResponse getAllPosts(Integer pageSize,Integer pageNumber,String sortBy) {
		
		//int pageSize=5;
	//	int pageNumber = 1;
		
		Pageable pu= PageRequest.of(pageNumber, pageSize,Sort.by(sortBy).descending());
		
	Page<Post> posts = this.postRepo.findAll((pu));
		
	//	List<Post> posts = this.postRepo.findAll();
		
		List<PostDto> pdto= posts.stream().map(   (post)->this.modelMapper.map(post, PostDto.class) ).collect(Collectors.toList());
		
		
		postResponse.setContent(pdto);
		postResponse.setPageNumber(posts.getNumber());
		postResponse.setPageSize(posts.getSize());
		postResponse.setTotalElements(posts.getTotalElements());
		postResponse.setTotalPages(posts.getTotalPages());
		postResponse.setLastPage(posts.isLast());
		
		return postResponse;
	}
	
	
	

	@Override
	public List<PostDto> getAllPostsByUser(Integer uid) {
	//	return null;
		
		User u = this.userrepo.findById(uid).orElseThrow(()->new ResourceNotFoundException("user","user id", uid));
		
		List<Post> users = this.postRepo.findByUser(u);
		
		List<PostDto> posts_Dtos =  users.stream().map((user)->this.modelMapper.map(user, PostDto.class)).collect(Collectors.toList());
		
		
		return posts_Dtos;
		
	}

	@Override
	public List<PostDto> getAllPostsByCategory(Integer catid) {
		
		  Category catgo = this.categoryrepo.findById(catid).orElseThrow(()->new ResourceNotFoundException("catego","catgo id", catid));
		  List<Post> posts = this.postRepo.findByCategory(catgo);
		  
		  List<PostDto> posts_Dtos =  posts.stream().map((cat)->this.modelMapper.map(cat, PostDto.class)).collect(Collectors.toList());
			
		  return posts_Dtos;
		  
	}

	@Override
	public List<PostDto> searchPost(String searchBy) {
		
	List<Post>	posts=  this.postRepo.findBycontentContaining(searchBy);
		
	List<PostDto> postDtos = posts.stream().map((post)-> this.modelMapper.map(post, PostDto.class)
			
			).collect(Collectors.toList());
		
		//return null;
	return postDtos;
	}
	
	

}
