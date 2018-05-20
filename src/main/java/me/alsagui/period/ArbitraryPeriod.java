package me.alsagui.period;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class ArbitraryPeriod extends AbstractPeriod {
	private SimpleDateFormat format = null;

	public ArbitraryPeriod(final Date startDate, final Date endDate) {
		if(startDate.before(endDate)) {
			throw new IllegalArgumentException("endDate previous to startDate.");
		}
		
		Calendar c = Calendar.getInstance();
		
		c.setTime(startDate);
		
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		
		this.startDate = c.getTime();
		
		c.setTime(endDate);
		
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 0);
		
		this.endDate = c.getTime();
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
		return format.format(startDate) + "-"
			+ format.format(endDate);
	}
	
}
