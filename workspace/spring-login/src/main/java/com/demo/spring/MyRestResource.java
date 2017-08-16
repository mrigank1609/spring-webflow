package com.demo.spring;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.dao.User;

@RestController
public class MyRestResource {

	@RequestMapping(path = "/greet", method = RequestMethod.GET)
	public @ResponseBody String greet(@RequestParam("name") String name) {
		return "Welcome to Spring REST," + name;
	}

	@RequestMapping(path = "/add/{a}/{b}", method = RequestMethod.GET)
	public @ResponseBody String add(@PathVariable("a") int a, @PathVariable("b") int b) {
		return "" + (a + b);
	}

	@RequestMapping(path = "/user", method = RequestMethod.GET, produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public User getUser() {
		User u = new User();
		u.setUserName("Joker");
		u.setPassword("cloudbird");
		return u;
	}
}
