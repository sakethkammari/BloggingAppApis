package com.saketh.blog.payloads;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.type.StringNVarcharType;

public class CategoryDto {
	
	
	private int CategoryId;
	
	@NotEmpty
	//@Size(min=5,message = "at least 5 chars bro title")
	private String categoryTitle;
	
	@NotEmpty
	//@Size(min=10,max =25,message = " plz inc/decz matter 10-25 chars only")
	private String categoryDecsription;

	public int getCategoryId() {
		return CategoryId;
	}

	public void setCategoryId(int categoryId) {
		CategoryId = categoryId;
	}

	public String getCategoryTitle() {
		return categoryTitle;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	public String getCategoryDecsription() {
		return categoryDecsription;
	}

	public void setCategoryDecsription(String categoryDecsription) {
		this.categoryDecsription = categoryDecsription;
	}

	public CategoryDto(int categoryId, @NotNull String categoryTitle, @NotNull String categoryDecsription) {
		super();
		CategoryId = categoryId;
		this.categoryTitle = categoryTitle;
		this.categoryDecsription = categoryDecsription;
	}

	public CategoryDto() {
		super();
	}
	
	

	

	
	
	

}
