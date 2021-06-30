package com.health.app.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTest {

    public static String pattern = "yyyy-MM-dd";
    public static String pattern2 = "yyyy/MM/dd";
    public static String patternSSS = "yyyy-MM-dd HH:mm:ss.SSS";
    public static String patternss= "yyyy-MM-dd HH:mm:ss";

    public static SimpleDateFormat formatSSS = new SimpleDateFormat(patternSSS);
    public static SimpleDateFormat format_ss = new SimpleDateFormat(patternss);
    public static DateTimeFormatter dateTimeFormatter_ss =DateTimeFormatter.ofPattern(patternss);
    public static DateTimeFormatter dateTimeFormatterSSS =DateTimeFormatter.ofPattern(patternSSS);

    public static void main(String[] args) {


    }

    private static void date2LocalDateTime2() {
        // localDateTime to date example 1
        LocalDateTime localDateTime =  LocalDateTime.now().toInstant(ZoneOffset.of("+8")).atZone(ZoneId.of("+8")).toLocalDateTime();
        String zoneIdTimeStr = localDateTime.format(dateTimeFormatter_ss);
        System.out.println("zoneIdTimeStr is "+zoneIdTimeStr);
        Date date = Date.from(localDateTime.toInstant(ZoneOffset.of("+8")));
        System.out.println("date 1 is "+date);

        // localDateTime to date  example 2
        localDateTime =LocalDateTime.now().toInstant(ZoneOffset.of("+8")).atOffset(ZoneOffset.of("+8")).toLocalDateTime();
        String zoneOffSetTimeStr = localDateTime.format(dateTimeFormatter_ss);
        System.out.println("zoneOffSetTimeStr is "+zoneOffSetTimeStr);
        date = Date.from(localDateTime.toInstant(ZoneOffset.of("+8")));
        System.out.println("date 2 is "+date);


        // date to  localDateTime

        Date dd = new Date();
        // date to TimeStamp
        Timestamp timestamp = new Timestamp(dd.getTime());
        System.out.println(String.format("timestamp format is " +format_ss.format(timestamp)));
        Instant instant = dd.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant,zoneId);
        System.out.println("dateTime format is "+dateTimeFormatter_ss.format(dateTime));
    }


    /**
     * 字符窜  localDateTime 转换
     *
     * */
    private static void String2LocalDateTime() {
        // localDateTime 转 字符窜
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(patternss);
        LocalDateTime localDateTime = LocalDateTime.now(ZoneOffset.of("+8"));// now(ZoneId.offset("+8"))
        String dateStr = localDateTime.format(formatter);
        System.out.println("dateStr is "+dateStr);

        // 字符窜 转 localDateTime

        String timeStr = "2021-06-30 11:24:05";
        LocalDateTime testTime = LocalDateTime.parse(timeStr,formatter);
        System.out.println("testTime is "+testTime);
        System.out.println("testTime toLocalDate "+testTime.toLocalDate());
        System.out.println("testTime toLocalTime "+testTime.toLocalTime());
    }

    /**
     * 获取LocalDateTime 毫秒、微妙
     *
     * */
    private static void getSecondOrMillis() {
        Long second = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8")); //北京时间，毫秒
        System.out.println("second is "+second);
        LocalDateTime localDateTime= LocalDateTime.ofInstant(new Date().toInstant(),ZoneId.systemDefault());

        Long millis = localDateTime.toEpochSecond(ZoneOffset.of("+8"))* 1000;
        System.out.println("millis is "+millis);

        Instant instant= localDateTime.toInstant(ZoneOffset.of("+8"));
        System.out.println("millis 2 is "+instant.toEpochMilli());
    }

    /**
     * date  LocalDateTime 转换
     * TimeStamp(long)-->Date(long)-->Instant+ZoneId-->LocalDateTime
     * */
    private static void date2LocalDateTime1() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);

        Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());
        Date d = new Date(timestamp1.getTime());

        Instant instant = d.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        LocalDate localDate = instant.atZone(zoneId).toLocalDate();
        System.out.println("localDateTime "+localDateTime);
        System.out.println("localDate "+localDate);
    }

}
