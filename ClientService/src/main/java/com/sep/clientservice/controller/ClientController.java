package com.sep.clientservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ClientController {
	@GetMapping
	public String example() {
		return "<h1>WELCOME TO PRODUCT SERVICE</H1>";
	}

}
