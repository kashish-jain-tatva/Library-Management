package com.tatva.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tatva.library.entities.User;
import com.tatva.library.exception.UserNameNullOrEmptyException;
import com.tatva.library.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
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
