package com.siruswang.service.impl;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.siruswang.mapper.UsersMapper;
import com.siruswang.pojo.Users;
import com.siruswang.service.UsersService;
 
@Service
public class UsersServiceImpl  implements UsersService{
    @Autowired
    UsersMapper usersMapper;
     
    public List<Users> list(){
        return usersMapper.list();
    }
	@Override
	public void add(Users user) {
		usersMapper.add(user);
		
	}
	@Override
	public Users get(int i) {
		return usersMapper.get(i);
		
	}
	@Override
	public int update(int id, String lname, String fname, String tel, String pw) {
		// TODO Auto-generated method stub
		return usersMapper.update(id,  lname,  fname,  tel,  pw);
	}
 
}