package me.alsagui.period;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class Day extends AbstractPeriod {
	private SimpleDateFormat format = null;
	
	/**
	 * Build a Day object with the specified date.
	 * @param date date.
	 */
	public Day(final Date date) {
		Calendar c = Calendar.getInstance();
		
		c.setTime(date);
		
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		
		startDate = c.getTime();
		
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 0);

		endDate = c.getTime();
	}

	/**
	 * Build a Day object with the current date, today.
	 */
	public Day() {
		this(new Date());
	}
	
	public static Day of(int day, int month, int year) {
		Calendar cal = Calendar.getInstance();
		
		cal.set(Calendar.DAY_OF_MONTH, day);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.YEAR, year);
		
		return new Day(cal.getTime());
	}
	
	@Override
	public Period previous() {
		Calendar c = Calendar.getInstance();
		
		c.setTime(startDate);
		c.add(Calendar.DAY_OF_MONTH, -1);
		
		return new Day(c.getTime());
	}
	
	@Override
	public Period next() {
		Calendar c = Calendar.getInstance();
		
		c.setTime(startDate);
		c.add(Calendar.DAY_OF_MONTH, 1);
		
		return new Day(c.getTime());
	}

	@Override
	public String toString() {
		if(format==null) {
			format = new SimpleDateFormat("dd MMMM YYYY");
		}
		
		return format.format(startDate);
	}

}
