package com.crud.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	private int userId;
	
	@NotEmpty(message ="{user.name1}")
	private String name;
	
	@NotEmpty(message = "{user.password_1}")
	private String password;

}
