package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestApiController {
	
	@GetMapping("/get/{id}")
	public void get(@PathVariable Long id, @RequestParam String name) {
		System.out.println("TEST");
	}
	
	@PostMapping("/post")
	public void post() {
		System.out.println("post");
	}

}
