package com.cynen.jdk8;

import org.junit.Test;

import java.time.*;

public class DateTimes {

    /**
     * 首先，Clock类使用时区来返回当前的纳秒时间和日期。
     * Clock可以替代System.currentTimeMillis()和TimeZone.getDefault()。
     */
    @Test
    public void  test(){
        final Clock clock = Clock.systemUTC();
        System.out.println( clock.instant() );
        System.out.println( clock.millis() );
    }


    /**
     * 第二，关注下LocalDate和LocalTime类。
     * LocalDate仅仅包含ISO-8601日历系统中的日期部分；
     * LocalTime则仅仅包含该日历系统中的时间部分。
     * 这两个类的对象都可以使用Clock对象构建得到。
     */
    @Test
    public void  test2(){
        final Clock clock = Clock.systemUTC();
        // Get the local date and local time
        final LocalDate date = LocalDate.now();
        final LocalDate dateFromClock = LocalDate.now( clock );

        System.out.println("当前日期: "+ date );
        System.out.println("当前日期: "+ dateFromClock );

        // Get the local date and local time
        final LocalTime time = LocalTime.now();
        final LocalTime timeFromClock = LocalTime.now( clock );

        System.out.println("当前时间: "+ time );
        System.out.println( timeFromClock );
    }

    /**
     * LocalDateTime类包含了LocalDate和LocalTime的信息，但是不包含ISO-8601日历系统中的时区信息
     */
    @Test
    public void test3(){
        final Clock clock = Clock.systemUTC();
        // Get the local date/time
        final LocalDateTime datetime = LocalDateTime.now();
        final LocalDateTime datetimeFromClock = LocalDateTime.now( clock );

        System.out.println( datetime ); // 当前系统时间.
        System.out.println( datetimeFromClock ); // 标准时间

    }

    @Test
    public void test4(){
        // 如何将LocalDateTime转换成毫秒值?
        System.out.println(LocalDateTime.now().getMinute());

        System.out.println(LocalTime.now());

    }

    /**
     * 最后看下Duration类，它持有的时间精确到秒和纳秒。
     * 这使得我们可以很容易得计算两个日期之间的不同，
     */
    @Test
    public void test5(){
        // Get duration between two dates
        final LocalDateTime from = LocalDateTime.of( 2018, Month.MAY, 16, 0, 0, 0 );
        final LocalDateTime to = LocalDateTime.of( 2019, Month.JANUARY, 15, 16, 26, 0 );

        final Duration duration = Duration.between( from, to );
        System.out.println( "Duration in days: " + duration.toDays() );
        System.out.println( "Duration in hours: " + duration.toHours() );

        System.out.println(to.minusSeconds(6000));
    }

}
