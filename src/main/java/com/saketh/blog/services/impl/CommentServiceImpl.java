package com.saketh.blog.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saketh.blog.entities.Comment;
import com.saketh.blog.entities.Post;
import com.saketh.blog.exceptions.ResourceNotFoundException;
import com.saketh.blog.payloads.CommentDto;
import com.saketh.blog.payloads.PostDto;
import com.saketh.blog.repositories.CommentRepo;
import com.saketh.blog.repositories.PostRepo;
import com.saketh.blog.services.CommentService;
import com.saketh.blog.services.PostService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PostService postService;
	
	
	@Override
	public PostDto createComment(CommentDto commentDto, Integer postId) {
		
		Post post = postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("post", " p id not fount", postId));
		

		
		Set<CommentDto> set=new HashSet<>();
		set.add(commentDto);
		
	Comment c = this.modelMapper.map(set, Comment.class);
	commentRepo.save(c);
		
		Set<Comment> reSet = new HashSet<>();
		reSet.add(c);
		
		 //post.setComments(reSet);
		 
		return  this.postService.updatePost(postId, this.modelMapper.map(post, PostDto.class));
		
		
		
		
		//return null;
	}

	@Override
	public void deleteComment(Integer commentId) {
		

	}

}






