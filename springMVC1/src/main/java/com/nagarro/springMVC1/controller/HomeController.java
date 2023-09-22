package com.nagarro.springMVC1.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.springMVC1.model.Tshirt;
import com.nagarro.springMVC1.util.tshirts.ResourceReader;
import com.nagarro.springMVC1.util.tshirts.TshirtService;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public ModelAndView login(ModelAndView model) {
		return new ModelAndView("login");
	}
	@PostMapping(value = "/home")
	public ModelAndView home(ModelAndView model) {
		return new ModelAndView("home");
	}
	
	@PostMapping(value = "/search")
	public ModelAndView search(HttpServletRequest req, HttpServletResponse resp){
		
		System.out.println("----------[HomeController]---------");
		
		ModelAndView mv = new ModelAndView();
		
		String colour = req.getParameter("colour");
		String size = req.getParameter("size");
		String gender = req.getParameter("gender");
		String[] pref = req.getParameterValues("preference");
		
		System.out.println(colour + "\t " +size + "\t " +gender + "\t " +pref.length + "\t ");
		
		ResourceReader.readFiles();
		
		ArrayList<Tshirt> tshirts = TshirtService.findTshirts(colour, size, gender, pref.length == 1 ? pref[0].toLowerCase(): "b");
		HttpSession session = req.getSession();
		session.setAttribute("tshirts", tshirts);
		mv.setViewName("result");
		
		return mv;
	}

}
