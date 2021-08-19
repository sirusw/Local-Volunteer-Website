package com.siruswang.service.impl;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.siruswang.mapper.VolEventMapper;
import com.siruswang.mapper.VolunteerMapper;
import com.siruswang.pojo.VolEvent;
import com.siruswang.pojo.Volunteer;
import com.siruswang.service.VolEventService;
import com.siruswang.service.VolunteerService;
 
@Service
public class VolunteerServiceImpl  implements VolunteerService{
    @Autowired
    VolunteerMapper volunteerMapper;
     
    public List<Volunteer> list(){
        return volunteerMapper.list();
    }
	@Override
	public void add(Volunteer volunteer) {
		volunteerMapper.add(volunteer);
		
	}
	@Override
	public List<Volunteer> get(int i) {
		return volunteerMapper.get(i);
		
	}
	@Override
	public void delete(Volunteer v) {
		volunteerMapper.delete(v);
		
	}
	@Override
	public List<Volunteer> count() {
		return volunteerMapper.count();
	}
	@Override
	public List<Volunteer> getEventParticipants(int i) {
		return volunteerMapper.getEventParticipants(i);
	}
 
}