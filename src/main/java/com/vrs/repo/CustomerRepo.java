package com.vrs.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vrs.entity.Customer;





public interface CustomerRepo extends JpaRepository<Customer,Integer>{
      public Optional<Customer>findByEmail(String email);
      public Optional<Customer>findByDrivingLicenseNumber(String lisense);
      
}
