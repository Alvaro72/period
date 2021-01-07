package com.github.alvaro72.period;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class SemesterTest {
	private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Test
	public final void testPrevious() {
		Calendar cal = Calendar.getInstance();
		cal.set(2018, Calendar.JULY, 1);
		Semester d = new Semester(cal.getTime());
		cal.set(2018, Calendar.JANUARY, 1);
		assertEquals(sdf.format(cal.getTime()), sdf.format(d.previous().getStartDate()));
	}

	@Test
	public final void testNext() {
		Calendar cal = Calendar.getInstance();
		cal.set(2018, Calendar.JULY, 1);
		Semester d = new Semester(cal.getTime());
		cal.set(2019, Calendar.JANUARY, 1);
		assertEquals(sdf.format(cal.getTime()), sdf.format(d.next().getStartDate()));
	}

	@Test
	public final void testGetStartDate() {
		Calendar cal = Calendar.getInstance();
		cal.set(2018, Calendar.JULY, 1);
		Semester d = new Semester(cal.getTime());
		// Check immutability
		d.getStartDate().setYear(1900);
		assertEquals(sdf.format(cal.getTime()), sdf.format(d.getStartDate()));
	}

	@Test
	public final void testGetEndDate() {
		Calendar cal = Calendar.getInstance();
		cal.set(2018, Calendar.DECEMBER, 31);
		Semester d = new Semester(cal.getTime());
		// Check immutability
		d.getEndDate().setYear(1900);
		assertEquals(sdf.format(cal.getTime()), sdf.format(d.getEndDate()));
	}

	@Test
	public final void testIsWithinDate() {
		Date date = new Date();
		Semester s1 = new Semester(date);
		assertTrue(s1.isWithin(date));
	}

	@Test
	public final void testGetDays() {
		Calendar cal = Calendar.getInstance();
		cal.set(2018, Calendar.JULY, 1);
		Semester s1 = new Semester(cal.getTime());
		assertEquals(184, s1.getDays());
	}

	@Test
	public final void testIsWithinPeriod() {
		Date date = new Date();
		Month m1 = new Month(date);
		Semester s1 = new Semester(date);
		assertTrue(s1.isWithin(m1));
	}

	@Test
	public final void testEqualsObject() {
		Semester s1 = new Semester();
		Semester s2 = new Semester();
		assertEquals(s1, s2);
	}

}
