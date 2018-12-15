package com.demo.mybatisspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.ModelMap;

@Controller
@RequestMapping("/hello")
public class HelloController {

	@RequestMapping(method = RequestMethod.GET)
	public String printHello(ModelMap model) {
		model.addAttribute("message", "Hello Spring MVC Framework!");

		Thread t=Thread.currentThread();
		System.out.println(t.getName());
		
		
		return "hello";
	}

	
	
	
	@RequestMapping(value="s",method = RequestMethod.GET)
	@ResponseBody
	public String s(ModelMap model) {
		model.addAttribute("message", "Hello Spring MVC Framework!");

		return "hello s";
	}
	
	
	
	
	
	
}
