package com.barrouh.agecalculatorapi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.gson.Gson;

public class AgeCalculatorTest {
	
	private AgeCalculator ageCalculator;
	
	private Gson json;
	
	@Test
	   public void testGetFinalDateAsAll() {
		ageCalculator=new AgeCalculator();
		json = new Gson();
		assertEquals( "{\"years\":\"0\",\"months\":\"0\",\"weeks\":\"1\",\"days\":\"0\",\"hours\":\"0\",\"minutes\":\"0\",\"seconds\":\"0\"}",
				json.toJson(ageCalculator.getFinalDateAsAll("20-10-2018","27-10-2018")).toString());
	}
	
	@Test
	   public void testGetFinalDateAs() {
		ageCalculator=new AgeCalculator();
		json = new Gson();
		assertEquals("{\"seconds\":\"604800\"}",json.toJson(ageCalculator.getFinalDateAs("20-10-2018","27-10-2018",DateTypes.SECONDS)).toString());
	}
}
