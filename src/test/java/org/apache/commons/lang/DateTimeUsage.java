package org.apache.commons.lang;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;

public class DateTimeUsage {
	public static void main(String[] args) {
        demoDateUtils();
        demoStopWatch();
    }
   
    public static void demoDateUtils() {
        System.out.println(StringUtils.center(" demoDateUtils ", 30, "="));
        Date date = new Date();
        String isoDateTime =DateFormatUtils.ISO_DATETIME_FORMAT.format(date);
        String isoTime =DateFormatUtils.ISO_TIME_NO_T_FORMAT.format(date);
        FastDateFormat fdf = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");
        String customDateTime =fdf.format(date);
        System.out.println("ISO_DATETIME_FORMAT: " + isoDateTime);
        System.out.println("ISO_TIME_NO_T_FORMAT: " + isoTime);
        System.out.println("Custom FastDateFormat: " +customDateTime);
        System.out.println("Default format: " + date);
        System.out.println("Round HOUR: " + DateUtils.round(date,Calendar.HOUR));
        System.out.println("Truncate HOUR: " +DateUtils.truncate(date, Calendar.HOUR));
        System.out.println();
    }
   
    public static void demoStopWatch() {
        System.out.println(StringUtils.center(" demoStopWatch ", 30, "="));
        StopWatch sw = new StopWatch();
        sw.start();
        operationA();
        sw.stop();
        System.out.println("operationA used " + sw.getTime() + " milliseconds.");
        System.out.println();
    }
   
    public static void operationA() {
        try {
            Thread.sleep(999);
        }
        catch (InterruptedException e) {
        }
    }
    
    @Test
    public  void test() throws InterruptedException, ParseException {
        //date1 created
        Date date1= new Date();
        //Print the date and time at this instant
        System.out.println("The time right now is >>"+date1);
        //Thread sleep for 1000 ms
        Thread.currentThread().sleep(1000);
        //date2 created.
        Date date2= new Date();
        //Check if date1 and date2 have the same day
        System.out.println("Is Same Day >> "+ DateUtils.isSameDay(date1, date2));
        //Check if date1 and date2 have the same instance
        System.out.println("Is Same Instant >> " +DateUtils.isSameInstant(date1, date2));
        //Round the hour
        System.out.println("Date after rounding >>" +DateUtils.round(date1, Calendar.HOUR));
        //Truncate the hour
        System.out.println("Date after truncation >>"+DateUtils.truncate(date1, Calendar.HOUR));
        //Three dates in three different formats
        String [] dates={"2005.03.24 11:03:26", "2005-03-24 11:03", "2005/03/24"};
        //Iterate over dates and parse strings to java.util.Date objects
        for(int i=0; i < dates.length; i++){
            Date parsedDate= DateUtils.parseDate(dates[i],
            new String []{"yyyy/MM/dd", "yyyy.MM.dd HH:mm:ss", "yyyy-MM-dd HH:mm"});
            System.out.println("Parsed Date is >>"+parsedDate);
        }

        //Display date in HH:mm:ss format
        System.out.println("Now >>"+DateFormatUtils.ISO_DATETIME_FORMAT.format(System.currentTimeMillis()));
    }
}
