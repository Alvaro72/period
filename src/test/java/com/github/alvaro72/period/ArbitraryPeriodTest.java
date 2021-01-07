package com.github.alvaro72.period;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArbitraryPeriodTest {
	private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


	@Test
	public final void testArbitraryPeriodDateDate() {
		Calendar cal = Calendar.getInstance();
		cal.set(2018, Calendar.DECEMBER, 31);
		ArbitraryPeriod ap = new ArbitraryPeriod(cal.getTime(), cal.getTime());
	}

	@Test
	public final void testArbitraryPeriodPeriod() {
		Calendar cal = Calendar.getInstance();
		cal.set(2018, Calendar.DECEMBER, 31);
		Quarter t = new Quarter(cal.getTime());
		ArbitraryPeriod ap = new ArbitraryPeriod(t);
	}

	@Test
	public final void testArbitraryPeriodPeriodPeriod() {
		Calendar cal = Calendar.getInstance();
		cal.set(2018, Calendar.DECEMBER, 31);
		Month m = new Month(cal.getTime());
		Year y = new Year(cal.getTime());
		ArbitraryPeriod ap = new ArbitraryPeriod(m, y);
	}

	@Test
	public final void testGetStartDate() {
		Calendar cal = Calendar.getInstance();
		cal.set(2018, Calendar.JANUARY, 31, 0, 0, 0);

		Date startDate = cal.getTime();
		cal.set(2018, Calendar.AUGUST, 31);
		ArbitraryPeriod ap = new ArbitraryPeriod(startDate, cal.getTime());
		assertEquals(sdf.format(startDate), sdf.format(ap.getStartDate()));
	}

	@Test
	public final void testGetEndDate() {
		Calendar cal = Calendar.getInstance();
		cal.set(2018, Calendar.JANUARY, 31);
		Date startDate = cal.getTime();
		cal.set(2018, Calendar.AUGUST, 31);
		ArbitraryPeriod ap = new ArbitraryPeriod(startDate, cal.getTime());
		assertEquals(sdf.format(cal.getTime()), sdf.format(ap.getEndDate()));
	}

	@Test
	public final void testPrevious() {
		ArbitraryPeriod ap = new ArbitraryPeriod(new Date(), new Date());
		assertThrows(UnsupportedOperationException.class, ap::previous);
	}

	@Test
	public final void testNext() {
		ArbitraryPeriod ap = new ArbitraryPeriod(new Date(), new Date());
		assertThrows(UnsupportedOperationException.class, ap::next);
	}

	@Test
	public final void testIsWithinDate() {
		Calendar cal = Calendar.getInstance();
		cal.set(2017, Calendar.MARCH, 30);
		ArbitraryPeriod ap = new ArbitraryPeriod(new Quarter(cal.getTime()));
		assertTrue( ap.isWithin(cal.getTime()) );
	}

	@Test
	public final void testGetDays() {
		ArbitraryPeriod ap = new ArbitraryPeriod(new Date(), new Date());
		assertEquals(1, ap.getDays());
	}

	@Test
	public final void testIsWithinPeriod() {
		Calendar cal = Calendar.getInstance();
		cal.set(2017, Calendar.MARCH, 30);
		ArbitraryPeriod ap = new ArbitraryPeriod(new Day(cal.getTime()));
		ArbitraryPeriod ap2 = new ArbitraryPeriod(new Quarter(cal.getTime()));
		assertTrue(ap2.isWithin(ap));
	}

	@Test
	public final void testEqualsObject() {
		Calendar cal = Calendar.getInstance();
		cal.set(2017, Calendar.MARCH, 30);
		ArbitraryPeriod ap = new ArbitraryPeriod(new Day(cal.getTime()));
		ArbitraryPeriod ap2 = new ArbitraryPeriod(new Day(cal.getTime()));
		assertEquals(ap, ap2);
	}

}
