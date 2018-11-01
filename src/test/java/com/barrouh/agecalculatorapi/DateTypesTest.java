package com.barrouh.agecalculatorapi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DateTypesTest {

	 @Test
	   public void testDefaultValues() {
	      assertEquals("seconds",DateTypes.SECONDS.toString());
	      assertEquals("minutes",DateTypes.MINUTES.toString());
	      assertEquals("hours",DateTypes.HOURS.toString());
	      assertEquals("days",DateTypes.DAYS.toString());
	      assertEquals("weeks",DateTypes.WEEKS.toString());
	      assertEquals("months",DateTypes.MONTHS.toString());
	      assertEquals("years",DateTypes.YEARS.toString());
	   }
	 
	 @Test
	   public void testgetValueByName() {
	      assertEquals(DateTypes.SECONDS.toString(),DateTypes.getValueByName("SECONDS").toString());
	      assertEquals(DateTypes.MINUTES.toString(),DateTypes.getValueByName("MINUTES").toString());
	      assertEquals(DateTypes.HOURS.toString(),DateTypes.getValueByName("HOURS").toString());
	      assertEquals(DateTypes.DAYS.toString(),DateTypes.getValueByName("DAYS").toString());
	      assertEquals(DateTypes.WEEKS.toString(),DateTypes.getValueByName("WEEKS").toString());
	      assertEquals(DateTypes.MONTHS.toString(),DateTypes.getValueByName("MONTHS").toString());
	      assertEquals(DateTypes.YEARS.toString(),DateTypes.getValueByName("YEARS").toString());
	   }
}
