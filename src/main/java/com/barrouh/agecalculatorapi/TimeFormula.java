package com.barrouh.agecalculatorapi;

public enum TimeFormula {

	SECONDS(1000),
	MINUTES(TimeFormula.SECONDS.getValue()*60),
	HOURS(TimeFormula.MINUTES.getValue()*60),
	DAYS(TimeFormula.HOURS.getValue()*24),
	WEEKS(TimeFormula.DAYS.getValue()*7),
	MONTHS(TimeFormula.WEEKS.getValue()*4.345),
	YEARS(TimeFormula.MONTHS.getValue()*12);

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
