package me.alsagui.period;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class ArbitraryPeriodTest {
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


	@Test
	public final void testArbitraryPeriodDateDate() {
		Calendar cal = Calendar.getInstance();
		cal.set(2018, 11, 31);
		ArbitraryPeriod ap = new ArbitraryPeriod(cal.getTime(), cal.getTime());
	}

	@Test
	public final void testArbitraryPeriodPeriod() {
		Calendar cal = Calendar.getInstance();
		cal.set(2018, 11, 31);
		Trimester t = new Trimester(cal.getTime());
		ArbitraryPeriod ap = new ArbitraryPeriod(t);
	}

	@Test
	public final void testArbitraryPeriodPeriodPeriod() {
		Calendar cal = Calendar.getInstance();
		cal.set(2018, 11, 31);
		Month m = new Month(cal.getTime());
		Year y = new Year(cal.getTime());
		ArbitraryPeriod ap = new ArbitraryPeriod(m, y);
	}

	@Test
	public final void testGetStartDate() {
		Calendar cal = Calendar.getInstance();
		cal.set(2018, 1, 31, 0, 0, 0);

		Date startDate = cal.getTime();
		cal.set(2018, 8, 31);
		ArbitraryPeriod ap = new ArbitraryPeriod(startDate, cal.getTime());
		assertEquals(sdf.format(startDate), sdf.format(ap.getStartDate()));
	}

	@Test
	public final void testGetEndDate() {
		Calendar cal = Calendar.getInstance();
		cal.set(2018, 1, 31);
		Date startDate = cal.getTime();
		cal.set(2018, 8, 31);
		ArbitraryPeriod ap = new ArbitraryPeriod(startDate, cal.getTime());
		assertEquals(sdf.format(cal.getTime()), sdf.format(ap.getEndDate()));
	}

	@Test(expected=UnsupportedOperationException.class)
	public final void testPrevious() {
		ArbitraryPeriod ap = new ArbitraryPeriod(new Date(), new Date());
		ap.previous();
	}

	@Test(expected=UnsupportedOperationException.class)
	public final void testNext() {
		ArbitraryPeriod ap = new ArbitraryPeriod(new Date(), new Date());
		ap.next();
	}

	@Test
	public final void testIsWithinDate() {
		Calendar cal = Calendar.getInstance();
		cal.set(2017, 3, 30);
		ArbitraryPeriod ap = new ArbitraryPeriod(new Trimester(cal.getTime()));
		assertEquals(true, ap.isWithin(cal.getTime()));
	}

	@Test
	public final void testGetDays() {
		ArbitraryPeriod ap = new ArbitraryPeriod(new Date(), new Date());
		assertEquals(1, ap.getDays());
	}

	@Test
	public final void testIsWithinPeriod() {
		Calendar cal = Calendar.getInstance();
		cal.set(2017, 3, 30);
		ArbitraryPeriod ap = new ArbitraryPeriod(new Day(cal.getTime()));
		ArbitraryPeriod ap2 = new ArbitraryPeriod(new Trimester(cal.getTime()));
		assertEquals(true, ap2.isWithin(ap));
	}

	@Test
	public final void testEqualsObject() {
		Calendar cal = Calendar.getInstance();
		cal.set(2017, 3, 30);
		ArbitraryPeriod ap = new ArbitraryPeriod(new Day(cal.getTime()));
		ArbitraryPeriod ap2 = new ArbitraryPeriod(new Day(cal.getTime()));
		assertEquals(ap, ap2);
	}

}
