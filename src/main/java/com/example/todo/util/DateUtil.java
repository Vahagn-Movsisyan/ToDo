package com.example.todo.util;

import lombok.experimental.UtilityClass;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@UtilityClass
public class DateUtil {
    private final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    public Date stringToDate(String dateStr) throws ParseException {
        return SIMPLE_DATE_FORMAT.parse(dateStr);
    }
    public  String dateToString(Date date) {
        return SIMPLE_DATE_FORMAT.format(date);
    }
}
