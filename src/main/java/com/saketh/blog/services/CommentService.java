package com.saketh.blog.services;

import com.saketh.blog.entities.Post;
import com.saketh.blog.payloads.CommentDto;
import com.saketh.blog.payloads.PostDto;

public interface CommentService {
	
	 PostDto createComment(CommentDto commentDto,Integer postId);
	 
	 void deleteComment(Integer commentId);

}
