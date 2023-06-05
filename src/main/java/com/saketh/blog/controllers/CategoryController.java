package com.saketh.blog.controllers;

import java.util.List;

import javax.validation.Valid;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.saketh.blog.payloads.Api_Response;
import com.saketh.blog.payloads.CategoryDto;
import com.saketh.blog.services.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	//post
	
	@PostMapping("/")
	private ResponseEntity<CategoryDto> createcategory(@Valid @RequestBody CategoryDto categoryDto)
	{
		CategoryDto cuser = this.categoryService.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(cuser,HttpStatus.OK);
		
	}
	
	
	// put
	
	@PutMapping("/{cid}")
	private ResponseEntity<CategoryDto> updateCatgo(@Valid @RequestBody CategoryDto categoryDto,@PathVariable Integer cid)
	{
		CategoryDto categoryDto2 =this.categoryService.updateCategory(categoryDto, cid);
		
		return new ResponseEntity<>(categoryDto2,HttpStatus.OK);
	}
	
	// delete
	
	
	@DeleteMapping("/{cid}")
	private ResponseEntity<Api_Response> deleteCatgo( @PathVariable Integer cid)
	{
		this.categoryService.deleteCategory(cid);
		
		return new ResponseEntity<Api_Response>(new Api_Response("id ","deleted sucessfully bro"),HttpStatus.OK);
	}
	
	
	// get 
	
	@GetMapping("/{cid}")
	private ResponseEntity<CategoryDto> getcategory(@PathVariable Integer cid)
	{
		CategoryDto cdt2 = this.categoryService.getCategory(cid);
		
		return new ResponseEntity<CategoryDto>(cdt2,HttpStatus.OK);
	}
	
	// get all
	
	@GetMapping("/")
	private ResponseEntity<List<CategoryDto>> getallCatgos()
	{
		List<CategoryDto> list=this.categoryService.getAllCategory();
		return new ResponseEntity<List<CategoryDto>>(list, HttpStatus.OK);
	}
	
	

}
