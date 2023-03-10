package com.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springdemo.entity.Customer;
import com.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

//	// inject the customer DAO
//	@Autowired
//	private CustomerDAO customerDAO;
	
	// inject the customer service
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// code refactored to get the customers from the service layer*
//		// get the customers from the DAO
//		List<Customer> theCustomers = customerDAO.getCustomers();
		
		// get the customers from the Service
		List<Customer> theCustomers = customerService.getCustomers();
		
		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		
		return "list-customers";
	}
	
	@GetMapping("showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind the data
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer); 
		
		
		return "customer-form";
	}
	
	
	
}

