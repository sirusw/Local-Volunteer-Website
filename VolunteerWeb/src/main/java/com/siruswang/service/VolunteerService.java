package com.siruswang.service;
 
import java.util.List;

import com.siruswang.pojo.Volunteer;
 
public interface VolunteerService {
 
    List<Volunteer> list();
    List<Volunteer> get(int i);
    List<Volunteer> getEventParticipants(int i);
    void add(Volunteer v);
    void delete(Volunteer v);
    List<Volunteer> count();
}