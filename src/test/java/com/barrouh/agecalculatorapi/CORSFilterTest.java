package com.barrouh.agecalculatorapi;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class CORSFilterTest {

	private CORSFilter filter = new CORSFilter();

	@Test
	public void doFilter() throws IOException, ServletException {
		HttpServletResponse response = new MockHttpServletResponse();
		ServletRequest request = new MockHttpServletRequest();
		FilterChain chain = new MockFilterChain();
		filter.doFilter(request, response, chain);
		assertEquals("localhost", response.getHeader("Access-Control-Allow-Origin"));
	}
}