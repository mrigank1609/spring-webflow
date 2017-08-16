package com.demo.spring;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestResource {

	@RequestMapping(path = "/greet/{name}", method = RequestMethod.GET)
	public String greet(@PathVariable("name") String name) {
		return "Spring RESTFul Service, You are " + name;
	}

	@RequestMapping(path = "/emp", method = RequestMethod.GET, produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public Emp getEmp() {
		Emp e = new Emp(100, "Scott", "London", 45000);
		return e;
	}

}
