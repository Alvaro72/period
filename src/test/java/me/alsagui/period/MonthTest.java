package me.alsagui.period;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

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
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testOfIntInt() {
		Calendar c = Calendar.getInstance();
		Month d = Month.of(5, 2018);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.MONTH, 5);
		c.set(Calendar.YEAR, 2018);
		assertEquals(sdf.format(d.getStartDate()), sdf.format(c.getTime()));
	}

	@Test
	public final void testOfInt() {
		Calendar c = Calendar.getInstance();
		Month d = Month.of(9);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.MONTH, 9);
		assertEquals(sdf.format(d.getStartDate()), sdf.format(c.getTime()));
	}

	@Test
	public final void testGetStartDate() {
		Date date = new Date();
		Month d = new Month(date);
		// Check immutability
		d.getStartDate().setYear(1900);
		assertEquals(sdf.format(date), sdf.format(d.getStartDate()));
	}

	@Test
	public final void testGetEndDate() {
		Date date = new Date();
		Month d = new Month(date);
		// Check immutability
		d.getEndDate().setYear(1900);
		assertEquals(sdf.format(date), sdf.format(d.getEndDate()));
	}

	@Test
	public final void testIsWithinDate() {
		Month m = new Month(new Date());
		Day d = new Day();
		assertTrue(m.isWithin(d.getStartDate()));
	}

	@Test
	public final void testIsWithinPeriod() {
		Month m = new Month(new Date());
		Day d = new Day();
		assertTrue(m.isWithin(d));
	}

	@Test
	public final void testEqualsObject() {
		Month m1 = new Month(new Date());
		Month m2 = new Month(new Date());
		assertEquals(m1, m2);
	}

}
