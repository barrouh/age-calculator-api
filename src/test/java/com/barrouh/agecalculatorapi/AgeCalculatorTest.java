package com.barrouh.agecalculatorapi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.google.gson.Gson;

public class AgeCalculatorTest {

	private AgeCalculator ageCalculator = new AgeCalculator();

	private Gson json = new Gson();

	@Test
	public void ageCalculator() {
		String birthdate = "20-10-2018";
		String ageAtTheDateOf = "27-10-2018";
		ageCalculator = new AgeCalculator(birthdate, ageAtTheDateOf);
		ageCalculator = new AgeCalculator(ageCalculator.getBirthdate(), ageCalculator.getAgeAtTheDateOf());
		ageCalculator.setBirthdate(ageCalculator.getBirthdate());
		ageCalculator.setAgeAtTheDateOf(ageCalculator.getAgeAtTheDateOf());
		assertEquals("20-10-2018-12-00-00", ageCalculator.formatDate(ageCalculator.getBirthdate()));
		assertEquals("27-10-2018-12-00-00", ageCalculator.formatDate(ageCalculator.getAgeAtTheDateOf()));
	}

	@Test
	public void isValidDate() {
		assertFalse(ageCalculator.isValidDate("dummy"));
		assertFalse(ageCalculator.isValidDate(null));
		assertTrue(ageCalculator.isValidDate("27-10-2018-12-00-00"));
	}

	@Test
	public void formatDate() {
		assertNull(ageCalculator.formatDate("dummy"));
	}

	@Test
	public void getFinalDateAs() {
		ageCalculator.setBirthdate("20-10-2018");
		ageCalculator.setAgeAtTheDateOf("27-10-2018");
		assertEquals("604800", ageCalculator.getFinalDateAs(DateTypes.SECONDS).toString());
		//assertEquals("604800", ageCalculator.getFinalDateAs(null).toString());
	}

	@Test
	public void getFinalDateAsAll() {
		ageCalculator.setBirthdate("20-10-2018");
		ageCalculator.setAgeAtTheDateOf("27-10-2018");
		assertEquals(
				"{\"years\":\"0\",\"months\":\"0\",\"weeks\":\"1\",\"days\":\"0\",\"hours\":\"0\",\"minutes\":\"0\",\"seconds\":\"0\"}",
				json.toJson(ageCalculator.getFinalDateAsAll()).toString());
	}

	@Test
	public void getFinalDateAsJs() {
		ageCalculator.setBirthdate("20-10-2018");
		ageCalculator.setAgeAtTheDateOf("27-10-2018");
		assertEquals("{\"seconds\":\"604800\"}",
				json.toJson(ageCalculator.getFinalDateAsJs(DateTypes.SECONDS)).toString());
	}

}