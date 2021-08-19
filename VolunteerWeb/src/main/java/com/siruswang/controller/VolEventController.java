package com.siruswang.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.siruswang.pojo.VolEvent;
import com.siruswang.service.VolEventService;

import redis.clients.jedis.Jedis;
@Controller
@RequestMapping("")
public class VolEventController {
	@Autowired
	VolEventService vService;
	
	Jedis jedis = new Jedis();
	
	@RequestMapping("addEvent")
	public ModelAndView addEvent(VolEvent v, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		System.out.println("addEvent triggered");
		String sId = request.getSession().getId();
		String uid = jedis.get(sId);
		jedis.expire(sId, 300);
		System.out.println("uid addevent: " + uid);
		
		if(uid==null ) {
			ModelAndView mav = new ModelAndView("redirect:/login");
			redirectAttributes.addFlashAttribute("message", "Please log in!");
			return mav;
		}
		else {
			vService.add(v);
			ModelAndView mav = new ModelAndView("redirect:/index");
			return mav;
		}
		
	}
	
	@RequestMapping("listVolEvent")
	public ModelAndView listVolEvent(VolEvent v) {
		ModelAndView mav = new ModelAndView("redirect:/index");
		List<VolEvent> lv = vService.list();
		mav.addObject("lv", lv);
		return mav;
	}
}
