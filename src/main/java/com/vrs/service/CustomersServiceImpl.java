package com.vrs.service;



import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vrs.dto.CustomerDto;
import com.vrs.entity.Customer;
import com.vrs.repo.CustomerRepo;
@Service
public class CustomersServiceImpl implements CustomerService {
    
    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public CustomerDto registerNewCoustmer(CustomerDto customerDto) {
        
        // Check uniqueness first
        if (customerRepo.findByEmail(customerDto.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        if (customerRepo.findByDrivingLicenseNumber(customerDto.getDrivingLicenseNumber()).isPresent()) {
            throw new RuntimeException("License number already exists");
        }

        // Map DTO -> Entity
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);

        // Save
        Customer savedCustomer = customerRepo.save(customer);

        // Map Entity -> DTO
        CustomerDto response = new CustomerDto();
        BeanUtils.copyProperties(savedCustomer, response);

        return response;
    }

    @Override
    public CustomerDto fetchCustomerById(Integer id) {
        Customer customer = customerRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id " + id));

        CustomerDto response = new CustomerDto();
        BeanUtils.copyProperties(customer, response);

        return response;
    }

    @Override
    public CustomerDto fetchCustomerByEmail(String email) {
        Customer customer = customerRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Customer not found with email " + email));

        CustomerDto response = new CustomerDto();
        BeanUtils.copyProperties(customer, response);

        return response;
    }
}
