package me.alsagui.period;

import java.util.Calendar;
import java.util.Date;

public final class Semester extends AbstractPeriod {
	public Semester() {
		this(new Date());
	}
	/**
	 * Semester from a date
	 * @param date
	 */
	public Semester(final Date date) {
		Calendar c = Calendar.getInstance();
		
		c.setTime(date);
		
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		
		if(c.get(Calendar.MONTH)>5) {
			c.set(Calendar.MONTH, 6);
		}
		else {
			c.set(Calendar.MONTH, 0);
		}
		
		startDate = c.getTime();
		
		c.add(Calendar.MONTH, 6);
		c.add(Calendar.DAY_OF_MONTH, -1);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 0);

		endDate = c.getTime();
	}

	@Override
	public Period previous() {
		Calendar c = Calendar.getInstance();
		
		c.setTime(startDate);
		c.add(Calendar.MONTH, -6);
		
		return new Month(c.getTime());
	}
	
	@Override
	public Period next() {
		Calendar c = Calendar.getInstance();
		
		c.setTime(startDate);
		c.add(Calendar.MONTH, 6);
		
		return new Month(c.getTime());
	}

}
