package me.alsagui.period;

import java.util.Date;

public abstract class AbstractPeriod implements Period {
	protected Date startDate;
	protected Date endDate;

	public Date getStartDate() {
		return new Date(startDate.getTime());
	}

	public Date getEndDate() {
		return new Date(endDate.getTime());
	}

	public Period previous() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Not implemented.");
	}

	public Period next() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Not implemented.");
	}

	public boolean isWithin(Date date) {
		if(date!=null && (startDate.before(date) || startDate.equals(date))
				&& (endDate.after(date)) || endDate.equals(date)) {
				return true;
		}
		
		return false;
	}

	public boolean isWithin(Period period) {
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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Period other = (Period) obj;
		if (getEndDate() == null) {
			if (other.getEndDate() != null)
				return false;
		} else if (!getEndDate().equals(other.getEndDate()))
			return false;
		if (getStartDate() == null) {
			if (other.getStartDate() != null)
				return false;
		} else if (!getStartDate().equals(other.getStartDate()))
			return false;
		return true;
	}


}
