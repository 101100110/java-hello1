package com.yjh.java;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * @author yjh 1600063206@qq.com
 * @version 2022/12/27 9:07
 * @since JDK8
 */
public class JDK8DateTimeTest {
    @Test
    public void testDate(){
        //偏移量
        Date date1=new Date(2020-1900,9-1,8);
        System.out.println(date1);//Tue Sep 08 00:00:00 GMT+08:00 2020
    }
    /*
    LocalDate,LocalTime,LocalDateTime的使用
    说明：
        1.LocalDateTime相较于LocalDate,LocalTime,使用频率要高
     */
    @Test
    public void test1(){
        //now():获取当前的日期，时间，日期和时间
        LocalDate localDate=LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of():设置指定的年，月，日，时，分，秒。没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 10, 6, 13, 23, 43);
        System.out.println(localDateTime1);

        //getXxx()
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMinute());

        //体现不可变性
        //withXxx():设置相关属性
        LocalDate localDate1 = localDate.withDayOfMonth(2);
        System.out.println(localDate);
        System.out.println(localDate1);

        LocalDateTime localDateTime2 = localDateTime.withHour(4);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);

        //不可变性
        LocalDateTime localDateTime3 = localDateTime.plusMonths(3);
        System.out.println(localDateTime);
        System.out.println(localDateTime3);

        LocalDateTime localDateTime4 = localDateTime.minusDays(6);
        System.out.println(localDateTime);
        System.out.println(localDateTime4);
    }

    /*
    Instant的使用
     */
    @Test
    public void test2(){
        //now():获取本初子午线对应的标准时间
        Instant instant=Instant.now();
        System.out.println(instant);//2022-12-28T01:06:54.466Z

        //添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);//2022-12-28T09:06:54.466+08:00

        //获取自1970年1月1日0时0分0秒(UTC)开始的毫秒数 ---->Date类的getTime()
        long milli = instant.toEpochMilli();
        System.out.println(milli);

        //ofEpochMilli():通过给定的毫秒数，获取Instant实例 --->Date(long millis)
        Instant instant1 = Instant.ofEpochMilli(1672189836273L);
        System.out.println(instant1);
    }

    /*
    DateTimeFormatter:格式化或解析日期，时间
    类似于SimpleDateFormat
     */

    @Test
    public void test3(){
//        方式一：预定义的标准样式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化:日期---->字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String s = formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(s);

        //解析：字符串--->日期
        TemporalAccessor parse = formatter.parse("2019-02-18T15:42:18.797");
        System.out.println(parse);

//        方式二：
//        本地化相关的格式。如：ofLocalizedDateTime()
//        FormatStyle.LONG/FormatStyle.MEDIUM/FormatStyle.SHORT:适用于LocalDateTIme
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        //格式化
        String str2 = formatter1.format(localDateTime);
        System.out.println(str2);//2022年12月28日 上午09时51分35秒

//        本地化相关的格式。如：ofLocalizedDate()
//        FormatStyle.FULL/FormatStyle.LONG/FormatStyle.MEDIUM/FormatStyle.SHORT:适用于LocalDate
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        //格式化
        String str3 = formatter2.format(LocalDate.now());
        System.out.println(str3);//2022年12月28日 星期三


//      重点：  方式三：自定义的格式。如：ofPattern("yyyy-MM-dd hh:mm:ss E")
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String str4 = formatter3.format(LocalDateTime.now());
        System.out.println(str4);//2022-12-28 10:01:41

        //解析
        TemporalAccessor parse1 = formatter3.parse("2019-02-08 03:52:09");
        System.out.println(parse1);



    }
}