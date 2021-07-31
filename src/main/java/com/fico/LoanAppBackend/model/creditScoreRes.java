package com.fico.LoanAppBackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class creditScoreRes {
	 @JsonProperty("CRED_APPROVAL_STATUS")
	private String CRED_APPROVAL_STATUS;
	 @JsonProperty("CRED_SCORE")
	private String CRED_SCORE;
	 @JsonProperty("resOrig")
	private String resOrig;

	
	public creditScoreRes(String cRED_APPROVAL_STATUS, String cRED_SCORE, String resOrig) {
		super();
		CRED_APPROVAL_STATUS = cRED_APPROVAL_STATUS;
		CRED_SCORE = cRED_SCORE;
		this.resOrig = resOrig;
	}
	public creditScoreRes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCRED_APPROVAL_STATUS() {
		return CRED_APPROVAL_STATUS;
	}
	public void setCRED_APPROVAL_STATUS(String cRED_APPROVAL_STATUS) {
		CRED_APPROVAL_STATUS = cRED_APPROVAL_STATUS;
	}
	public String getCRED_SCORE() {
		return CRED_SCORE;
	}
	public void setCRED_SCORE(String cRED_SCORE) {
		CRED_SCORE = cRED_SCORE;
	}
	public String getResOrig() {
		return resOrig;
	}
	public void setResOrig(String resOrig) {
		this.resOrig = resOrig;
	}
	@Override
	public String toString() {
		return "creditScoreRes [CRED_APPROVAL_STATUS=" + CRED_APPROVAL_STATUS + ", CRED_SCORE=" + CRED_SCORE
				+ ", resOrig=" + resOrig + "]";
	}
	
}
