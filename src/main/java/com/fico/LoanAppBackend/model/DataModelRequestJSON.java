package com.fico.LoanAppBackend.model;

public class DataModelRequestJSON {
	private String ssn;
	private Double amount;
	private String workExp;
	private Double annualSalary;
	private String purpose;
	
	public DataModelRequestJSON(String ssn, Double amount, String workExp, Double annualSalary, String purpose) {
		super();
		this.ssn = ssn;
		this.amount = amount;
		this.workExp = workExp;
		this.annualSalary = annualSalary;
		this.purpose = purpose;
	}
	public DataModelRequestJSON() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
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
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	
	@Override
	public String toString() {
		return "DataModelRequestJSON [ssn=" + ssn + ", amount=" + amount + ", workExp=" + workExp + ", annualSalary="
				+ annualSalary + ", purpose=" + purpose + "]";
	}
	
	
	
	
}
