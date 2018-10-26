package com.barrouh.agecalculatorapi;

public enum TimeFormula {

	WEEKS(7),
	MONTHS(30.417),
	YEARS(365);

    private final Double value;

    TimeFormula(final double value) {
        this.value = value;
    }
    
    public long getValue() {
        return Math.round(value);
    }
   
    @Override
    public String toString() {
        return value.toString();
    }
}
