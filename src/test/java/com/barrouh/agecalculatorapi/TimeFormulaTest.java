package com.barrouh.agecalculatorapi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TimeFormulaTest {

	 @Test
	   public void testDefaultValues() { 
		  assertEquals("1000.0",TimeFormula.SECONDS.toString());
	      assertEquals("60000.0",TimeFormula.MINUTES.toString());
	      assertEquals("3600000.0",TimeFormula.HOURS.toString());
	      assertEquals("8.64E7",TimeFormula.DAYS.toString());
	      assertEquals("6.048E8",TimeFormula.WEEKS.toString());
	      assertEquals("2.627856E9",TimeFormula.MONTHS.toString());
	      assertEquals("3.1534272E10",TimeFormula.YEARS.toString());
	 }
	 
	 @Test
	   public void testgetValueByName() {
	      assertEquals(TimeFormula.SECONDS.toString(),TimeFormula.getValueByName("SECONDS").toString());
	      assertEquals(TimeFormula.MINUTES.toString(),TimeFormula.getValueByName("MINUTES").toString());
	      assertEquals(TimeFormula.HOURS.toString(),TimeFormula.getValueByName("HOURS").toString());
	      assertEquals(TimeFormula.DAYS.toString(),TimeFormula.getValueByName("DAYS").toString());
	      assertEquals(TimeFormula.WEEKS.toString(),TimeFormula.getValueByName("WEEKS").toString());
	      assertEquals(TimeFormula.MONTHS.toString(),TimeFormula.getValueByName("MONTHS").toString());
	      assertEquals(TimeFormula.YEARS.toString(),TimeFormula.getValueByName("YEARS").toString());
	   }
}
