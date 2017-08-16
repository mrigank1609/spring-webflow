package com.demo.spring;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ValidatedLoginController {

	@RequestMapping(path = "/login2.do", method = RequestMethod.GET)
	public String getLoginPage(Model model) {
		User user = new User();
		model.addAttribute("userModel", user);
		return "login3";
	}

	@RequestMapping(path = "/login2.do", method = RequestMethod.POST)
	public ModelAndView processLogin(@Valid @ModelAttribute("userModel") User user, BindingResult result) {
		ModelAndView mv = null;
		if (result.hasErrors()) {
			mv = new ModelAndView("login3");
		} else {
			if (user.getUsername().equals(user.getPassword())) {
				mv = new ModelAndView("success");
				
			} else {
				mv = new ModelAndView("failure");
				
			}
		}
		return mv;
	}

}
