package com.barrouh.agecalculatorapi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DefaultControllerTest {
	
	private DefaultController controller = new DefaultController();
	
	@Test
	public void home() {
		assertEquals("", controller.home());
	}
	
	@Test
	public void getAgeGet() {
		assertEquals("\"604800\"", controller.getAgeGet("20-10-2018","27-10-2018","seconds"));
	}
	
	@Test
	public void getAgePost() {
		assertEquals("\"604800\"", controller.getAgePost("20-10-2018","27-10-2018","seconds"));
	}
	
	@Test
	public void getAgeGetAll() {
		assertEquals("{\"years\":\"0\",\"months\":\"0\",\"weeks\":\"1\",\"days\":\"0\",\"hours\":\"0\",\"minutes\":\"0\",\"seconds\":\"0\"}", controller.getAgeGet("20-10-2018","27-10-2018","all"));
	}
	
	@Test
	public void getAgePostAll() {
		assertEquals("{\"years\":\"0\",\"months\":\"0\",\"weeks\":\"1\",\"days\":\"0\",\"hours\":\"0\",\"minutes\":\"0\",\"seconds\":\"0\"}", controller.getAgePost("20-10-2018","27-10-2018","all"));
	}
	

}
