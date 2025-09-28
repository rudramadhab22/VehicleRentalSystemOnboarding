package com.vrs.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
	
    @NotBlank
    @NotNull
    @NotNull
    @Size(min = 3,message = "name should be more than 4 characters")
	private String name ;//(not null, min 3 characters)
    @Email(message = "not a valid mail")
	private String email;// (unique, valid email format)
    @NotBlank
    @NotNull
    @NotEmpty
    @Size(max = 10,min = 10,message = "not a valid number")
	private String phoneNumber ;  //(10 digits only)
    @NotBlank
    @NotNull
    @NotEmpty
	private String drivingLicenseNumber ;//(unique, not null)

}
