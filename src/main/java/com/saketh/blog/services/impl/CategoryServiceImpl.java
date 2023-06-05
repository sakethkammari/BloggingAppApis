package com.saketh.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.saketh.blog.entities.Category;
import com.saketh.blog.exceptions.ResourceNotFoundException;
import com.saketh.blog.payloads.CategoryDto;
import com.saketh.blog.payloads.UserDto;
import com.saketh.blog.services.CategoryService;

import net.bytebuddy.asm.Advice.This;

import com.saketh.blog.repositories.*;

	//@Autowired
   // private CategoryRepo categoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory( CategoryDto categoryDto) {
		// TODO Auto-generated method stub
		
		Category category = this.modelMapper.map(categoryDto, Category.class);
		
		Category cat= this.categoryRepo.save(category);
		
		
		return this.modelMapper.map(cat, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		// TODO Auto-generated method stub
		
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category ", "id", categoryId));
		
		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		cat.setCategoryDecsription(categoryDto.getCategoryDecsription());
		
		
		this.categoryRepo.save(cat);
		
		
		return this.modelMapper.map(cat, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category ", "id", categoryId));
		
		this.categoryRepo.delete(cat);
		
		
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category ", "id", categoryId));
		
		return this.modelMapper.map(cat, CategoryDto.class);
		
		//return null;
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		// TODO Auto-generated method stub
		
		List<Category> all = this.categoryRepo.findAll();
		
		List<CategoryDto> allDtos = all.stream().map((cat)-> this.modelMapper.map(cat, CategoryDto.class)
		
				).collect(Collectors.toList());
		
		
		return allDtos;
	}

}
