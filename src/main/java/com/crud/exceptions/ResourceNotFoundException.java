package com.crud.exceptions;

public class ResourceNotFoundException extends Exception{
	
	public String user;
	public String userId;
	public Integer id;
	public ResourceNotFoundException(String user,String userId,Integer id){
		super(String.format("%s not found with %s : %s",user,userId,id));
		this.user = user;
		this.userId = userId;
		this.id = id;
	}
}
