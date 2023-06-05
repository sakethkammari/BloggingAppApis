package com.saketh.blog.services;

import java.util.List;

import com.saketh.blog.payloads.CategoryDto;

public interface CategoryService {
	
	// create
	
		  CategoryDto createCategory(CategoryDto categoryDto);
		
		
		
		// update 
		  
		  CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
		
		// delete 
		  
		  void deleteCategory(Integer categoryId);
		
		// get 
		  
		  CategoryDto getCategory(Integer categoryId);
		
		
		// get all
		  
		  List<CategoryDto> getAllCategory();

}
