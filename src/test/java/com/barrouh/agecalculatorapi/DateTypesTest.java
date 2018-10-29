package com.barrouh.agecalculatorapi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DateTypesTest {

	 @Test
	   public void testDefaultValues() {
	      assertEquals(DateTypes.SECONDS.toString(),"seconds");
	      assertEquals(DateTypes.MINUTES.toString(),"minutes");
	      assertEquals(DateTypes.HOURS.toString(),"hours");
	      assertEquals(DateTypes.DAYS.toString(),"days");
	      assertEquals(DateTypes.WEEKS.toString(),"weeks");
	      assertEquals(DateTypes.MONTHS.toString(),"months");
	      assertEquals(DateTypes.YEARS.toString(),"years");
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
