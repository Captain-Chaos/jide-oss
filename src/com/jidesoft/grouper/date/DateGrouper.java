package com.jidesoft.grouper.date;

import com.jidesoft.grouper.ObjectGrouper;

import java.util.Calendar;
import java.util.Date;

/**
 * An abstract Grouper which can take data type such as Date, Calendar or Long and provide {@link #getCalendarFieldAsInt(Object,int)}
 * and {@link #getCalendarField(Object,int)} methods to access the field of the Calendar.
 */
abstract public class DateGrouper implements ObjectGrouper {
    protected static Calendar INSTANCE = Calendar.getInstance();

    public static Object getCalendarField(Object value, int field) {
        if (value instanceof Date) {
            INSTANCE.setTime(((Date) value));
            return new Integer(INSTANCE.get(field));
        }
        else if (value instanceof Long) {
            INSTANCE.setTime(new Date(((Long) value).longValue()));
            return new Integer(INSTANCE.get(field));
        }
        else if (value instanceof Calendar) {
            return new Integer(((Calendar) value).get(field));
        }
        else if (value == null) {
            return null;
        }
        else {
            throw new IllegalArgumentException("Type incompatible");
        }
    }

    public static int getCalendarFieldAsInt(Object value, int field) {
        if (value instanceof Date) {
            INSTANCE.setTime(((Date) value));
            return INSTANCE.get(field);
        }
        else if (value instanceof Long) {
            INSTANCE.setTime(new Date(((Long) value).longValue()));
            return INSTANCE.get(field);
        }
        else if (value instanceof Calendar) {
            return ((Calendar) value).get(field);
        }
        else if (value == null) {
            return -1;
        }
        else {
            throw new IllegalArgumentException("Type incompatible");
        }
    }

    public Class getType() {
        return int.class;
    }
}
