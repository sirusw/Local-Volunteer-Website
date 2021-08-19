package com.siruswang.mapper;

import java.util.List;

import com.siruswang.pojo.Users;

public interface UsersMapper {
	
	public int add(Users user); 

	public void delete(int id); 

	public Users get(int id); 

	public int update(Users user); 

	public List<Users> list();

	public int count(); 
	
}
