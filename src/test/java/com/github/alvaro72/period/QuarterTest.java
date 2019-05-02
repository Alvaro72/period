package com.github.alvaro72.period;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.github.alvaro72.period.Month;
import com.github.alvaro72.period.Quarter;

public class QuarterTest {
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Test
	public final void testPrevious() {
		Calendar cal = Calendar.getInstance();
		cal.set(2018, 9, 1);
		Quarter d = new Quarter(cal.getTime());
		cal.set(2018, 6, 1);
		assertEquals(sdf.format(cal.getTime()), sdf.format(d.previous().getStartDate()));
	}

	@Test
	public final void testNext() {
		Calendar cal = Calendar.getInstance();
		cal.set(2018, 6, 1);
		Quarter d = new Quarter(cal.getTime());
		cal.set(2018, 9, 1);
		assertEquals(sdf.format(cal.getTime()), sdf.format(d.next().getStartDate()));
	}

	@Test
	public final void testGetStartDate() {
		Calendar cal = Calendar.getInstance();
		cal.set(2018, 6, 1);
		Quarter d = new Quarter(cal.getTime());
		// Check immutability
		d.getStartDate().setYear(1900);
		assertEquals(sdf.format(cal.getTime()), sdf.format(d.getStartDate()));
	}

	@Test
	public final void testGetEndDate() {
		Calendar cal = Calendar.getInstance();
		cal.set(2018, 11, 31);
		Quarter d = new Quarter(cal.getTime());
		// Check immutability
		d.getEndDate().setYear(1900);
		assertEquals(sdf.format(cal.getTime()), sdf.format(d.getEndDate()));
	}

	@Test
	public final void testIsWithinDate() {
		Date date = new Date();
		Quarter t1 = new Quarter(date);
		assertTrue(t1.isWithin(date));
	}

	@Test
	public final void testGetDays() {
		Calendar cal = Calendar.getInstance();
		cal.set(2018, 6, 1);
		Quarter t1 = new Quarter(cal.getTime());
		assertEquals(92, t1.getDays());
	}

	@Test
	public final void testIsWithinPeriod() {
		Date date = new Date();
		Month m1 = new Month(date);
		Quarter t1 = new Quarter(date);
		assertTrue(t1.isWithin(m1));
	}

	@Test
	public final void testEqualsObject() {
		Quarter t1 = new Quarter();
		Quarter t2 = new Quarter();
		assertEquals(t1, t2);
	}

}
