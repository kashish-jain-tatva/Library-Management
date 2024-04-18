package com.tatva.library.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tatva.library.entities.User;
import com.tatva.library.exception.UserNameNullOrEmptyException;
import com.tatva.library.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User updateUser(User validUser) {
		Optional<User> opUser = userRepository.findById(validUser.getId());
		User user = opUser.get();
		user.setUserName(validUser.getUserName());
		return userRepository.save(user);
	}
	
	public User createUsers(User user) {
		if(user.getUserName() == null) {
			throw new UserNameNullOrEmptyException("UserName should not be Null");
		}else if(user.getUserName().isEmpty()){
			throw new UserNameNullOrEmptyException("UserName should not be Empty");
		}else if(user.getUserName().isBlank()){
			throw new UserNameNullOrEmptyException("UserName should not be Blank");
		}
		User saveUser = userRepository.save(user);
		return saveUser;
		
	}
}
