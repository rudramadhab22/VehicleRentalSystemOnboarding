package com.vrs.controller;


import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vrs.dto.CustomerDto;
import com.vrs.response.ApiResponse;
import com.vrs.service.CustomerService;

import jakarta.persistence.Id;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/rental")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	@PostMapping("/register")
	public ResponseEntity<ApiResponse<CustomerDto>>registerCustomer(@Valid @RequestBody CustomerDto customerDto){
		
		CustomerDto saved=customerService.registerNewCoustmer(customerDto);
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ApiResponse<>(LocalDateTime.now(),201, "Customer registered successfully", saved));
	}
	@GetMapping("/find/{id}")
public ResponseEntity<ApiResponse<CustomerDto>>findbyCustomerId(@PathVariable Integer id){
		
		CustomerDto fetched=customerService.fetchCustomerById(id);
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ApiResponse<>(LocalDateTime.now(),200, "Customer fetched successfully", fetched));
	}
	@GetMapping("/findwithmail")
	public ResponseEntity<ApiResponse<CustomerDto>>findbymail(@RequestParam String email){
			
			CustomerDto fetched=customerService.fetchCustomerByEmail(email);
			
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ApiResponse<>(LocalDateTime.now(),200, "Customer fetched successfully", fetched));
		}
	

}
