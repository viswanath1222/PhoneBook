package com.vi.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomepageController {
	
	@GetMapping(path = "/welcome")
	public ModelAndView homepage(ModelAndView mav) {
		String message="WELCOME TO ASHOK IT";
		mav.addObject("message", message);
		mav.setViewName("index");
		return mav;
		
		
	}
	

}
