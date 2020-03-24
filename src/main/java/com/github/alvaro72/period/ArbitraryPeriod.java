package com.github.alvaro72.period;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class ArbitraryPeriod extends AbstractPeriod {
	private SimpleDateFormat format = null;

	public ArbitraryPeriod(final Date startDate, final Date endDate) {
		if(endDate.before(startDate)) {
			throw new IllegalArgumentException("endDate previous to startDate.");
		}
		
		setStartDate(AbstractPeriod.clearDate(startDate));
		setEndDate(AbstractPeriod.clearDate(endDate));
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
