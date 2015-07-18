package org.pnt.product.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Alexander on 18.07.2015.
 */
public class DateUtils {
    public static Date now() {
        return new Date();
    }

    public static Date convertToDate(String dateStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_FORMAT_PATTERN);
        return sdf.parse(dateStr);
    }

    public static String convertToString(Date date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_FORMAT_PATTERN);
        return sdf.format(date);
    }

    public static final String DEFAULT_DATE_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";
}
