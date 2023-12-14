package org.cap.bim.controller;

import org.cap.bim.model.User;
import org.cap.bim.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/user")
@RestController
public class UserController {
	@Autowired
	private IUserService userService;
	
	@PostMapping("/post")
	public ResponseEntity<String> addNewUser(@RequestBody User user){
		User user1=userService.addUser(user);
		if(user1!=null) {
			return new ResponseEntity<String>("User added successfully", HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Creation Error!",HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable ("userId") Integer userId){
		User user=userService.getUserById(userId);
		if(user==null) {
			return new ResponseEntity("User id : "+userId+"is not found!",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@PutMapping("/update/firstname/{userId}")
	public ResponseEntity<User> updateFirstNameById(@PathVariable ("userId") Integer userId,@RequestBody User user){
		User user1=userService.updateFirstNameById(userId, user);
		if(user1==null) {
			return new ResponseEntity("User id : "+userId+"is not found!",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user1, HttpStatus.OK);
	}
	
	@PutMapping("/update/lastname/{userId}")
	public ResponseEntity<User> updateLastNameById(@PathVariable ("userId") Integer userId,@RequestBody User user){
		User user1=userService.updateLastNameById(userId, user);
		if(user1==null) {
			return new ResponseEntity("User id : "+userId+"is not found!",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user1, HttpStatus.OK);
	}
	
	@PutMapping("/update/phonenumber/{userId}")
	public ResponseEntity<User> updatePhoneNumberById(@PathVariable ("userId") Integer userId,@RequestBody User user){
		User user1=userService.updatePhoneNumberById(userId, user);
		if(user1==null) {
			return new ResponseEntity("User id : "+userId+"is not found!",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user1, HttpStatus.OK);
	}
}
