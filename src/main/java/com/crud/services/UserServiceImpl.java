package com.crud.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.dtos.UserDto;
import com.crud.entities.User;
import com.crud.exceptions.ResourceNotFoundException;
import com.crud.repositories.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());
		
		User savedUser = this.userRepo.save(user);
		
		UserDto savedUserDto = new UserDto();
		savedUserDto.setUserId(savedUser.getUserId());
		savedUserDto.setName(savedUser.getName());
		savedUserDto.setPassword(savedUser.getPassword());
		
		return savedUserDto;
	}

	@Override
	public UserDto getUser(int userId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","userId : ",userId));
		return this.modelMapper.map(user, UserDto.class);
	}
	
	
}
