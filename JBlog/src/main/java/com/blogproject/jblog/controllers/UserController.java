package com.blogproject.jblog.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.blogproject.jblog.services.UserService;
import com.blogproject.jblog.vo.UserVO;

@RequestMapping("/users")
@Controller
public class UserController {
	
	@Autowired
	UserService userServiceImple;
	
	@RequestMapping(value= {"", "/", "/join"}, method = RequestMethod.GET)
	public String join() {
		return "users/joinform";
	}
	
	
	
	@RequestMapping(value="/join", method = RequestMethod.POST)
	public String joinAction(@ModelAttribute UserVO userVO) {
		
		boolean success = userServiceImple.join(userVO);
		if(success) {
			
			UserVO vo = userServiceImple.getUser(userVO.getId());
			userServiceImple.makeBlog(vo);
			userServiceImple.makeCategory(vo);
			return "redirect:/users/joinsuccess/";
		}else {
			
			return "redirect:/users/";
		}
	}
	
	@RequestMapping("/joinsuccess")
	public String joinSuccess() {
		
		return "users/joinsuccess";
	}
	
	@ResponseBody
	@RequestMapping("/idcheck")
	public Object existID(
			@RequestParam(value = "id", required=false, defaultValue="") String id){
		UserVO vo =userServiceImple.getUser(id);
		boolean exists = vo != null? true:false;
		
		Map<String, Object> map = new HashMap<>();
		map.put("result", "success");
		map.put("data", exists);
		
		return map;
	}
	

	
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String loginform() {
		
		return "users/loginform";
	}
	
	
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String loginAction(@RequestParam String id, @RequestParam String password, HttpSession session,Model model) {
		
		UserVO authUser = userServiceImple.getUser(id, password);
		if(authUser != null) {
			session.setAttribute("authUser", authUser);
			return "redirect:/";
		}
		else {
			model.addAttribute("message", "로그인 실패");
			model.addAttribute("message2", "아이디/패스워드를 확인해 주세요");
			return "/users/loginform";
		}
	}
	
	@RequestMapping("/logout")
	public String logoutAction(HttpSession session) {
		session.removeAttribute("authUser");
		session.invalidate();
		return "redirect:/";
	}
	
}
