package com.vrs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Integer  id ;//(auto-generated)

	private String name ;//(not null, min 3 characters)
    @Column(unique = true,nullable = true)
	private String email;// (unique, valid email format)
    @Column(unique = true,nullable = true)
	private String phoneNumber ;  //(10 digits only)
	@Column(unique = true,nullable = true)
	private String drivingLicenseNumber ;//(unique, not null)

}
