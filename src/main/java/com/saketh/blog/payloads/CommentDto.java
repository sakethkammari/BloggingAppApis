package com.saketh.blog.payloads;

import com.saketh.blog.entities.Post;

public class CommentDto {
	
	private int comment_id;
	
	private String comment;
	
	private Post post;
	
	private UserDto user;

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public CommentDto() {
		super();
	}
	
	
	

}
