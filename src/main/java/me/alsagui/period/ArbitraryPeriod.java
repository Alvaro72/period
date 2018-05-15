package me.alsagui.period;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class ArbitraryPeriod extends AbstractPeriod {
	private SimpleDateFormat format = null;

	protected ArbitraryPeriod() {
		
	}
	
	public ArbitraryPeriod(final Date date) {
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

	public ArbitraryPeriod(final Date startDate, final Date endDate) {
		if(startDate.before(endDate)) {
			throw new IllegalArgumentException("endDate previous to startDate.");
		}
		
		this.startDate = startDate;
		this.endDate = endDate;
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
	
	public static void main(String[] args) {
		Period M = new ArbitraryPeriod(new Date());
		System.out.println(M);
		M.getStartDate().setMonth(9);
		System.out.println(M);

		Month M2 = new Month(new Date());
		System.out.println(M2.equals(M));
		
		System.out.println(M2.previous());
		System.out.println(M2.next());
	}

}
