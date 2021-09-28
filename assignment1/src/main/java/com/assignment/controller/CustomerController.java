package com.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.entity.CustomerEntity;
import com.assignment.repo.CustomerRepo;


@RestController
public class CustomerController {
	
	@Autowired
	private CustomerRepo customer;
	
	
	
//	@RequestMapping("/customer")
//	public List<CustomerEntity> showall() {
//		
//		return customer.findAll() ;
//	}
	
	@RequestMapping("/add")
	public void add() {
		CustomerEntity c = new CustomerEntity();
		c.setId(1);
		c.setName("abhi");
		c.setMobile(1111111);
		
		customer.save(c);
		
	}
	
	

}
