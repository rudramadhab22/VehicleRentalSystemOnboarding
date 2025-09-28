package com.vrs.service;

import com.vrs.dto.CustomerDto;


public interface CustomerService {
	
	public CustomerDto registerNewCoustmer(CustomerDto customerDto);
	
	public CustomerDto fetchCustomerById(Integer id);
	
	public CustomerDto fetchCustomerByEmail(String email);

}
