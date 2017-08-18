package com.demo.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public ModelAndView getPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		mv.addObject("orgName", "Training Room");
		return mv;
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ModelAndView processLogin(@RequestParam("username") String username,
			@RequestParam("password") String password) {

		if (username.equals(password)) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("success");
			mv.addObject("user", username);
			return mv;
		} else {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("failure");
			return mv;
		}
	}

}
