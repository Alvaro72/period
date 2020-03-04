package com.github.alvaro72.period;

import java.util.Calendar;
import java.util.Date;

/**
 * Period that represents a Quarter.
 * @author alsagui
 *
 */
public final class Quarter extends AbstractPeriod {
    /**
     * Create a quarter from now.
     */
    public Quarter() {
        this(new Date());
    }
    /**
     * Quarter from a date.
     * @param date
     */
    public Quarter(final Date date) {
        Calendar c = Calendar.getInstance();
        
        c.setTime(date);
        
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        
        if (c.get(Calendar.MONTH) > 8) {
            c.set(Calendar.MONTH, 9);
        } else if (c.get(Calendar.MONTH) > 5) {
            c.set(Calendar.MONTH, 6);
        } else if (c.get(Calendar.MONTH) > 2) {
            c.set(Calendar.MONTH, 3);
        } else {
            c.set(Calendar.MONTH, 0);
        }
        
        setStartDate(c.getTime());
        
        c.add(Calendar.MONTH, 3);
        c.add(Calendar.DAY_OF_MONTH, -1);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 0);

        setEndDate(c.getTime());
    }
    
    /**
     * Create a quarter of trimester and year.
     * @param trimester
     * @param year
     * @return
     */
    public Quarter of(int trimester, int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, (trimester - 1) * 3, 1);
        
        return new Quarter(cal.getTime());
    }

    @Override
    public Period previous() {
        Calendar c = Calendar.getInstance();
        
        c.setTime(getStartDate());
        c.add(Calendar.MONTH, -3);
        
        return new Month(c.getTime());
    }
    
    @Override
    public Period next() {
        Calendar c = Calendar.getInstance();
        
        c.setTime(getStartDate());
        c.add(Calendar.MONTH, 3);
        
        return new Month(c.getTime());
    }


}
