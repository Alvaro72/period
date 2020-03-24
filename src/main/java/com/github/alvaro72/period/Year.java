package com.github.alvaro72.period;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Period that represents a year.
 * @author alsagui
 *
 */
public final class Year extends AbstractPeriod {
	private SimpleDateFormat format = null;

	public Year() {
		this(new Date());
	}

	public Year(final Date date) {
		Calendar c = Calendar.getInstance();
		
		c.setTime(date);
		
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.MONTH, 0);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		
		setStartDate(c.getTime());
		
		c.set(Calendar.DAY_OF_MONTH, 31);
		c.set(Calendar.MONTH, 11);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);

		setEndDate(c.getTime());
	}
	public static Year of(int year) {
		Calendar c = Calendar.getInstance();
		
		c.set(Calendar.YEAR, year);
		
		return new Year(c.getTime());
	}

	@Override
	public Period previous() {
		Calendar c = Calendar.getInstance();
		
		c.setTime(getStartDate());
		c.add(Calendar.YEAR, -1);
		
		return new Year(c.getTime());
	}
	
	@Override
	public Period next() {
		Calendar c = Calendar.getInstance();
		
		c.setTime(getStartDate());
		c.add(Calendar.YEAR, 1);
		
		return new Year(c.getTime());
	}

	@Override
	public String toString() {
		if(format==null) {
			format = new SimpleDateFormat("YYYY");
		}
		
		return format.format(getStartDate());
	}

}
