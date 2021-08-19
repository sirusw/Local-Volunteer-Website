package com.siruswang.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.siruswang.pojo.Users;
import com.siruswang.pojo.VolEvent;
import com.siruswang.pojo.Volunteer;
import com.siruswang.service.UsersService;
import com.siruswang.service.VolunteerService;

import redis.clients.jedis.Jedis;


@Controller
@RequestMapping("")
public class VolunteerController {
	
	@Autowired
	VolunteerService volunteerService;
	@Autowired
	UsersService usersService;
	
	Jedis jedis = new Jedis();
	
	@RequestMapping("regEvent")
	public ModelAndView regEvent(Volunteer volunteer, HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
		System.err.println("regEvent triggered");
		
		ModelAndView mav = new ModelAndView("redirect:/index");
		
		String sId = request.getSession().getId();
		String uid = jedis.get(sId);
		jedis.expire(sId, 300);
		
		if(uid==null ) {
			ModelAndView m = new ModelAndView("redirect:/login");
			redirectAttributes.addFlashAttribute("message","Logged out due to long period of inactivity");
			return m;
		}
		volunteerService.add(volunteer);
		Users user = usersService.get(Integer.parseInt(uid));
		
		redirectAttributes.addFlashAttribute("id", user.getId());
		redirectAttributes.addFlashAttribute("fname", user.getFname());
		redirectAttributes.addFlashAttribute("lname", user.getLname());
		redirectAttributes.addFlashAttribute("tel", user.getTel());
		return mav;
	}
	
	@RequestMapping("undoSignup")
	public ModelAndView undoSignup(Volunteer volunteer, HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
		System.err.println("regEvent triggered");
		
		ModelAndView mav = new ModelAndView("redirect:/index");
		
		String sId = request.getSession().getId();
		String uid = jedis.get(sId);
		jedis.expire(sId, 300);
		
		if(uid==null ) {
			ModelAndView m = new ModelAndView("redirect:/login");
			redirectAttributes.addFlashAttribute("message","Logged out due to long period of inactivity");
			return m;
		}
		volunteerService.delete(volunteer);
		System.out.println("test delete: "+volunteer.toString());
		Users user = usersService.get(Integer.parseInt(uid));
		
		redirectAttributes.addFlashAttribute("id", user.getId());
		redirectAttributes.addFlashAttribute("fname", user.getFname());
		redirectAttributes.addFlashAttribute("lname", user.getLname());
		redirectAttributes.addFlashAttribute("tel", user.getTel());
		return mav;
	}
	
	
}
