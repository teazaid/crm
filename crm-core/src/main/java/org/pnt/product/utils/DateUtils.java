package org.pnt.product.utils;

import org.apache.commons.lang3.StringUtils;

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
        Date result = null;
        if(!StringUtils.isEmpty(dateStr)) {
            SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_FORMAT_PATTERN);
            result = sdf.parse(dateStr);
        }
        return result;
    }

    public static String convertToString(Date date) throws ParseException {
        String result = null;
        if(date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_FORMAT_PATTERN);
            result = sdf.format(date);
        }
        return result;
    }

    public static final String DEFAULT_DATE_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";
}
