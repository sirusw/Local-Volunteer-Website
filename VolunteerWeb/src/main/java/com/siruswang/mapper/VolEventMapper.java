package com.siruswang.mapper;

import java.util.List;

import com.siruswang.pojo.Users;
import com.siruswang.pojo.VolEvent;

public interface VolEventMapper {
	
	public int add(VolEvent v); 

	public void delete(int id); 

	public List<VolEvent> get(int id); 

	public int update(VolEvent v);  
	
	public int setComplete(VolEvent v);

	public List<VolEvent> list();

	public int count(); 
	
}
