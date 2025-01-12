package com.crud.services;

import com.crud.dtos.UserDto;
import com.crud.exceptions.ResourceNotFoundException;

public interface UserService {
	
	UserDto createUser(UserDto userDto);
	
	UserDto getUser(int id) throws ResourceNotFoundException;
}
