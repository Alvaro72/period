package com.github.alvaro72.period;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Period that represents a Day.
 * @author alsagui
 *
 */
public final class Day extends AbstractPeriod {
	private SimpleDateFormat format = null;
	
	/**
	 * Build a Day object with the specified date.
	 * @param date date.
	 */
	public Day(final Date date) {
		setStartDate(AbstractPeriod.clearDate(date));
		setEndDate(AbstractPeriod.clearDate(date));
	}

	/**
	 * Build a Day object with the current date, today.
	 */
	public Day() {
		this(new Date());
	}
	/**
	 * Create a Day of day, month and year.
	 * @param day day 1-32
	 * @param month month 1-12
	 * @param year year
	 * @return Day
	 */
	public static Day of(int day, int month, int year) {
		Calendar cal = Calendar.getInstance();

		cal.clear();
		cal.set(Calendar.DAY_OF_MONTH, day);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.YEAR, year);
		
		return new Day(cal.getTime());
	}
	
	@Override
	public Period previous() {
		Calendar c = Calendar.getInstance();
		
		c.setTime(getStartDate());
		c.add(Calendar.DAY_OF_MONTH, -1);
		
		return new Day(c.getTime());
	}
	
	@Override
	public Period next() {
		Calendar c = Calendar.getInstance();
		
		c.setTime(getStartDate());
		c.add(Calendar.DAY_OF_MONTH, 1);
		
		return new Day(c.getTime());
	}

	@Override
	public String toString() {
		if(format==null) {
			format = new SimpleDateFormat("dd MMMM YYYY");
		}
		
		return format.format(getStartDate());
	}

}
