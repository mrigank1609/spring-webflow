package com.demo.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

	@RequestMapping(path = "/demo.do", method = RequestMethod.GET)
	public String test() {
		return "home";
	}
}
