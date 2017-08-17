package com.demo.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

	@RequestMapping(path = "/test.do")
	public String getPage() {
		return "/WEB-INF/pages/demo.jsp";
	}
}
