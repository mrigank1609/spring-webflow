package com.demo.spring;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.spring.dao.Dao;
import com.demo.spring.dao.User;

@Controller
public class LoginController {
	@Autowired
	Dao dao;

	@RequestMapping(path = "login.do", method = RequestMethod.GET)
	public String getPage(Model model) {
		model.addAttribute("user", new User());
		return "login2";
	}

	@RequestMapping(path = "login.do", method = RequestMethod.POST)
	public ModelAndView processForm(@Valid @ModelAttribute("user") User user, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		if (result.hasErrors()) {
			mv.setViewName("login2");
			return mv;
		} else {

			User dbuser = dao.getUserById(user.getUserName());
			if (dbuser != null) {
				if (user.getPassword().equals(dbuser.getPassword())) {
					mv.setViewName("ok");
					mv.addObject("user", user.getUserName());
					return mv;
				} else {
					mv.setViewName("fail");
					return mv;
				}
			} else {
				mv.setViewName("fail");
				return mv;
			}
		}
	}
}
