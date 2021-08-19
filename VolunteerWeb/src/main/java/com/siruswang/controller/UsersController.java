package com.siruswang.controller;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.siruswang.pojo.Users;
import com.siruswang.pojo.VolEvent;
import com.siruswang.pojo.Volunteer;
import com.siruswang.service.UsersService;
import com.siruswang.service.VolEventService;
import com.siruswang.service.VolunteerService;

import redis.clients.jedis.Jedis;

// 告诉spring mvc这是一个控制器类
@Controller
@RequestMapping("")
public class UsersController {
	@Autowired
	UsersService usersService;
	@Autowired
	VolEventService vService;
	@Autowired
	VolunteerService volunteerService;
	
	Jedis jedis = new Jedis();
	
	public static String dropdownHTML = "			<div class=\"btn-group\">\r\n"
			+ "			<button type=\"button\" class=\"btn btn-default btn-lg dropdown-toggle \"  data-toggle=\"dropdown\">\r\n"
			+ "			<span class=\"glyphicon glyphicon-menu-hamburger\"></span>         \r\n"
			+ "			</button>  \r\n"
			+ "		      \r\n"
			+ "		    <ul class=\"dropdown-menu\" role=\"menu\">\r\n"
			+ "		      <li>\r\n"
			+ "		         <a href=\"settings\">Settings</a>            \r\n"
			+ "		      </li>\r\n"
			+ "		      <li role=\"presentation\">\r\n"
			+ "		         <a href=\"logout\">Logout</a>             \r\n"
			+ "		      </li>\r\n"
			+ "		  \r\n"
			+ "		    </ul>\r\n"
			+ "		    </div> ";
	
	public static String btnHeader = "<form action=\"register\" style=\"display:inline\">\r\n"
			+ "                <input type=\"submit\" class=\"btn btn-primary\" value=\"Register\" />\r\n"
			+ "            </form>\r\n"
			+ "            <form action=\"login\" style=\"display:inline\">\r\n"
			+ "                <input type=\"submit\" class=\"btn btn-default\" value=\"Login\" />\r\n"
			+ "            </form>\r\n";

	@RequestMapping("listName")
	public ModelAndView listName(){
		ModelAndView mav = new ModelAndView();
		List<Users> cs= usersService.list();

		// 放入转发参数
		mav.addObject("cs", cs);
		// 放入jsp路径
		mav.setViewName("listName");
		return mav;
	}
	@RequestMapping("")
	public ModelAndView defaultSite() {
		ModelAndView mav = new ModelAndView("redirect:/index");

		return mav;
	}

	@RequestMapping("index")
	public ModelAndView index(Users user, HttpServletRequest request) {

		System.err.println(user.toString());
		System.err.println(request.getSession().getId());
		ModelAndView mav = new ModelAndView();
		mav.addObject("lv",vService.list());
		
		String sId = request.getSession().getId();
		boolean exists = jedis.exists(sId);
		if(!exists){
			mav.addObject("btnHeader", btnHeader);
		}
		else {
			String uid = jedis.get(sId);
			Users u = usersService.get(Integer.parseInt(uid));
			System.out.println("uid: " + uid + "\nUser toString: " + u.toString());
			mav.addObject("id", u.getId());
			mav.addObject("fname", u.getFname());
			mav.addObject("lname", u.getLname());
			mav.addObject("tel", u.getTel());
			
			user = u;
			
			mav.addObject("btnHeader", "<h5 style=\"display:inline\">You are logged in as " + user.getFname() + " " + user.getLname() + "</h5> " + dropdownHTML);
			mav.addObject("id", user.getId());
			mav.addObject("volParticipated", volunteerService.get(user.getId()));
			System.out.println("GET COUNT: "+volunteerService.count());
			mav.addObject("numPeopleParticipated", volunteerService.count());
		}
		return mav;
	}
	
	@RequestMapping("settings")
	public ModelAndView settings(Users user, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		System.err.println(user.toString());
		System.err.println(request.getSession().getId());
		ModelAndView mav = new ModelAndView();
		mav.addObject("lv",vService.list());
		
		String sId = request.getSession().getId();
		boolean exists = jedis.exists(sId);
		if(!exists){
			mav = new ModelAndView("redirect:/login");
			redirectAttributes.addFlashAttribute("message", "Please log in!");
		}
		else {
			String uid = jedis.get(sId);
			Users u = usersService.get(Integer.parseInt(uid));
			System.out.println("SETTINGS uid: " + uid + "\nUser toString: " + u.toString());
			mav.addObject("id", u.getId());
			mav.addObject("fname", u.getFname());
			mav.addObject("lname", u.getLname());
			mav.addObject("tel", u.getTel());
			
			user = u;
			
			mav.addObject("btnHeader", "<h5 style=\"display:inline\">You are logged in as " + user.getFname() + " " + user.getLname() + "</h5> " + dropdownHTML);
			mav.addObject("id", user.getId());
			mav.addObject("volParticipated", volunteerService.getEventParticipated(user.getId()));
			mav.addObject("user", usersService.get(user.getId()));
			mav.addObject("numPeopleParticipated", volunteerService.count());
			
			
			List<VolEvent> events = vService.get(Integer.parseInt(uid));
			List<List<Volunteer>> listOfListVolunteer = new ArrayList<List<Volunteer>>();
			for(VolEvent event: events) {
				int eid = event.getId();
				
				List<Volunteer> listVolunteer = volunteerService.getEventParticipants(eid);
				System.out.println("eid: " + eid + " Volunteer: "+listVolunteer.toString());
				listOfListVolunteer.add(listVolunteer);
			}
			mav.addObject("eventPosted", events);
			mav.addObject("listVolunteer", listOfListVolunteer);
		}
		return mav;
	}
	
