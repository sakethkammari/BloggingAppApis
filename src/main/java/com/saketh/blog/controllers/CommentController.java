package com.saketh.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saketh.blog.entities.Post;
import com.saketh.blog.exceptions.ResourceNotFoundException;
import com.saketh.blog.payloads.CommentDto;
import com.saketh.blog.payloads.PostDto;
import com.saketh.blog.repositories.PostRepo;
import com.saketh.blog.services.CommentService;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
	
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private PostRepo postRepo;
	
	@PostMapping("/{cid}")
	private ResponseEntity<PostDto> createComment(@RequestBody CommentDto commentDto,@PathVariable Integer cid)
	{
		
		//Post p = this.postRepo.findById(cid).orElseThrow(()->new ResourceNotFoundException("post", "p id", cid));
		
		PostDto createComment = this.commentService.createComment(commentDto, cid);
		
		return new ResponseEntity<PostDto>(createComment,HttpStatus.CREATED);
	}

}
