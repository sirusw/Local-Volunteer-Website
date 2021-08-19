package com.siruswang.service.impl;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.siruswang.mapper.VolEventMapper;
import com.siruswang.pojo.VolEvent;
import com.siruswang.service.VolEventService;
 
@Service
public class VolEventServiceImpl  implements VolEventService{
    @Autowired
    VolEventMapper vMapper;
     
    public List<VolEvent> list(){
        return vMapper.list();
    }
	@Override
	public void add(VolEvent v) {
		vMapper.add(v);
		
	}
	@Override
	public List<VolEvent> get(int i) {
		return vMapper.get(i);
		
	}
 
}