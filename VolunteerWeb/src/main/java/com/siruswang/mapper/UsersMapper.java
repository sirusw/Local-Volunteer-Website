package com.siruswang.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.siruswang.pojo.Users;

public interface UsersMapper {
	
	public int add(Users user); 

	public void delete(int id); 

	public Users get(int id); 

	public int update(@Param("id")int id, @Param("lname")String lname, @Param("fname")String fname, @Param("tel")String tel, @Param("pw")String pw); 

	public List<Users> list();

	public int count(); 
	
}
