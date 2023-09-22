package com.nagarro.springMVC1.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.springMVC1.util.login.LoginServices;


@Controller 
public class LoginController {
	
	@Autowired
	LoginServices loginService;
	
	@PostMapping("/login")
	public ModelAndView validateUser(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("----------[LoginController]---------");

		ModelAndView mv = new ModelAndView();
		
		String username = req.getParameter("inputUsername");
		String password = req.getParameter("inputPassword");
		

		boolean validUser = loginService.verfiyUser(username,password);
		if(validUser) {
			
			HttpSession session = req.getSession();
			session.setAttribute("username", username);
			mv.setViewName("home");
			
		} else {
			mv.setViewName("login");
		}
	return mv;
	}
	
}
