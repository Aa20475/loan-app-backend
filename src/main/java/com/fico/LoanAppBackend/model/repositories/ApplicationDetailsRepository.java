package com.fico.LoanAppBackend.model.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fico.LoanAppBackend.model.ApplicationDetails;

public interface ApplicationDetailsRepository extends JpaRepository<ApplicationDetails,UUID>{
	public List<ApplicationDetails> findBySsn(String ssn);
}
