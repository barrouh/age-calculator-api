package com.barrouh.agecalculatorapi;

import com.google.gson.Gson;

public class Main {

	public static void main(String[] args) {

	System.out.println(new Gson().toJson(new AgeCalculator().getFinalDateAsAll("20-10-2018","27-10-2018")).toString());
	
	}

}
