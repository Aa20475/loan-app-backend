package com.fico.LoanAppBackend.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonFormat;


// TODO: The class is too big. Can we segment it more?

@Entity
public class ApplicationDetails implements Serializable{
	
	
	
	public ApplicationDetails() {
		super();
	}


	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
	@Type(type="uuid-char")
	private UUID id;
	
	private long regId;
	
	// Name
	private String firstName;
	private String middleName;
	private String lastName;
	
	//DoB
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dateOfBirth;
	
	//marital status
	private String maritalStatus;
	
	//Applicant Address
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String postalCode;
	
	//SSN Number
	private String ssn;
	
	//Applicant Phone Number
	private String homeNo;
	private String officeNo;
	private String mobileNo;
	
	//Applicant Email
	private String email;
	
	//Loan Amount
	private Double amount;
	
	//Loan purpose
	private String purpose;
	
	//Description
	private String description;
	
	//Employment Details
	private String workExp;
	private Double annualSalary;
	private String currentEmployerName;
	//Employer Address
	private String empAddressLine1;
	private String empAddressLine2;
	private String empCity;
	private String empState;
	private String empPostalCode;
	private String designation;
	
	private String status;
	private String credScore;
	private String reason;
	private String date;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String getCredScore() {
		return credScore;
	}

	public void setCredScore(String credScore) {
		this.credScore = credScore;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public ApplicationDetails(String firstName, String middleName, String lastName, LocalDate dateOfBirth,
			String maritalStatus, String addressLine1, String addressLine2, String city, String state,
			String postalCode, String sSN, String homeNo, String officeNo, String mobileNo, String email, Double amount,
			String purpose, String description, String workExp, Double annualSalary, String currentEmployerName,
			String empAddressLine1, String empAddressLine2, String empCity, String empState, String empPostalCode,
			String designation) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.maritalStatus = maritalStatus;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.ssn = sSN;
		this.homeNo = homeNo;
		this.officeNo = officeNo;
		this.mobileNo = mobileNo;
		this.email = email;
		this.amount = amount;
		this.purpose = purpose;
		this.description = description;
		this.workExp = workExp;
		this.annualSalary = annualSalary;
		this.currentEmployerName = currentEmployerName;
		this.empAddressLine1 = empAddressLine1;
		this.empAddressLine2 = empAddressLine2;
		this.empCity = empCity;
		this.empState = empState;
		this.empPostalCode = empPostalCode;
		this.designation = designation;
		this.status = "In Progress";
		this.credScore = "In Progress";
		this.reason = "In Progress";
	}
	
	@Override
	public String toString() {
		return "ApplicationDetails [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + ", maritalStatus=" + maritalStatus
				+ ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city + ", state="
				+ state + ", postalCode=" + postalCode + ", SSN=" + ssn + ", homeNo=" + homeNo + ", officeNo="
				+ officeNo + ", mobileNo=" + mobileNo + ", email=" + email + ", amount=" + amount + ", purpose="
				+ purpose + ", description=" + description + ", workExp=" + workExp + ", annualSalary=" + annualSalary
				+ ", currentEmployerName=" + currentEmployerName + ", empAddressLine1=" + empAddressLine1
				+ ", empAddressLine2=" + empAddressLine2 + ", empCity=" + empCity + ", empState=" + empState
				+ ", empPostalCode=" + empPostalCode + ", designation=" + designation + "]";
	}
	public UUID getId() {
		return id;
	}
	public long getRegId() {
		return regId;
	}
	public void setRegId(long regId) {
		this.regId = regId<0?-regId:regId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getSSN() {
		return ssn;
	}
	public void setSSN(String sSN) {
		ssn = sSN;
	}
	public String getHomeNo() {
		return homeNo;
	}
	public void setHomeNo(String homeNo) {
		this.homeNo = homeNo;
	}
	public String getOfficeNo() {
		return officeNo;
	}
	public void setOfficeNo(String officeNo) {
		this.officeNo = officeNo;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getWorkExp() {
		return workExp;
	}
	public void setWorkExp(String workExp) {
		this.workExp = workExp;
	}
	public Double getAnnualSalary() {
		return annualSalary;
	}
	public void setAnnualSalary(Double annualSalary) {
		this.annualSalary = annualSalary;
	}
	public String getCurrentEmployerName() {
		return currentEmployerName;
	}
	public void setCurrentEmployerName(String currentEmployerName) {
		this.currentEmployerName = currentEmployerName;
	}
	public String getEmpAddressLine1() {
		return empAddressLine1;
	}
	public void setEmpAddressLine1(String empAddressLine1) {
		this.empAddressLine1 = empAddressLine1;
	}
	public String getEmpAddressLine2() {
		return empAddressLine2;
	}
	public void setEmpAddressLine2(String empAddressLine2) {
		this.empAddressLine2 = empAddressLine2;
	}
	public String getEmpCity() {
		return empCity;
	}
	public void setEmpCity(String empCity) {
		this.empCity = empCity;
	}
	public String getEmpState() {
		return empState;
	}
	public void setEmpState(String empState) {
		this.empState = empState;
	}
	public String getEmpPostalCode() {
		return empPostalCode;
	}
	public void setEmpPostalCode(String empPostalCode) {
		this.empPostalCode = empPostalCode;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApplicationDetails other = (ApplicationDetails) obj;
		return Objects.equals(id, other.id);
	}
	
	
	@Override
	public int hashCode() {
		return this.id.hashCode();
		
	}
}
