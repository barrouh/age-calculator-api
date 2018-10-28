package com.barrouh.agecalculatorapi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class AgeCalculator {
	
	private Date birthdate;
	
	private Date ageAtTheDateOf;
	
	private SimpleDateFormat dateFormat = 
		new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss",Locale.ENGLISH);

	public AgeCalculator() {
		super();
	}
	
	public AgeCalculator(Date birthdate, Date ageAtTheDateOf) {
		super();
		this.birthdate = formatDate(formatDate(birthdate));
		this.ageAtTheDateOf = formatDate(formatDate(ageAtTheDateOf));
	}
	
	public AgeCalculator(Date birthdate) {
		super();
		this.birthdate = formatDate(formatDate(birthdate));
	}
	
	public AgeCalculator(String birthdate, String ageAtTheDateOf) {
		super();
		this.birthdate = formatDate(birthdate);
		this.ageAtTheDateOf = formatDate(ageAtTheDateOf);
	}
	
	public AgeCalculator(String birthdate) {
		super();
		this.birthdate = formatDate(birthdate);
	}
	
    private Date formatDate(String date) {
    	try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
    }
    
    private String formatDate(Date date) {
			return dateFormat.format(date);
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
	
	private Long getDateDifference() {
		return this.ageAtTheDateOf.getTime()-this.birthdate.getTime();
	}
	
	private String getFinalDateAs(Long finalTime, DateTypes dateAs) {
	  Long result=null;
	  switch(dateAs.toString()) {
		case "seconds": result=finalTime/TimeFormula.SECONDS.getValue(); break;
		case "minutes": result=finalTime/TimeFormula.MINUTES.getValue(); break;
		case "hours"  : result=finalTime/TimeFormula.HOURS.getValue(); break;
		case "days"   : result=finalTime/TimeFormula.DAYS.getValue(); break;
		case "weeks"  : result=finalTime/TimeFormula.WEEKS.getValue(); break;
		case "months" : result=finalTime/TimeFormula.MONTHS.getValue(); break;
		case "years"  : result=finalTime/TimeFormula.YEARS.getValue(); break;
	    default       : result=finalTime/TimeFormula.YEARS.getValue(); break;
	 }
		return result.toString();
	} 
	
	public String getFinalDateAs(Date birthdate, Date ageAtTheDateOf, DateTypes dateAs) {
		this.birthdate = formatDate(formatDate(birthdate));
		this.ageAtTheDateOf = formatDate(formatDate(ageAtTheDateOf));
		return getFinalDateAs(getDateDifference(),dateAs);
	}
	
	public String getFinalDateAs(String birthdate, String ageAtTheDateOf, DateTypes dateAs) {
		this.birthdate = formatDate(checkStringDate(birthdate));
		this.ageAtTheDateOf = formatDate(checkStringDate(ageAtTheDateOf));
		return getFinalDateAs(getDateDifference(),dateAs);
	}
	
	public Map<String, String> getFinalDateAsAll(String birthdate, String ageAtTheDateOf) {
		this.birthdate = formatDate(checkStringDate(birthdate));
		this.ageAtTheDateOf = formatDate(checkStringDate(ageAtTheDateOf));
		Map<String, String> finalMap = new HashMap<String, String>();
		Long datesDifference=this.getDateDifference();
		DateTypes[] dateTypes = orderDateTypes(DateTypes.values());
		for(DateTypes dateType :  dateTypes) {
			Long timeFormula=TimeFormula.getValueByName(dateType.toString()).getValue();
			Long temp=null;
			temp=datesDifference%timeFormula;
			finalMap.put(dateType.toString(), getFinalDateAs(datesDifference-temp/timeFormula,dateType));
			datesDifference=temp;
		}
		return finalMap;
	}
	
	public String getFinalResults(String birthdate, String ageAtTheDateOf, DateTypes dateAs) {
		this.birthdate = formatDate(checkStringDate(birthdate));
		this.ageAtTheDateOf = formatDate(checkStringDate(ageAtTheDateOf));
		return getFinalDateAs(getDateDifference(),dateAs);
	}
	
	public String getFinalResults(DateTypes dateAs) {
		return getFinalDateAs(getDateDifference(),dateAs);
	}
	
	private String checkStringDate(String date) {
		if(date.length()<=10)
			return date+"-00-00-00";
		else
			return date;
	}
	
	private DateTypes[] orderDateTypes(DateTypes[] dateTypes) {
		DateTypes[] finalTable=dateTypes;
		for (int i = 0; i < finalTable.length; i++) {
		    for (int j = 0; j < finalTable.length; j++) {
		        if (TimeFormula.getValueByName(finalTable[i].toString()).getValue() 
		          >TimeFormula.getValueByName(finalTable[j].toString()).getValue()) {
		        	DateTypes temp = finalTable[i];
		            finalTable[i] = finalTable[j];
		            finalTable[j] = temp;
		        }
		    }
		}
		return finalTable;
	}

}
