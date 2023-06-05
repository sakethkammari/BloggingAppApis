package com.saketh.blog.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	
	String resourcename;
	String fieldname;
	long id;
	public String getResourcename() {
		return resourcename;
	}
	public void setResourcename(String resourcename) {
		this.resourcename = resourcename;
	}
	public String getFieldname() {
		return fieldname;
	}
	public void setFieldname(String fieldname) {
		this.fieldname = fieldname;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public ResourceNotFoundException(String resourcename, String fieldname, long id) {
		super(String.format("%s not found with %s : %s",resourcename,fieldname,id));
		this.resourcename = resourcename;
		this.fieldname = fieldname;
		this.id = id;
	}
	
	

}
