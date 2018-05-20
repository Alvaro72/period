package me.alsagui.period;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class DayTest {
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Test
	public final void testPrevious() {
		Calendar c = Calendar.getInstance();
		Day d = new Day(c.getTime());
		c.add(Calendar.DAY_OF_MONTH, -1);
		assertEquals(sdf.format(d.previous().getStartDate()), sdf.format(c.getTime()));
	}

	@Test
	public final void testNext() {
		Calendar c = Calendar.getInstance();
		Day d = new Day(c.getTime());
		c.add(Calendar.DAY_OF_MONTH, 1);
		assertEquals(sdf.format(d.next().getStartDate()), sdf.format(c.getTime()));
	}

	@Test
	public final void testDayDate() {
		Date date = new Date();
		Day d = new Day(date);
		assertEquals(sdf.format(date), sdf.format(d.getStartDate()));
	}

	@Test
	public final void testDay() {
		Date date = new Date();
		Day d = new Day();
		assertEquals(sdf.format(date), sdf.format(d.getStartDate()));
	}

	@SuppressWarnings("deprecation")
	@Test
	public final void testGetStartDate() {
		Date date = new Date();
		Day d = new Day(date);
		// Check immutability
		d.getStartDate().setYear(1900);
		assertEquals(sdf.format(date), sdf.format(d.getStartDate()));
	}

	@SuppressWarnings("deprecation")
	@Test
	public final void testGetEndDate() {
		Date date = new Date();
		Day d = new Day(date);
		// Check immutability
		d.getStartDate().setYear(1900);
		assertEquals(sdf.format(date), sdf.format(d.getEndDate()));
	}

	@Test
	public final void testEqualsObject() {
		Date date = new Date();
		Day d1 = new Day(date);
		Day d2 = new Day(date);
		assertEquals(d1, d2);
	}

	@Test
	public final void testIsWithinDate() {
		Date date = new Date();
		Day d1 = new Day(date);
		assertTrue(d1.isWithin(date));
	}

	@Test
	public final void testIsWithinPeriod() {
		Date date = new Date();
		Day d1 = new Day(date);
		Day d2 = new Day(date);
		assertTrue(d1.isWithin(d2) && d2.isWithin(d1));
	}

	@Test
	public final void testOfDayMonthYear() {
		Day d1 = Day.of(19, 1, 2018);
		Date date = d1.getStartDate();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		assertTrue(cal.get(Calendar.DAY_OF_MONTH)==19 && cal.get(Calendar.MONTH)==0 && cal.get(Calendar.YEAR)==2018);
	}

	@Test
	public final void testGetDays() {
		Day d1 = Day.of(19, 1, 2018);
		assertEquals(1L, d1.getDays());
	}
}
