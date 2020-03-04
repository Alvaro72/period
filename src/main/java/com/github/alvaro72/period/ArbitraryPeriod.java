package com.github.alvaro72.period;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class ArbitraryPeriod extends AbstractPeriod {
	private SimpleDateFormat format = null;
	private final static int LAST_HOUR = 23;
	private final static int LAST_MINUTE = 59;
	private final static int LAST_SECOND = 59;

	public ArbitraryPeriod(final Date startDate, final Date endDate) {
		if(endDate.before(startDate)) {
			throw new IllegalArgumentException("endDate previous to startDate.");
		}
		
		Calendar c = Calendar.getInstance();
		
		c.setTime(startDate);
		
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		
		setStartDate(c.getTime());
		
		c.setTime(endDate);
		
		c.set(Calendar.HOUR_OF_DAY, LAST_HOUR);
		c.set(Calendar.MINUTE, LAST_MINUTE);
		c.set(Calendar.SECOND, LAST_SECOND);
		c.set(Calendar.MILLISECOND, 0);
		
		setEndDate(c.getTime());
	}

	public ArbitraryPeriod(final Period period) {
		this(period.getStartDate(), period.getEndDate());
	}

	public ArbitraryPeriod(final Period startPeriod, final Period endPeriod) {
		this(startPeriod.getStartDate(), endPeriod.getEndDate());
	}

	@Override
	public String toString() {
		if(format==null) {
			format = new SimpleDateFormat("dd MMMM YYYY");
		}
		return format.format(getStartDate()) + "-"
			+ format.format(getEndDate());
	}
	
}
