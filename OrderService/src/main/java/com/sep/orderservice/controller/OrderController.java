package com.sep.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	Service service;
	
	@GetMapping
	public String hello() {
		return "<h1>WELCOME TO ORDER SERVICE</h1>";
		
	}
	@GetMapping("/pe")
	public String paynow() {
		return service.pay();
	}

}
