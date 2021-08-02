package com.fico.LoanAppBackend.controllers;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fico.LoanAppBackend.model.ApplicationDetails;
import com.fico.LoanAppBackend.model.DataModelRequestJSON;
import com.fico.LoanAppBackend.model.creditScoreRes;
import com.fico.LoanAppBackend.model.repositories.ApplicationDetailsRepository;

@CrossOrigin
@RestController
public class MainController {
	ApplicationDetailsRepository applicationDetailsRepository;
	
	@Autowired 
	RestTemplate restTemplate;

	public MainController(ApplicationDetailsRepository applicationDetailsRepository) {
		super();
		this.applicationDetailsRepository = applicationDetailsRepository;
	}

	@PostMapping(path = "/application" , produces = "application/vnd.com.fico.dmp.v1_0+json")
	public HttpStatus submitApplication(@RequestBody ApplicationDetails appD) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		appD.setDate(formatter.format(date).toString());
		String[] stringarray = appD.getWorkExp().split("_");
		appD.setWorkExp(stringarray[0]);
		
		
		HttpHeaders header=new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		ObjectMapper mapper= new ObjectMapper();
		String jsonRequest=null;
		String result="";
		creditScoreRes respD=null;

		System.out.println("Got a new Application!");

		Period period = Period.between(appD.getDateOfBirth(), LocalDate.now());
		
		if(Integer.parseInt(stringarray[1])<6 && stringarray[0]=="0" ) {
			appD.setStatus("REJECTED");
			appD.setCredScore("0");
			appD.setReason("Insufficient Work Experience");

			appD = applicationDetailsRepository.saveAndFlush(appD);
			
			appD.setRegId(appD.getId().hashCode());
			
			applicationDetailsRepository.saveAndFlush(appD);
			return HttpStatus.OK; 
		}else if(period.getYears()<18 || period.getYears()>65) {
			appD.setStatus("REJECTED");
			appD.setCredScore("0");
			appD.setReason("Age is not between 18 and 65. Ineligible");

			appD = applicationDetailsRepository.saveAndFlush(appD);
			
			appD.setRegId(appD.getId().hashCode());
			
			applicationDetailsRepository.saveAndFlush(appD);
			return HttpStatus.OK; 
		}else if( appD.getAnnualSalary()<10000) {
			appD.setStatus("REJECTED");
			appD.setCredScore("0");
			appD.setReason("Insufficient Annual Salary");

			appD = applicationDetailsRepository.saveAndFlush(appD);
			
			appD.setRegId(appD.getId().hashCode());
			
			applicationDetailsRepository.saveAndFlush(appD);
			return HttpStatus.OK; 
		}
		
		DataModelRequestJSON DMR=new DataModelRequestJSON(appD.getSSN(),appD.getAmount(),appD.getWorkExp(),appD.getAnnualSalary(),appD.getPurpose());
		try {
			
			jsonRequest=mapper.writeValueAsString(DMR);
			HttpEntity<String> entity=new HttpEntity<String>(jsonRequest,header);
			result=restTemplate.postForObject("http://localhost:8200/predict", entity, String.class);
			respD=mapper.readValue(result,creditScoreRes.class);
			System.out.println(result);
			appD.setStatus(respD.getCRED_APPROVAL_STATUS());
			appD.setCredScore(respD.getCRED_SCORE().toString());
			appD.setReason(respD.getResOrig());
	
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(result);
			appD.setStatus("In Progress");
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		appD = applicationDetailsRepository.saveAndFlush(appD);
		
		appD.setRegId(appD.getId().hashCode());
		
		applicationDetailsRepository.saveAndFlush(appD);
		
		return HttpStatus.OK;
	}

	@GetMapping(path="/application/all" consumes = "application/vnd.com.fico.dmp.v1_0+json")
	public Iterable<ApplicationDetails> getApplications() {
		System.out.println("Got a request");
		return applicationDetailsRepository.findAll();
	}

	@GetMapping("/application/id/{id}")
	public ApplicationDetails getApplicationByID(@PathVariable String id) {
		System.out.println("Got request for "+id);
		ApplicationDetails appD = new ApplicationDetails();
		try {
			appD = applicationDetailsRepository.findById(UUID.fromString(id)).get();
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		return appD;
	}

	@GetMapping(path="/application/ssn/{ssn}" consumes = "application/vnd.com.fico.dmp.v1_0+json")
	public List<ApplicationDetails> getApplicationBySSN(@PathVariable String ssn) {
		List<ApplicationDetails> appD;
		appD = applicationDetailsRepository.findBySsn(ssn);
		return appD;
	}
}
