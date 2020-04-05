package com.github.alvaro72.period;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Period that represents a Week
 */
public class Week extends AbstractPeriod {
    private SimpleDateFormat format = null;
    private final static int LAST_HOUR = 23;
    private final static int LAST_MINUTE = 59;
    private final static int LAST_SECOND = 59;

    public Week(Date date) {
        Calendar c = Calendar.getInstance();
        if(c.getFirstDayOfWeek()==Calendar.SUNDAY) {
            c.setTime(date);

            c.add(Calendar.DAY_OF_YEAR, (Calendar.SUNDAY - c.get(Calendar.DAY_OF_WEEK)));
            c.set(Calendar.HOUR_OF_DAY, 0);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            c.set(Calendar.MILLISECOND, 0);

            setStartDate(AbstractPeriod.clearDate(c.getTime()));

            c.add(Calendar.DAY_OF_YEAR, 6);
            c.set(Calendar.HOUR_OF_DAY, 0);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            c.set(Calendar.MILLISECOND, 0);

            setEndDate(AbstractPeriod.clearDate(c.getTime()));
        }
        else {
            c.setTime(date);

            c.add(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY?-6:(Calendar.MONDAY - c.get(Calendar.DAY_OF_WEEK)));
            c.set(Calendar.HOUR_OF_DAY, 0);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            c.set(Calendar.MILLISECOND, 0);

            setStartDate(AbstractPeriod.clearDate(c.getTime()));

            c.add(Calendar.DAY_OF_YEAR, 6);
            c.set(Calendar.HOUR_OF_DAY, 0);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            c.set(Calendar.MILLISECOND, 0);

            setEndDate(AbstractPeriod.clearDate(c.getTime()));
        }
    }

    public Week() {
        this(new Date());
    }

    @Override
    public Period previous() throws UnsupportedOperationException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getStartDate());
        calendar.add(Calendar.DAY_OF_YEAR, -7);
        Date date = calendar.getTime();

        return new Week(date);
    }

    @Override
    public Period next() throws UnsupportedOperationException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getStartDate());
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        Date date = calendar.getTime();

        return new Week(date);
    }

    @Override
    public String toString() {
        if(format==null) {
            format = new SimpleDateFormat("dd MMMM YYYY");
        }

        return format.format(getStartDate()) + " - " +format.format(getEndDate());
    }
}
