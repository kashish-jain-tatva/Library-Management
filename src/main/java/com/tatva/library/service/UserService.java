package com.tatva.library.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tatva.library.entities.User;
import com.tatva.library.exception.ResourceNotFoundException;
import com.tatva.library.exception.UserNameNullOrEmptyException;
import com.tatva.library.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User updateUser(User validUser) {
		if(validUser.getUserName() == null || validUser.getUserName().isBlank() || validUser.getUserName().isEmpty()) {
			throw new UserNameNullOrEmptyException("username should not be null or blank or empty");
		}
		Optional<User> opUser = userRepository.findById(validUser.getId());
		User user;
		if(opUser.isEmpty()) {
			throw new ResourceNotFoundException("user not found");
		}
		user = opUser.get();
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

	public boolean deleteUser(Long id) {
		if(userRepository.findById(id).isEmpty()) {
			throw new ResourceNotFoundException("user not found");
		}
		userRepository.deleteById(id);
		return true;
	}
}