	@RequestMapping("changeInfo")
	public ModelAndView changeInfo(Users user, String fname, String lname, String tel, String pw, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		System.err.println(user.toString());
		System.err.println(request.getSession().getId());
		ModelAndView mav = new ModelAndView("redirect:/settings");
		
		String sId = request.getSession().getId();
		boolean exists = jedis.exists(sId);
		if(!exists){
			mav = new ModelAndView("redirect:/login");
			redirectAttributes.addFlashAttribute("message", "Please log in!");
		}
		else {
			String uid = jedis.get(sId);
			System.err.println("Update return:" + usersService.update(Integer.parseInt(uid), lname,fname,tel,pw));
			Users u = usersService.get(Integer.parseInt(uid));
			redirectAttributes.addFlashAttribute("user", usersService.get(user.getId()));

			
			System.out.println("SETTINGS uid: " + uid + "\nUser toString: " + u.toString());
			redirectAttributes.addFlashAttribute("id", user.getId());
			redirectAttributes.addFlashAttribute("fname", user.getFname());
			redirectAttributes.addFlashAttribute("lname", user.getLname());
			redirectAttributes.addFlashAttribute("tel", user.getTel());
			
			user = u;
			
			redirectAttributes.addFlashAttribute("btnHeader", "<h5 style=\"display:inline\">You are logged in as " + user.getFname() + " " + user.getLname() + "</h5> " + dropdownHTML);
			redirectAttributes.addFlashAttribute("id", user.getId());
			redirectAttributes.addFlashAttribute("volParticipated", volunteerService.getEventParticipated(user.getId()));
			
			redirectAttributes.addFlashAttribute("numPeopleParticipated", volunteerService.count());
			
			
			redirectAttributes.addFlashAttribute("updateMsg", "<h4>Updated!</h4>");
		}
		return mav;
	}

	@RequestMapping("login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		return mav;
	}

	@RequestMapping("logout")
	public ModelAndView logout(Users user, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("redirect:/index");
		jedis.del(request.getSession().getId());
		request.getSession().invalidate();
		return mav;
	}

	@RequestMapping("register")
	public ModelAndView register() {
		ModelAndView mav = new ModelAndView();
		return mav;
	}

	@RequestMapping("regSuccess")
	public ModelAndView regSuccess(Users user) {
		usersService.add(user);
		ModelAndView mav = new ModelAndView();
		return mav;
	}

	@RequestMapping("loginCheck")
	public ModelAndView login(Users user, HttpServletRequest request){
		String sId = request.getSession().getId();
		boolean exists = jedis.exists(sId);
		if(!exists) {
			List<Users> us= usersService.list();
			for(int i=0;i<us.size();i++) {
				if(us.get(i).getTel().equals(user.getTel()) && us.get(i).getPw().equals(user.getPw())) {
					Users temp = us.get(i);
					String redisInfo = jedis.set(sId, ""+temp.getId());
					
					System.out.println("redis set! sid: " +sId + " value: "+temp.getId() +"\n" +redisInfo + "\n"+jedis.get(sId));
					jedis.expire(sId, 300);
					
					request.setAttribute("id", temp.getId());
					request.setAttribute("fname", temp.getFname());
					request.setAttribute("lname", temp.getLname());
					request.setAttribute("tel", temp.getTel());
					
					ModelAndView mav = new ModelAndView("loginCheck");
					mav.addObject("user",us.get(i));
					return mav;
				}
			}
			System.out.println(user.toString() + " " + request.getSession().getId());
			
			ModelAndView mav = new ModelAndView("login");
			mav.addObject("message", "Phone number and password don't match!");
			return mav;
		}
		else {
			
			jedis.expire(sId, 300);
			ModelAndView mav = new ModelAndView("loginCheck");
			return mav;
		}
	}
	
	@RequestMapping("checkLoginStatus")
	public ModelAndView checkLoginStatus(Users user, HttpServletRequest request) {
		String sId = request.getSession().getId();
		boolean exists = jedis.exists(sId);
		if(!exists) {
			List<Users> us= usersService.list();
			for(int i=0;i<us.size();i++) {
				if(us.get(i).getTel().equals(user.getTel()) && us.get(i).getPw().equals(user.getPw())) {
					Users temp = us.get(i);
					jedis.set(sId, "1");
					jedis.expire(sId, 300);
					
					request.setAttribute("id", temp.getId());
					request.setAttribute("fname", temp.getFname());
					request.setAttribute("lname", temp.getLname());
					request.setAttribute("tel", temp.getTel());
					
					ModelAndView mav = new ModelAndView("checkLoginStatus");
					mav.addObject("user",us.get(i));
					return mav;
				}
			}
			System.out.println(user.toString() + " " + request.getSession().getId());
			
			ModelAndView mav = new ModelAndView("login");
			mav.addObject("message", "Phone number and password don't match!");
			return mav;
		}
		else {
			jedis.expire(sId, 300);
			ModelAndView mav = new ModelAndView("checkLoginStatus");
			return mav;
		}
	}
	
	@RequestMapping("online")
	public ModelAndView online() {
		ModelAndView mav = new ModelAndView("online");
		Set<String> keys = jedis.keys("*");
		List<String> keyList = new ArrayList<String>();
		for(String key: keys) {
			System.out.println(key);
			keyList.add(key);
		}
		Collections.sort(keyList);
		mav.addObject("keys", keyList);
		return mav;
	}
	



}