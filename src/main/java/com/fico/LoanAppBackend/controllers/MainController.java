package com.fico.LoanAppBackend.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fico.LoanAppBackend.model.ApplicationDetails;
import com.fico.LoanAppBackend.model.repositories.ApplicationDetailsRepository;

@RestController
public class MainController {
	ApplicationDetailsRepository applicationDetailsRepository;
	
	
	
	public MainController(ApplicationDetailsRepository applicationDetailsRepository) {
		super();
		this.applicationDetailsRepository = applicationDetailsRepository;
	}



	@PostMapping("/application")
	public String submitApplication(@RequestParam String firstName,@RequestParam(required=false) String middleName,@RequestParam String lastName,@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfBirth,
			@RequestParam String maritalStatus,@RequestParam  String addressLine1,@RequestParam(required=false)  String addressLine2,@RequestParam  String city,@RequestParam  String state,
			@RequestParam String postalCode,@RequestParam  String sSN, @RequestParam String homeNo,@RequestParam(required=false)  String officeNo,@RequestParam String mobileNo,@RequestParam  String email,@RequestParam  Double amount,
			@RequestParam String purpose,@RequestParam(required=false)  String description,@RequestParam  String workExp,@RequestParam  Double annualSalary,@RequestParam  String currentEmployerName,
			@RequestParam String empAddressLine1,@RequestParam(required=false)  String empAddressLine2,@RequestParam  String empCity,@RequestParam  String empState, @RequestParam String empPostalCode,
			@RequestParam(required=false) String designation) {
		
		System.out.println(dateOfBirth.toString());

		ApplicationDetails appDetails = new ApplicationDetails(firstName,  middleName,  lastName,  dateOfBirth,
				 maritalStatus,  addressLine1,  addressLine2,  city,  state,
				 postalCode,  sSN,  homeNo,  officeNo,  mobileNo,  email,  amount,
				 purpose,  description,  workExp,  annualSalary,  currentEmployerName,
				 empAddressLine1,  empAddressLine2,  empCity,  empState,  empPostalCode,
				 designation);
		
		applicationDetailsRepository.save(appDetails);
		
		return "Successfully processed!"+appDetails.toString();
		
	}
}
