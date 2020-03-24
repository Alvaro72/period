package com.github.alvaro72.period;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public abstract class AbstractPeriod implements Period {
	private Date startDate;
	private Date endDate;

	@Override
	public Date getStartDate() {
		return new Date(startDate.getTime());
	}

	@Override
	public Date getEndDate() {
		return new Date(endDate.getTime());
	}

	public void setStartDate(Date startDate) {
		this.startDate = new Date(AbstractPeriod.clearDate(startDate).getTime());
	}

	public void setEndDate(Date endDate) {
		this.endDate = new Date(AbstractPeriod.clearDate(endDate).getTime());
	}

	@Override
	public Period previous() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Not implemented.");
	}

	@Override
	public Period next() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Not implemented.");
	}

	@Override
	public boolean isWithin(Date date) {
		Date newdate = null;
		if(date!=null) {
			newdate = AbstractPeriod.clearDate(date);
		}
		if(newdate!=null && (startDate.before(newdate) || startDate.equals(newdate))
				&& (endDate.after(newdate)) || endDate.equals(newdate)) {
				return true;
		}
		
		return false;
	}

	public static Date clearDate(Date date) {
		Date newdate = null;

		if(date!=null) {
			int f_anio, f_mes, f_dia;

			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			f_anio = cal.get(Calendar.YEAR);
			f_mes = cal.get(Calendar.MONTH);
			f_dia = cal.get(Calendar.DAY_OF_MONTH);

			cal.clear();
			cal.setTimeZone(TimeZone.getTimeZone("UTC"));

			cal.set(Calendar.DAY_OF_MONTH, f_dia);
			cal.set(Calendar.MONTH, f_mes);
			cal.set(Calendar.YEAR, f_anio);
			newdate = cal.getTime();
		}
		else {
			throw new NullPointerException();
		}

		return newdate;
	}

	@Override
	public long getDays() {
		return 1 + TimeUnit.DAYS.convert(AbstractPeriod.clearDate(endDate).getTime() - AbstractPeriod.clearDate(startDate).getTime(), TimeUnit.MILLISECONDS);
	}
	
	/* (non-Javadoc)
	 * @see me.alsagui.period.Period#isWithin(Period period)
	 */
	@Override
	public boolean isWithin(final Period period) {
		return isWithin(period.getStartDate()) && isWithin(period.getEndDate());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
		result = prime * result + ((getStartDate() == null) ? 0 : getStartDate().hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Period other = (Period) obj;
		if (getEndDate() == null) {
			if (other.getEndDate() != null) {
				return false;
			}
		} else if (!getEndDate().equals(other.getEndDate())) {
			return false;
		}
		if (getStartDate() == null) {
			if (other.getStartDate() != null) {
				return false;
			}
		} else if (!getStartDate().equals(other.getStartDate())) {
			return false;
		}
		return true;
	}
}
