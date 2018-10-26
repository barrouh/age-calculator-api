package com.barrouh.agecalculatorapi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Main {

	public static void main(String[] args) {
		
		SimpleDateFormat dateFormat= new SimpleDateFormat("dd-MM-yyyy",Locale.ENGLISH);
		try {
			System.out.println( new AgeCalculator().getFinalResults( dateFormat.parse("22-09-1989"), dateFormat.parse("10-26-2018"), "years"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	
	}

}
