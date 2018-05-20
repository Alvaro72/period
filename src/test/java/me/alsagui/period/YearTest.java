package me.alsagui.period;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class YearTest {
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Test
	public final void testPrevious() {
		Calendar cal = Calendar.getInstance();
		cal.set(2018, 0, 1);
		Year y1 = new Year(cal.getTime());
		cal.set(2017, 0, 1);
		assertEquals(sdf.format(cal.getTime()), sdf.format(y1.previous().getStartDate()));
	}

	@Test
	public final void testNext() {
		Calendar cal = Calendar.getInstance();
		cal.set(2018, 0, 1);
		Year y1 = new Year(cal.getTime());
		cal.set(2019, 0, 1);
		assertEquals(sdf.format(cal.getTime()), sdf.format(y1.next().getStartDate()));
	}

	@Test
	public final void testYear() {
		Calendar cal = Calendar.getInstance();
		Year y1 = new Year();
		cal.setTime(y1.getStartDate());
		assertEquals(sdf.format(cal.getTime()), sdf.format(y1.getStartDate()));
	}

	@Test
	public final void testOf() {
		Calendar cal = Calendar.getInstance();
		cal.set(1997, 11, 31);
		Year d = Year.of(1997);
		assertEquals(sdf.format(cal.getTime()), sdf.format(d.getEndDate()));
	}

	@Test
	public final void testGetStartDate() {
		Calendar cal = Calendar.getInstance();
		cal.set(2018, 0, 1);
		Year d = new Year(cal.getTime());
		// Check immutability
		d.getStartDate().setYear(1900);
		assertEquals(sdf.format(cal.getTime()), sdf.format(d.getStartDate()));
	}

	@Test
	public final void testGetEndDate() {
		Calendar cal = Calendar.getInstance();
		cal.set(2018, 11, 31);
		Year d = new Year(cal.getTime());
		// Check immutability
		d.getStartDate().setYear(1900);
		assertEquals(sdf.format(cal.getTime()), sdf.format(d.getEndDate()));
	}

	@Test
	public final void testIsWithinDate() {
		Date date = new Date();
		Year y1 = new Year(date);
		assertTrue(y1.isWithin(date));
	}

	@Test
	public final void testGetDays() {
		Year y1 = new Year();
		assertEquals(365, y1.getDays());
	}

	@Test
	public final void testIsWithinPeriod() {
		Date date = new Date();
		Year y1 = new Year(date);
		Semester s1 = new Semester(date);
		assertTrue(y1.isWithin(s1));
	}

	@Test
	public final void testEqualsObject() {
		Date date = new Date();
		Year y1 = new Year(date);
		Year y2 = new Year(date);
		assertEquals(y1, y2);
	}

}
