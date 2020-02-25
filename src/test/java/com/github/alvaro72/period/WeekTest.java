package com.github.alvaro72.period;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WeekTest {
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Test
	public final void testPrevious() {
		Calendar c = Calendar.getInstance();
		Week d = new Week(c.getTime());
		c.setTime(d.getStartDate());
		c.add(Calendar.DAY_OF_YEAR, -7);
  		assertEquals(sdf.format(d.previous().getStartDate()), sdf.format(c.getTime()));
	}

	@Test
	public final void testNext() {
		Calendar c = Calendar.getInstance();
		Week d = new Week(c.getTime());
		c.setTime(d.getStartDate());
		c.add(Calendar.DAY_OF_YEAR, 7);
		assertEquals(sdf.format(d.next().getStartDate()), sdf.format(c.getTime()));
	}
/*
	@Test
	public final void testMonth() {
		Date date = new Date();
		Week m = new Week(date);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, 1);
		assertEquals(sdf.format(c.getTime()), sdf.format(m.getStartDate()));
	}
 */
/*
	@Test
	public final void testOfIntInt() {
		Calendar c = Calendar.getInstance();
		Week d = Week.of(5, 2018);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.MONTH, 5 - 1);
		c.set(Calendar.YEAR, 2018);
		assertEquals(sdf.format(d.getStartDate()), sdf.format(c.getTime()));
	}

	@Test
	public final void testOfInt() {
		Calendar c = Calendar.getInstance();
		Week d = Week.of(9);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.MONTH, 9 - 1);
		assertEquals(sdf.format(d.getStartDate()), sdf.format(c.getTime()));
	}

	@Test
	public final void testOfPeriod() {
		Calendar c = Calendar.getInstance();
		Week d = Week.of(9);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.MONTH, 9 - 1);
		assertEquals(sdf.format(d.getStartDate()), sdf.format(c.getTime()));
	}
*/
	@Test
	public final void testGetStartDate() {
		Date date = new Date();
		Week d = new Week(date);
		// Check immutability
		d.getStartDate().setYear(1900);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, ( Calendar.MONDAY - cal.get(Calendar.DAY_OF_WEEK) ));
		assertEquals(sdf.format(cal.getTime()), sdf.format(d.getStartDate()));
	}

	@Test
	public final void testGetEndDate() {
		Date date = new Date();
		Week d = new Week(date);
		// Check immutability
		d.getEndDate().setYear(1900);
		Calendar cal = Calendar.getInstance();
		cal.setTime(d.getStartDate());
		cal.add(Calendar.DAY_OF_YEAR, 6);
		assertEquals(sdf.format(cal.getTime()), sdf.format(d.getEndDate()));
	}

	@Test
	public final void testIsWithinDate() {
		Date date = new Date();
		Week m = new Week(date);
		Day d = new Day(date);
		assertTrue(m.isWithin(d.getStartDate()));
	}

	@Test
	public final void testIsWithinPeriod() {
		Date date = new Date();
		Week w = new Week(date);
		Day d = new Day(date);
		assertTrue(w.isWithin(d));
	}

	@Test
	public final void testEqualsObject() {
		Date date = new Date();
		Week m1 = new Week(date);
		Week m2 = new Week(date);
		assertEquals(m1, m2);
	}
	@Test
	public final void testGetDays() {
		Week week = new Week();
		Date date1 = week.getStartDate();
		Date date2 = week.getEndDate();
		long diff = date2.getTime() - date1.getTime();
		long days = 1 + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		assertEquals(days, week.getDays());
	}

}
