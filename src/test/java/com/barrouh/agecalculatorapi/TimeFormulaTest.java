package com.barrouh.agecalculatorapi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TimeFormulaTest {

	 @Test
	   public void testDefaultValues() { 
		  assertEquals(TimeFormula.SECONDS.toString(),"1000.0");
	      assertEquals(TimeFormula.MINUTES.toString(),"60000.0");
	      assertEquals(TimeFormula.HOURS.toString(),"3600000.0");
	      assertEquals(TimeFormula.DAYS.toString(),"8.64E7");
	      assertEquals(TimeFormula.WEEKS.toString(),"6.048E8");
	      assertEquals(TimeFormula.MONTHS.toString(),"2.627856E9");
	      assertEquals(TimeFormula.YEARS.toString(),"3.1534272E10");
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
