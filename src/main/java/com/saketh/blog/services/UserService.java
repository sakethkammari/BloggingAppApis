package com.saketh.blog.services;

import com.saketh.blog.payloads.UserDto;

import java.util.*;

public interface UserService {
	
	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user,Integer userid);
	UserDto getUserById(Integer userid);
    List<UserDto> getAllUsers();
    
    void deleteUser(Integer id);

}
