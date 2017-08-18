package com.demo.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping(path="/demo.do")
	public String greet() {
		return "/WEB-INF/jsp/demo.jsp";
	}
}
