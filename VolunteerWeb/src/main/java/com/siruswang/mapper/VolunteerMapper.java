package com.siruswang.mapper;

import java.util.List;

import com.siruswang.pojo.Users;
import com.siruswang.pojo.VolEvent;
import com.siruswang.pojo.Volunteer;

public interface VolunteerMapper {
	
	public int add(Volunteer v); 

	public void delete(Volunteer v); 

	public List<Volunteer> get(int id); 
	
	public List<Volunteer> getEventParticipants(int id); 
	public int update(Volunteer v);  
	
	public int setComplete(Volunteer v);

	public List<Volunteer> list();

	public List<Volunteer> count();

	
}
