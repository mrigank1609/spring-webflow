package com.demo.spring;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class SpringRestClient {

	public static void main(String[] args) {
		RestTemplate rt = new RestTemplate();
		UriComponentsBuilder uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/spring-web1/emp");
		ResponseEntity<String> resp = rt.getForEntity(uri.build().toUri(), String.class);
		System.out.println(resp.getBody());
	}

}
