package com.saketh.blog.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.saketh.blog.payloads.Api_Response;
import com.saketh.blog.payloads.UserDto;
import com.saketh.blog.services.UserService;

@RestController
@RequestMapping("/api/users")
//@ComponentScan("com.saketh.blog.services")
public class UserController {
	
	@Autowired
	private UserService userserivce;
	
	
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userdto)
	{
		System.out.println("enetred");
		   UserDto created_userdto = this.userserivce.createUser(userdto);
		   	return new ResponseEntity<>(created_userdto,HttpStatus.CREATED);
	}
	
	// post create user
	// put update user 
	// delete   delete user
	//  get      get all users 
	
    @PutMapping("/{userid}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userdto,@PathVariable("userid") Integer uid)
    {
    	 UserDto updateduser = this.userserivce.updateUser(userdto, uid) ;
    	
    	 
    	 return ResponseEntity.ok(updateduser);
    }
    
    @DeleteMapping("/{userid}")
    public ResponseEntity<Api_Response> deleteuser(@PathVariable("userid") Integer uid)
    {
    	this.userserivce.deleteUser(uid);
      // return new ResponseEntity(Map.of("message","user deteletd sucessfully bro"),HttpStatus.OK);
      // or 
    	return new ResponseEntity<Api_Response>(new Api_Response("message","user deleted succesfully"),HttpStatus.OK);
    }
    
    
    //get
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers()
    {
    	return ResponseEntity.ok(this.userserivce.getAllUsers());
    }
    
    @GetMapping("/{userid}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable("userid") Integer uid)
    {
    	return ResponseEntity.ok(this.userserivce.getUserById(uid));
    }
   
}









