package com.barrouh.agecalculatorapi;

public enum Constants {
	
	SECONDS("seconds"),
	MINUTES("minutes"),
	HOURS("hours"),
	DAYS("days"),
	WEEKS("weeks"),
	MONTHS("months"),
	YEARS("years");

    private final String value;

    Constants(final String value) {
        this.value = value;
    }
   
    @Override
    public String toString() {
        return value;
    }

}
