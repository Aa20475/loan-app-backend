package com.fico.LoanAppBackend.controllers;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
	public HttpStatus submitApplication(@RequestBody ApplicationDetails appD) {
		applicationDetailsRepository.saveAndFlush(appD);

		return HttpStatus.OK;
	}

	@GetMapping("/application/all")
	public Iterable<ApplicationDetails> getApplications() {
		System.out.println("Got a request");
		return applicationDetailsRepository.findAll();
	}

	@GetMapping("/application/id/{id}")
	public ApplicationDetails getApplicationByID(@PathVariable UUID id) {
		ApplicationDetails appD = new ApplicationDetails();
		try {
			appD = applicationDetailsRepository.findById(id).get();
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		return appD;
	}

	@GetMapping("/application/ssn/{ssn}")
	public List<ApplicationDetails> getApplicationBySSN(@PathVariable String ssn) {
		List<ApplicationDetails> appD;
		appD = applicationDetailsRepository.findBySsn(ssn);
		return appD;
	}
}
