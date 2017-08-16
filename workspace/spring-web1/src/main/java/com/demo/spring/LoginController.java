package com.demo.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping(path = "/login.do", method = RequestMethod.GET)
	public String getLoginPage() {
		return "login2";
	}

	/*
	 * @RequestMapping(path = "/login.do", method = RequestMethod.POST) public
	 * String processLogin(@RequestParam("username") String
	 * username, @RequestParam("password") String password) {
	 * 
	 * if (username.equals(password)) { return "success"; } else { return
	 * "failure"; }
	 * 
	 * }
	 */

	@RequestMapping(path = "/login.do", method = RequestMethod.POST)
	public String processLogin(User user) {

		if (user.getUsername().equals(user.getPassword())) {
			return "success";
		} else {
			return "failure";
		}

	}
}
