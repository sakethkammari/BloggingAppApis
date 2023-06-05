package com.saketh.blog.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import net.bytebuddy.dynamic.TypeResolutionStrategy.Lazy;

@Entity
public class Category {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CategoryId;
	
	@Column(name="title")
	private String categoryTitle;
	
	@Column(name="descripton")
	private String categoryDecsription;
	
	
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Post> posts = new ArrayList<>() ;
	
	
	

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

	public Category(int categoryId, String categoryTitle, String categoryDecsription) {
		super();
		CategoryId = categoryId;
		this.categoryTitle = categoryTitle;
		this.categoryDecsription = categoryDecsription;
	}

	public Category() {
		super();
	}
	
	
	
}
	
