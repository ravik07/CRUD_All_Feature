package com.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.dtos.UserDto;
import com.crud.exceptions.ResourceNotFoundException;
import com.crud.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping(value="/create")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
		UserDto createdUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createdUserDto,HttpStatus.CREATED);
	}
	
	@GetMapping(value="/get/{userId}")
	public ResponseEntity<UserDto> createUser(@PathVariable int userId) throws ResourceNotFoundException {
		UserDto createdUserDto = this.userService.getUser(userId);
		return new ResponseEntity<>(createdUserDto,HttpStatus.CREATED);
	}
	
	

}
