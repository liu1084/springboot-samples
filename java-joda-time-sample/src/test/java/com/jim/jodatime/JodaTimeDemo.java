package com.jim.jodatime;


import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Instant;
import org.joda.time.LocalTime;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@Test
@Slf4j
public class JodaTimeDemo {

    /**
     * Instant 表示时间轴上一个的一点,时区使用UTC标准时区
     */
    @Test
    public void testInstant() {
        Instant instant = new Instant();
        DateTimeZone timeZone = instant.getZone();
        Assert.assertEquals(timeZone.getID(), "UTC");
        long nowTimestamp = instant.getMillis();

        int oneDayMillSeconds = 24 * 3600 * 1000;
        instant = instant.minus(oneDayMillSeconds);
        long yesterdayTimestamp = instant.getMillis();

        Assert.assertEquals(nowTimestamp - yesterdayTimestamp, oneDayMillSeconds);
    }

    /**
     * DateTime类用来代替JDK中的Calendar类，时间格式ISO8601，年月日T时分秒+时区，2016-02-26T16:02:57.582+08:00
     */
    @Test
    public void testDateTime() {
        //构造一个当前系统时间
        DateTime dateTime = new DateTime();
        Calendar calendar = Calendar.getInstance();
        Assert.assertEquals(dateTime.getDayOfMonth(), calendar.get(5));
        Assert.assertEquals(dateTime.getYear(), calendar.get(1));
        Assert.assertEquals(dateTime.getMillis() / 1000, calendar.getTimeInMillis() / 1000);
        //构造一个指定年月日
        DateTime birthday = new DateTime(1977, 10, 10, 2, 0, 0);
        log.debug(birthday.toString());

        //构造好日期后，可以对年月日时分秒进行增减，这个时候遇到跨年、跨月或者闰年等情况，会自动算好，不必担心算错
        dateTime = dateTime.withDayOfMonth(31);
        int lastDayOfNextMonth = dateTime.plusMonths(1).getDayOfMonth();
        Assert.assertEquals(dateTime.getYear(), 2018);
        Assert.assertEquals(lastDayOfNextMonth, 28);

        Assert.assertEquals("一月", dateTime.monthOfYear().getAsText(Locale.CHINA));

        //对DateTime中某些字段置0操作
        DecimalFormat decimalFormat = new DecimalFormat("00");

        log.debug(dateTime.getYear()
                + "-" + decimalFormat.format(dateTime.getMonthOfYear())
                + "-" + decimalFormat.format(dateTime.getDayOfMonth())
                + "T00:00:00.000+08:00"
        );

        dateTime = dateTime.plusMonths(1);
        Assert.assertEquals(dateTime.year().isLeap(), false);
    }
}
