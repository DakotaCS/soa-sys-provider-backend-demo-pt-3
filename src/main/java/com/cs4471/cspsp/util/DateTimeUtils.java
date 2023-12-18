package com.cs4471.cspsp.util;

import org.apache.commons.lang3.StringUtils;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author Dakota Soares
 * @version 2023.1.1
 * @since 2023-10-30
 */
public class DateTimeUtils {

    public static Date parseStringToDate(String date) {
        return StringUtils.isEmpty(date) ? null :
                localDateToDate(LocalDate.parse(date.substring(0,10)));
    }
    public static Date localDateToDate(LocalDate date) {
        return Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
