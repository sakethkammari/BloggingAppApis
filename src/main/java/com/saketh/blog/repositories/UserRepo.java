package com.saketh.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saketh.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
