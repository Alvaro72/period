package com.github.alvaro72.period;


import java.util.Date;

/**
 * A length or portion of time between two dates.
 * @author alsagui
 *
 */
public interface Period {
    /**
     * Gets the start date of this period.
     * @return date start date.
     */
    Date getStartDate();
    /**
     * Gets the end date of this period.
     * @return date end date.
     */
    Date getEndDate();
    /**
     * Gets the days between dates.
     * @return long number of days
     */
    long getDays();
    /**
     * Check that the date is within the period.
     * @param date date to check.
     * @return true if is within the period, false otherwise.
     */
    boolean isWithin(Date date);
    /**
     * Check that the specified period is within this period.
     * @param period period to check.
     * @return true if is within the period, false otherwise.
     */
    boolean isWithin(Period period);
    /**
     * Returns the period before this, if not possible, throw an exception.
     * @return Period previous period.
     * @throws UnsupportedOperationException if it is not possible to
     * obtain the period.
     */
    Period previous() throws UnsupportedOperationException;
    /**
     * Returns the period after this, if not possible, throw an exception.
     * @return Period next period.
     * @throws UnsupportedOperationException if it is not possible to 
     * obtain the period.
     */
    Period next() throws UnsupportedOperationException;
}
