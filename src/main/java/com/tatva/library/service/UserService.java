package com.tatva.library.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.tatva.library.entities.User;
import com.tatva.library.repository.UserRepository;

public class UserService {
	
	@Autowired
	private UserRepository userRepo;

	public User updateUser(User validUser) {
		Optional<User> opUser = userRepo.findById(validUser.getId());
		User user = opUser.get();
		user.setUserName(validUser.getUserName());
		return userRepo.save(user);
	}

}
