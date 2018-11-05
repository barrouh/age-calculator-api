package com.barrouh.agecalculatorapi;

public enum DateTypes {
	
	SECONDS("seconds"),
	MINUTES("minutes"),
	HOURS("hours"),
	DAYS("days"),
	WEEKS("weeks"),
	MONTHS("months"),
	YEARS("years");

    private final String value;

    DateTypes(final String value) {
        this.value = value;
    }
    
	public static DateTypes getValueByName(String name) {
        return DateTypes.valueOf(name.toUpperCase());
    }
   
    @Override
    public String toString() {
        return value;
    }

}
