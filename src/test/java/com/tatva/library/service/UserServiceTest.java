package com.tatva.library.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tatva.library.entities.User;
import com.tatva.library.exception.ResourceNotFoundException;
import com.tatva.library.exception.UserNameNullOrEmptyException;
import com.tatva.library.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private UserService userService;
	
	private static User userWithValidUserName , userWithNullUserName , userWithEmptyUserName,userWithBlankUserName;

	@BeforeAll
	static void setUp() {
		userWithValidUserName = User.builder().id(1L).userName("Priya")
				.build();
		
		userWithNullUserName = User.builder().userName(null).build();
		
		userWithEmptyUserName = User.builder().userName("").build();
		
		userWithBlankUserName = User.builder().userName(" ").build();
		
	}
	
	@Test
	public void updateUser_ValidUserThenReturnUpdatedUser() {
		when(userRepository.findById(userWithValidUserName.getId())).thenReturn(Optional.of(userWithValidUserName));
		when(userRepository.save(userWithValidUserName)).thenReturn(userWithValidUserName);
		User user = userService.updateUser(userWithValidUserName);
		assertNotNull(user);
	}
	
	@Test
	public void createUserWithValidUserName() {
		when(userRepository.save(userWithValidUserName)).thenReturn(userWithValidUserName);
		User user = userService.createUsers(userWithValidUserName);
		assertEquals(user.getUserName(), userWithValidUserName.getUserName());
	}
	
	@Test
	public void createUserThrowException() {
		assertThrows(UserNameNullOrEmptyException.class, ()->{
			User user = userService.createUsers(userWithNullUserName);
		});
	}
	
	
	@Test
	public void createUserWithEmptyUserName() {
		assertThrows(UserNameNullOrEmptyException.class, ()->{
			User user = userService.createUsers(userWithEmptyUserName);
		});
	}
	
	@Test
	public void createUserWithBlankUserName() {
//		assertThrows(UserNameNullOrEmptyException.class, ()->{
//			User user = userService.createUsers(userWithBlankUserName);
//		});
		
		assertThrowsExactly(UserNameNullOrEmptyException.class, ()->{
			 userService.createUsers(userWithBlankUserName);
		},"UserName should not be Blank");
	}
//	
	
//	@Test
//	public void getUserDetails() {
//		List<User> userList = userService.getUserDetails();
//		assertEquals(1, userList.size());
//	}
	
	
	@Test
	public void updateUser_UserNotFound_ThenThrowsResourceNotFoundException() {
		when(userRepository.findById(userWithValidUserName.getId())).thenReturn(Optional.empty());
		assertThrows(ResourceNotFoundException.class, () -> {
			userService.updateUser(userWithValidUserName);
		});
	}
	
	@Test
	public void updateUser_UsernameNull_ThenThrowsUserNameNullOrEmptyException() {
		assertThrows(UserNameNullOrEmptyException.class, () -> {
			userService.updateUser(userWithNullUserName);
		});
	}
	
	@Test
	public void updateUser_UsernameEmpty_ThenThrowsUserNameNullOrEmptyException() {
		assertThrows(UserNameNullOrEmptyException.class, () -> {
			userService.updateUser(userWithEmptyUserName);
		});
	}
	
	@Test
	public void updateUser_UsernameBlank_ThenThrowsUserNameNullOrEmptyException() {
		assertThrows(UserNameNullOrEmptyException.class, () -> {
			userService.updateUser(userWithEmptyUserName);
		});
	}
	
	@Test
	public void deleteUser_validUser_ThenReturnSuccess() {
		when(userRepository.findById(userWithValidUserName.getId())).thenReturn(Optional.of(userWithValidUserName));
		assertTrue(userService.deleteUser(userWithValidUserName.getId()));
	}
	
	@Test
	public void deleteUser_userNotFound_ThenThrowsResourceNotFoundException() {
		assertThrows(ResourceNotFoundException.class, () -> {
			userService.deleteUser(userWithValidUserName.getId());
		});
	}
	
	
}
