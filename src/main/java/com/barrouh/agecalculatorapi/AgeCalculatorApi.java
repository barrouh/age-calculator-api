package com.barrouh.agecalculatorapi;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AgeCalculatorApi {
	
	private Date birthdate;
	
	private Date ageAtTheDateOf;
	
	private SimpleDateFormat dateFormat;

	public AgeCalculatorApi() {
		super();
		dateFormat= new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss",Locale.ENGLISH);
	}
	
	public AgeCalculatorApi(Date birthdate, Date ageAtTheDateOf) {
		super();
		this.birthdate = birthdate;
		this.ageAtTheDateOf = ageAtTheDateOf;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Date getAgeAtTheDateOf() {
		return ageAtTheDateOf;
	}

	public void setAgeAtTheDateOf(Date ageAtTheDateOf) {
		this.ageAtTheDateOf = ageAtTheDateOf;
	}
	
	private Long getDateDifference(Date birthdate, Date ageAtTheDateOf) {
		return ageAtTheDateOf.getTime()-birthdate.getTime();
	}
	
	private String getFinalDateAs(Long finalTime, String dateAs) {
		String result="";
		switch(dateAs) {
		case "seconds":  ; break;
		case "minutes":  ; break;
		case "hours"  :  ; break;
		case "days"   :  ; break;
		case "weeks"  :  ; break;
		case "months" :  ; break;
		case "years"  :  ; break;
	    default       : ;break;
		}
		
		return result;
	}
	
}
