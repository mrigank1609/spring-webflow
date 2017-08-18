package com.demo.spring.controllers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.spring.model.User;

@Controller
public class LoginController {
	@PersistenceContext
	EntityManager em;

	@RequestMapping(path = "/login.do", method = RequestMethod.GET)
	public String getLoginPage(Model model) {
		User user = new User();
		model.addAttribute("userModel", user);
		return "login";
	}

	@RequestMapping(path = "/login.do", method = RequestMethod.POST)

	public ModelAndView processLogin(@Valid @ModelAttribute("userModel") User user, BindingResult errors) {

		User userFromDb = em.find(User.class, user.getUserName());
		ModelAndView mv = new ModelAndView();
		if (errors.hasErrors()) {
			mv.setViewName("login");
		} else {
			if (userFromDb != null) {
				if (userFromDb.getPassword().equals(user.getPassword())) {
					mv.setViewName("success");
					mv.addObject("user", user);
				} else {
					mv.setViewName("success");
				}
			} else {
				mv.setViewName("failure");
			}
		}
		return mv;
	}

}
