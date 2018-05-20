package me.alsagui.period;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class TrimesterTest {
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Test
	public final void testPrevious() {
		Calendar cal = Calendar.getInstance();
		cal.set(2018, 9, 1);
		Trimester d = new Trimester(cal.getTime());
		cal.set(2018, 6, 1);
		assertEquals(sdf.format(cal.getTime()), sdf.format(d.previous().getStartDate()));
	}

	@Test
	public final void testNext() {
		Calendar cal = Calendar.getInstance();
		cal.set(2018, 6, 1);
		Trimester d = new Trimester(cal.getTime());
		cal.set(2018, 9, 1);
		assertEquals(sdf.format(cal.getTime()), sdf.format(d.next().getStartDate()));
	}

	@Test
	public final void testGetStartDate() {
		Calendar cal = Calendar.getInstance();
		cal.set(2018, 6, 1);
		Trimester d = new Trimester(cal.getTime());
		// Check immutability
		d.getStartDate().setYear(1900);
		assertEquals(sdf.format(cal.getTime()), sdf.format(d.getStartDate()));
	}

	@Test
	public final void testGetEndDate() {
		Calendar cal = Calendar.getInstance();
		cal.set(2018, 11, 31);
		Trimester d = new Trimester(cal.getTime());
		// Check immutability
		d.getEndDate().setYear(1900);
		assertEquals(sdf.format(cal.getTime()), sdf.format(d.getEndDate()));
	}

	@Test
	public final void testIsWithinDate() {
		Date date = new Date();
		Trimester t1 = new Trimester(date);
		assertTrue(t1.isWithin(date));
	}

	@Test
	public final void testGetDays() {
		Calendar cal = Calendar.getInstance();
		cal.set(2018, 6, 1);
		Trimester t1 = new Trimester(cal.getTime());
		assertEquals(92, t1.getDays());
	}

	@Test
	public final void testIsWithinPeriod() {
		Date date = new Date();
		Month m1 = new Month(date);
		Trimester t1 = new Trimester(date);
		assertTrue(t1.isWithin(m1));
	}

	@Test
	public final void testEqualsObject() {
		Trimester t1 = new Trimester();
		Trimester t2 = new Trimester();
		assertEquals(t1, t2);
	}

}
