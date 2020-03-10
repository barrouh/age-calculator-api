package com.barrouh.agecalculatorapi;

public enum TimeFormula {

	SECONDS(1000),
	MINUTES(TimeFormula.SECONDS.getValue()*60f),
	HOURS(TimeFormula.MINUTES.getValue()*60f),
	DAYS(TimeFormula.HOURS.getValue()*24f),
	WEEKS(TimeFormula.DAYS.getValue()*7f),
	MONTHS(TimeFormula.WEEKS.getValue()*4.345f),
	YEARS(TimeFormula.MONTHS.getValue()*12f);

    private final Double value;

    TimeFormula(final double value) {
        this.value = value;
    }
    
    public long getValue() {
        return Math.round(value);
    }
    
    public static TimeFormula getValueByName(String name) {
        return TimeFormula.valueOf(name.toUpperCase());
    }
   
    @Override
    public String toString() {
        return value.toString();
    }
}
