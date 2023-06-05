package com.saketh.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saketh.blog.entities.Category;
import com.saketh.blog.payloads.CategoryDto;

public interface CategoryRepo extends JpaRepository<Category, Integer>{
	
	

}
