package com.siruswang.service;
 
import java.util.List;

import com.siruswang.pojo.VolEvent;
 
public interface VolEventService {
 
    List<VolEvent> list();
    List<VolEvent> get(int i);
    void add(VolEvent v);
 
}