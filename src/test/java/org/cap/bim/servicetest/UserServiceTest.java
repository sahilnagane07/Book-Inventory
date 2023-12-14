package org.cap.bim.servicetest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.cap.bim.model.PermRole;
import org.cap.bim.model.User;
import org.cap.bim.repository.IUserRepository;
import org.cap.bim.service.UserImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

	@Mock
	private IUserRepository userRepository;
	
	@InjectMocks
	private UserImpl userImpl;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void testAddUser(){
		User user=new User(1,"Vignesh", "Siva", "(717) 565-0975", "Siva123@gmail.com","Siva@123", 0, new PermRole(1,"Guest"));
		when(userRepository.save(user)).thenReturn(user);
		User user1=userImpl.addUser(user);
		assertEquals(user1, user);
	}
	 
	@Test
	void testGetUserById() {
		Integer userId=1;
		User user=new User(userId,"Vignesh", "Siva", "(717) 565-0975", "Siva123@gmail.com","Siva@123", userId, new PermRole(1,"Guest"));
		when(userRepository.findById(userId)).thenReturn(Optional.of(user));
		User user1=userImpl.getUserById(userId);
		assertEquals(user1, user);
	}
	
	@Test
	void testUpdateFirstNameById() {
		Integer userId=1;
		User user=new User(userId,"Vignesh", "Siva", "(717) 565-0975", "Siva123@gmail.com","Siva@123", userId, new PermRole(1,"Guest"));
		User user1=new User(userId, "Vignesh", "Rahul", "(717) 565-0975", "Siva123@gmail.com","Siva@123", userId, new PermRole(1,"Guest"));
		when(userRepository.findById(userId)).thenReturn(Optional.of(user));
		when(userRepository.save(any(User.class))).thenReturn(user1);
		User user2=userImpl.updateFirstNameById(userId, user1);
		assertEquals(user1, user2);
	}
	
	@Test
	void testUpdateLastNameById() {
		Integer userId=2;
		User user=new User(userId,"Vignesh", "Siva", "(717) 565-0975", "Siva123@gmail.com","Siva@123", userId, new PermRole(1,"Guest"));
		User user1=new User(userId, "Ganesh", "Siva", "(717) 565-0975", "Siva123@gmail.com","Siva@123", userId, new PermRole(1,"Guest"));
		when(userRepository.findById(userId)).thenReturn(Optional.of(user));
		when(userRepository.save(any(User.class))).thenReturn(user1);
		User user2=userImpl.updateLastNameById(userId, user1);
		assertEquals(user1, user2);
	}
	
	@Test
	void testUpdatePhoneNumberById() {
		Integer userId=3;
		User user=new User(userId,"Vignesh", "Siva", "(717) 565-0975", "Siva123@gmail.com","Siva@123", userId, new PermRole(1,"Guest"));
		User user1=new User(userId, "Vignesh", "Siva", "(787) 235-9775", "Siva123@gmail.com","Siva@123", userId, new PermRole(1,"Guest"));
		when(userRepository.findById(userId)).thenReturn(Optional.of(user));
		when(userRepository.save(any(User.class))).thenReturn(user1);
		User user2=userImpl.updatePhoneNumberById(userId, user1);
		assertEquals(user1, user2);
	}
}
