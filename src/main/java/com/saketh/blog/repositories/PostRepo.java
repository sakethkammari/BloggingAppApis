package com.saketh.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import com.saketh.blog.entities.Category;
import com.saketh.blog.entities.Post;
import com.saketh.blog.entities.User;
import com.saketh.blog.payloads.CategoryDto;
import com.saketh.blog.payloads.PostDto;

public interface PostRepo extends JpaRepository<Post, Integer> {
	
	List<Post> findByUser(User user);
	
   List<Post> findByCategory(Category category);
   
   List<Post> findBycontentContaining(String searchBy);
   
   // or 
   @Query("select p from Post p where p.content like :key")
   List<Post> searchCustomMethod(@Param("key") String title);

}
