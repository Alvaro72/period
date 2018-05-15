package me.alsagui.period;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class Month extends AbstractPeriod {
	private SimpleDateFormat format = null;
	
	public Month(final Date date) {
		Calendar c = Calendar.getInstance();
		
		c.setTime(date);
		
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		
		startDate = c.getTime();
		
		c.add(Calendar.MONTH, 1);
		c.add(Calendar.DAY_OF_MONTH, -1);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 0);

		endDate = c.getTime();
	}

	public static Month of(int month, int year) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, month);
		c.set(Calendar.YEAR, year);
		
		return new Month(c.getTime());
	}

	public static Month of(int month) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, month);
		
		return new Month(c.getTime());
	}
	
	@Override
	public Period previous() {
		Calendar c = Calendar.getInstance();
		
		c.setTime(startDate);
		c.add(Calendar.MONTH, -1);
		
		return new Month(c.getTime());
	}
	
	@Override
	public Period next() {
		Calendar c = Calendar.getInstance();
		
		c.setTime(startDate);
		c.add(Calendar.MONTH, 1);
		
		return new Month(c.getTime());
	}

	@Override
	public String toString() {
		if(format==null) {
			format = new SimpleDateFormat("MMMM YYYY");
		}
		
		return format.format(startDate);
	}
	
	public static void main(String[] args) {
		Month M = new Month(new Date());
		System.out.println(M);
		M.getStartDate().setMonth(9);
		System.out.println(M);

		Month M2 = new Month(new Date());
		System.out.println(M2.equals(M));
		
		System.out.println(M2.previous());
		System.out.println(M2.next());
	}
}
