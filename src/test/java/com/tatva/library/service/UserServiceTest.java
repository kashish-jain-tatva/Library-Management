package com.tatva.library.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tatva.library.entities.User;
import com.tatva.library.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	@InjectMocks
	private UserService userService;
	
	@Mock
	private UserRepository userRepo;
	
	private static User userWithNullUsername,userWithEmptyUserName,validUser;
	
	@BeforeAll
	static void setUp() {
		userWithNullUsername = User.builder().userName(null).build();
		userWithEmptyUserName = User.builder().userName("").build();
		validUser = User.builder().userName("Kashish").id(1l).build();
	}
	
	@Test
	public void updateUser_ValidUserThenReturnUpdatedUser() {
		when(userRepo.findById(validUser.getId())).thenReturn(Optional.of(validUser));
		when(userRepo.save(validUser)).thenReturn(validUser);
		User user = userService.updateUser(validUser);
		assertNotNull(user);
	}

}
