package com.task.ecommerce.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class DateTimeUtils {

    public static final String APP_DATE_FORMAT = "dd-MMM-yyyy";
    public static final String ADI_DATE_FORMAT = "dd-MM-yyyy HH:mm:ss";
    public static final String TRANSACTION_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    public static final String ON_BEHALF_DATE_FORMAT = "dd/MM/yyyy";

    public static final String DHAKA_BANK_LINK_BANK_DATE_FORMAT = "ddMMMyyyy";

    public static final String MTB_LINK_SESSION_ID_FORMAT="yyyyMMddHHmmss";

    private static final String DHAKA_TIME_ZONE="Asia/Dhaka";

    public static final String ABG_DATE_TIME_FORMAT = "dd/MM/yyyy HH:mm";


    public static String formatDate(Date date, String dateFormat) {
        return (date == null || StringUtils.isBlank(dateFormat))
                ? ""
                : new SimpleDateFormat(dateFormat).format(date);
    }

    public static String formatDateInDhakaTimeZone(Date date, String dateFormat) {
        if (date == null || StringUtils.isBlank(dateFormat)) {
            return "";
        }

        TimeZone timeZone = TimeZone.getTimeZone(DHAKA_TIME_ZONE);
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        formatter.setTimeZone(timeZone);

        return formatter.format(date);
    }


    public static String formatDate(Date date) {
        return formatDate(date, ABG_DATE_TIME_FORMAT);
    }

    public static String convertToString(Date date, String dateFormat) {
        return formatDate(date, dateFormat);
    }

    public static String getCurrentDateString(String dateFormat) {
        return new SimpleDateFormat(dateFormat).format(new Date());
    }

    public static Date convertToDate(String dateStr, String dateFormat) {
        if (StringUtils.isBlank(dateStr) || StringUtils.isBlank(dateFormat))
            return null;
        try {
            return new SimpleDateFormat(dateFormat).parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date addHour(Date date, int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, hour);
        return calendar.getTime();
    }

    public static Date addMinutes(Date date, int minuets) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minuets);

        return calendar.getTime();
    }

    public static Date addDay(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, day);
        return calendar.getTime();
    }

    public static Date getFirstDayOfMonth() {
        return Date.from(LocalDate.now().withDayOfMonth(1).atStartOfDay().toInstant(ZoneOffset.UTC));
    }

    public static long getDateDifference(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillis = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillis, TimeUnit.MILLISECONDS);
    }

    public static long getDateDifferenceInDays(Date date1, Date date2) {
        return getDateDifference(date1, date2, TimeUnit.DAYS);
    }

    public static Date expireAtHour(int hour) {
        return addHour(new Date(), hour);
    }

    public static int convertToMilli(int minute, int calenderFlag) {
        if (Calendar.HOUR == calenderFlag) return 1000 * 60 * 60 * minute;
        if (Calendar.MINUTE == calenderFlag) return 1000 * 60 * minute;
        return 0;
    }

    public static long millisecondsToMinute(long milliseconds) {
        return TimeUnit.MILLISECONDS.toMinutes(milliseconds);
    }

    public static long millisecondsToSeconds(long milliseconds) {
        return TimeUnit.MILLISECONDS.toSeconds(milliseconds);
    }

    public static String convertMillisecondsToMinute(long milliseconds) {
        long minutes = millisecondsToMinute(milliseconds);
        long seconds = millisecondsToSeconds(milliseconds % 60);
        return minutes + "m " + seconds + "s";
    }

    public static long minuteToMillis(Integer minute) {
        return TimeUnit.MINUTES.toMillis(minute);
    }

    public static boolean validateStringDate(String date) {
        Pattern pattern = Pattern.compile("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$");
        Matcher matcher = pattern.matcher(date);
        return !matcher.matches();
    }

    public static long getCurrentTimestamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp.getTime();
    }

    public static Date convertToDateWithoutTime(Date dateToConvert) {
        if (dateToConvert == null)
            return null;

        String formattedDate = formatDate(dateToConvert, APP_DATE_FORMAT);
        return convertToDate(formattedDate, APP_DATE_FORMAT);
    }

    public static Date convertFirstDayOfTheMonth(final Date date) {
        if (date == null)
            return null;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.add(Calendar.MINUTE, 0);
        calendar.add(Calendar.SECOND, 0);
        calendar.add(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date wrappingDayFromDate(final Date currentMonth) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentMonth);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    public static Timestamp getCurrentTimeStamp(){
        return new Timestamp(System.currentTimeMillis());
    }
}
