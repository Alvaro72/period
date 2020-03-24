package com.github.alvaro72.period;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Period that represents a month.
 * @author alsagui
 *
 */
public final class Month extends AbstractPeriod {
	private SimpleDateFormat format = null;
	
	/**
	 * Month with the current month
	 */
	public Month() {
		this(new Date());
	}
	/**
	 * Month from a date
	 * @param date
	 */
	public Month(final Date date) {
		Calendar c = Calendar.getInstance();
		
		c.setTime(date);
		
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		
		setStartDate(c.getTime());
		
		c.add(Calendar.MONTH, 1);
		c.add(Calendar.DAY_OF_MONTH, -1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);

		setEndDate(c.getTime());
	}

	public static Month of(final int month, final int year) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, month - 1);
		c.set(Calendar.YEAR, year);
		
		return new Month(c.getTime());
	}

	public static Month of(final int month) {
		Calendar c = Calendar.getInstance();
		
		return of(month, c.get(Calendar.YEAR));
	}
	
	public static Month of(Period period) {
		Month m = new Month(period.getStartDate());
		if(!m.isWithin(period)) {
			throw new IllegalArgumentException();
		}
		return m;
	}
	
	@Override
	public Period previous() {
		Calendar c = Calendar.getInstance();
		
		c.setTime(getStartDate());
		c.add(Calendar.MONTH, -1);
		
		return new Month(c.getTime());
	}
	
	@Override
	public Period next() {
		Calendar c = Calendar.getInstance();
		
		c.setTime(getStartDate());
		c.add(Calendar.MONTH, 1);
		
		return new Month(c.getTime());
	}

	@Override
	public String toString() {
		if(format==null) {
			format = new SimpleDateFormat("MMMM YYYY");
		}
		
		return format.format(getStartDate());
	}
}
