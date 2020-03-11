package com.barrouh.agecalculatorapi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AgeCalculator {

	private Date birthdate;

	private Date ageAtTheDateOf;

	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss", Locale.ENGLISH);

	private static final Logger LOGGER = LogManager.getLogger(AgeCalculator.class);

	public AgeCalculator() {
	}

	public AgeCalculator(Date birthdate, Date ageAtTheDateOf) {
		this.birthdate = formatDate(formatDate(birthdate));
		this.ageAtTheDateOf = formatDate(formatDate(ageAtTheDateOf));
	}

	public AgeCalculator(String birthdate, String ageAtTheDateOf) {
		this.birthdate = formatDate(checkStringDate(birthdate));
		this.ageAtTheDateOf = formatDate(checkStringDate(ageAtTheDateOf));
	}

	private Long getDateDifference() {
		return this.ageAtTheDateOf.getTime() - this.birthdate.getTime();
	}

	private String getFinalDateAs(Long finalTime, DateTypes dateAs) {
		Long result = null;
		switch (dateAs.toString()) {
		case "seconds":
			result = finalTime / TimeFormula.SECONDS.getValue();
			break;
		case "minutes":
			result = finalTime / TimeFormula.MINUTES.getValue();
			break;
		case "hours":
			result = finalTime / TimeFormula.HOURS.getValue();
			break;
		case "days":
			result = finalTime / TimeFormula.DAYS.getValue();
			break;
		case "weeks":
			result = finalTime / TimeFormula.WEEKS.getValue();
			break;
		case "months":
			result = finalTime / TimeFormula.MONTHS.getValue();
			break;
		case "years":
			result = finalTime / TimeFormula.YEARS.getValue();
			break;
		default:
			result = finalTime / TimeFormula.YEARS.getValue();
			break;
		}
		return result.toString();
	}

	public String getFinalDateAs(DateTypes dateAs) {
		return getFinalDateAs(getDateDifference(), dateAs);
	}

	public Map<String, String> getFinalDateAsJs(DateTypes dateAs) {
		Map<String, String> finalMap = new TreeMap<>(new MapComparator());
		finalMap.put(dateAs.toString(), getFinalDateAs(getDateDifference(), dateAs));
		return finalMap;
	}

	public Map<String, String> getFinalDateAsAll() {
		Map<String, String> finalMap = new TreeMap<>(new MapComparator());
		Long datesDifference = this.getDateDifference();
		DateTypes[] dateTypes = orderDateTypes(DateTypes.values());
		for (DateTypes dateType : dateTypes) {
			Long timeFormula = TimeFormula.getValueByName(dateType.toString()).getValue();
			Long temp = null;
			temp = datesDifference % timeFormula;
			finalMap.put(dateType.toString(), getFinalDateAs(datesDifference - temp / timeFormula, dateType));
			datesDifference = temp;
		}
		return finalMap;
	}

	private DateTypes[] orderDateTypes(DateTypes[] dateTypes) {
		DateTypes[] finalTable = dateTypes;
		for (int i = 0; i < finalTable.length; i++) {
			for (int j = 0; j < finalTable.length; j++) {
				if (TimeFormula.getValueByName(finalTable[i].toString()).getValue() > TimeFormula
						.getValueByName(finalTable[j].toString()).getValue()) {
					DateTypes temp = finalTable[i];
					finalTable[i] = finalTable[j];
					finalTable[j] = temp;
				}
			}
		}
		return finalTable;
	}

	public boolean isValidDate(String inDate) {
		try {
			if (inDate != null) {
				dateFormat.parse(inDate.trim());
			} else {
				return false;
			}
		} catch (ParseException pe) {
			return false;
		}
		return true;
	}

	public Date formatDate(String date) {
		try {
			return dateFormat.parse(checkStringDate(date));
		} catch (ParseException e) {
			LOGGER.error(e.getMessage(), e);
			return null;
		}
	}

	public String formatDate(Date date) {
		return dateFormat.format(date);
	}

	private String checkStringDate(String date) {
		if (date.length() <= 10)
			return date + "-00-00-00";
		else
			return date;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public Date getAgeAtTheDateOf() {
		return ageAtTheDateOf;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public void setAgeAtTheDateOf(Date ageAtTheDateOf) {
		this.ageAtTheDateOf = ageAtTheDateOf;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = formatDate(checkStringDate(birthdate));
	}

	public void setAgeAtTheDateOf(String ageAtTheDateOf) {
		this.ageAtTheDateOf = formatDate(checkStringDate(ageAtTheDateOf));
	}

}

class MapComparator implements Comparator<String> {
	public int compare(String a, String b) {
		return 1;
	}
}