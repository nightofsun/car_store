package com.service.api.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private DateUtils() {
        throw new IllegalStateException("Util class");
    }
    public static String formatDateToString(Date date, String pattern) {
        SimpleDateFormat format;
        if (date!=null && StringUtils.isNotEmtyOrNull(pattern)) {
            format = new SimpleDateFormat(pattern);
            return format.format(date);
        }
        return null;
    }
}
