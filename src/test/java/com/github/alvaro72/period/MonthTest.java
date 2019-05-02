package com.github.alvaro72.period;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.github.alvaro72.period.Day;
import com.github.alvaro72.period.Month;

public class MonthTest {
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Test
	public final void testPrevious() {
		Calendar c = Calendar.getInstance();
		Month d = new Month(c.getTime());
		c.add(Calendar.MONTH, -1);
		c.set(Calendar.DAY_OF_MONTH, 1);
  		assertEquals(sdf.format(d.previous().getStartDate()), sdf.format(c.getTime()));
	}

	@Test
	public final void testNext() {
		Calendar c = Calendar.getInstance();
		Month d = new Month(c.getTime());
		c.add(Calendar.MONTH, 1);
		c.set(Calendar.DAY_OF_MONTH, 1);
		assertEquals(sdf.format(d.next().getStartDate()), sdf.format(c.getTime()));
	}

	@Test
	public final void testMonth() {
		Date date = new Date();
		Month m = new Month(date);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, 1);
		assertEquals(sdf.format(c.getTime()), sdf.format(m.getStartDate()));
	}

	@Test
	public final void testOfIntInt() {
		Calendar c = Calendar.getInstance();
		Month d = Month.of(5, 2018);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.MONTH, 5 - 1);
		c.set(Calendar.YEAR, 2018);
		assertEquals(sdf.format(d.getStartDate()), sdf.format(c.getTime()));
	}

	@Test
	public final void testOfInt() {
		Calendar c = Calendar.getInstance();
		Month d = Month.of(9);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.MONTH, 9 - 1);
		assertEquals(sdf.format(d.getStartDate()), sdf.format(c.getTime()));
	}

	@Test
	public final void testOfPeriod() {
		Calendar c = Calendar.getInstance();
		Month d = Month.of(9);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.MONTH, 9 - 1);
		assertEquals(sdf.format(d.getStartDate()), sdf.format(c.getTime()));
	}

	@Test
	public final void testGetStartDate() {
		Date date = new Date();
		Month d = new Month(date);
		// Check immutability
		d.getStartDate().setYear(1900);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		assertEquals(sdf.format(cal.getTime()), sdf.format(d.getStartDate()));
	}

	@Test
	public final void testGetEndDate() {
		Date date = new Date();
		Month d = new Month(date);
		// Check immutability
		d.getEndDate().setYear(1900);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.MONTH, 1);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		assertEquals(sdf.format(cal.getTime()), sdf.format(d.getEndDate()));
	}

	@Test
	public final void testIsWithinDate() {
		Date date = new Date();
		Month m = new Month(date);
		Day d = new Day(date);
		assertTrue(m.isWithin(d.getStartDate()));
	}

	@Test
	public final void testIsWithinPeriod() {
		Date date = new Date();
		Month m = new Month(date);
		Day d = new Day(date);
		assertTrue(m.isWithin(d));
	}

	@Test
	public final void testEqualsObject() {
		Date date = new Date();
		Month m1 = new Month(date);
		Month m2 = new Month(date);
		assertEquals(m1, m2);
	}
	@Test
	public final void testGetDays() {
		Month m1 = new Month();
		Date endDate = m1.getEndDate();
		Calendar cal = Calendar.getInstance();
		cal.setTime(endDate);
		long lastDay = cal.get(Calendar.DAY_OF_MONTH);
		assertEquals(lastDay, m1.getDays());
	}

}
