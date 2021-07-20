package com.fico.LoanAppBackend.model.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.fico.LoanAppBackend.model.ApplicationDetails;

public interface ApplicationDetailsRepository extends CrudRepository<ApplicationDetails,UUID>{

}
