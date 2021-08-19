package com.siruswang.service;
 
import java.util.List;

import com.siruswang.pojo.Users;
 
public interface UsersService {
 
    List<Users> list();
    Users get(int i);
    void add(Users user);
 
}