package com.sep.orderservice.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value="PAYMENTSERVICE")
public interface Service {
	@GetMapping("/payments")
	String pay();
	
	

}
