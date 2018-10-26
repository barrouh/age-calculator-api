package com.barrouh.agecalculatorapi;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class AgeCalculator {
	
	private Date birthdate;
	
	private Date ageAtTheDateOf;
	
	private SimpleDateFormat dateFormat;

	public AgeCalculator() {
		super();
		dateFormat= new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss",Locale.ENGLISH);
	}
	
	public AgeCalculator(Date birthdate, Date ageAtTheDateOf) {
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
		Long result=null;
	  switch(dateAs) {
		case "seconds": result=TimeUnit.MILLISECONDS.toSeconds(finalTime); break;
		case "minutes": result=TimeUnit.MILLISECONDS.toMinutes(finalTime); break;
		case "hours"  : result=TimeUnit.MILLISECONDS.toHours(finalTime); break;
		case "days"   : result=TimeUnit.MILLISECONDS.toDays(finalTime); break;
		case "weeks"  : result=TimeUnit.MILLISECONDS.toDays(finalTime)/TimeFormula.WEEKS.getValue(); break;
		case "months" : result=TimeUnit.MILLISECONDS.toDays(finalTime)/TimeFormula.MONTHS.getValue(); break;
		case "years"  : result=TimeUnit.MILLISECONDS.toDays(finalTime)/TimeFormula.YEARS.getValue(); break;
	    default       : result=TimeUnit.MILLISECONDS.toDays(finalTime)/TimeFormula.YEARS.getValue() ;break;
	 }
		return result.toString();
	}
	
	public String getFinalResults(Date birthdate, Date ageAtTheDateOf, String dateAs) {
		return getFinalDateAs(getDateDifference(birthdate,ageAtTheDateOf),dateAs);
	}
	
}
