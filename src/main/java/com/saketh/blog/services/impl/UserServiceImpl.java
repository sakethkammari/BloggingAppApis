package com.saketh.blog.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.saketh.blog.entities.User;
import com.saketh.blog.exceptions.ResourceNotFoundException;
import com.saketh.blog.payloads.UserDto;
import com.saketh.blog.repositories.UserRepo;
import com.saketh.blog.services.UserService;

import net.bytebuddy.asm.Advice.This;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userdtoo) {
		User userr = this.DtoToUser(userdtoo);
		User saveduser = this.userRepo.save(userr);
		return this.UserToDto(saveduser);
	}

	@Override
	public UserDto updateUser(UserDto userdto, Integer userid) {
		
		
		User userr = this.userRepo.findById(userid)
				.orElseThrow(()-> new ResourceNotFoundException("no resouse655","Id",userid));
			
		userr.setName(userdto.getName());
		userr.setEmail(userdto.getEmail());
		userr.setPassword(userdto.getPassword());
		userr.setAbout(userdto.getAbout());
		
		User updateduser = this.userRepo.save(userr);
		
		return this.UserToDto(updateduser);
	}

	@Override
	public UserDto getUserById(Integer userid) {
		
		
		User user = this.userRepo.findById(userid).orElseThrow(()-> new ResourceNotFoundException("not found 76", "id", userid));
		
		
		return this.UserToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		
		
		List<User> users = this.userRepo.findAll();
		
		List<UserDto> userdtos  =users.stream().map(user->this.UserToDto(user)).collect(Collectors.toList());
		
		return userdtos;
		
//		
//		List<User> users = this.userRepo.findAll();
//		
//		List<UserDto> udtol= new ArrayList<>();
//		
//		users.forEach(user->udtol.add(UserToDto(user)));
//
//		return udtol;
	}

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		
		User user = this.userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("not found 76", "id", id));
		
		
		this.userRepo.delete(user);

	}
	
	
	public User DtoToUser(UserDto userdto)
	{
		//User user=new User();
		
		User user = this.modelMapper.map(userdto, User.class);
		
//		user.setName(userdto.getName());
//		user.setId(userdto.getId());
//		user.setEmail(userdto.getEmail());
//		user.setAbout(userdto.getAbout());
//		user.setPassword(userdto.getPassword());
		
		return user;
	}
	
	public UserDto UserToDto(User user)
	{
		//UserDto udto = new UserDto();
		
		UserDto udto = this.modelMapper.map(user, UserDto.class);
		
//		udto.setAbout(user.getAbout());
//		udto.setEmail(user.getEmail());
//		udto.setId(user.getId());
//		udto.setName(user.getName());
//		udto.setPassword(user.getPassword());
		
		return udto;
	}
	
	
	
}




















