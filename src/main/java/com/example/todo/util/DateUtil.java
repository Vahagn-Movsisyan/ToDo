package com.example.todo.util;

import lombok.experimental.UtilityClass;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@UtilityClass
public class DateUtil {
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    public static Date stringToDate(String dateStr) throws ParseException {
        return SIMPLE_DATE_FORMAT.parse(dateStr);
    }
    public static String dateToString(Date date) {
        return SIMPLE_DATE_FORMAT.format(date);
    }
}
