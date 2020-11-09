package timetype;

import org.junit.Test;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author bing.wang
 * @date 2020/9/17 11:14
 */
public class bigintToTimestamp {

    @Test
    public void test() throws Exception{

        Long l = 1601259181000L;
        Instant instant = Instant.ofEpochMilli(l);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        //TimeZone timeZone = TimeZone.getTimeZone("CST-8");
        sdf.setTimeZone(timeZone);
        Date date = sdf.parse(instant.toString().replace("T", " ").replace("Z", ""));

        System.out.println(date);

        System.out.println(new Date().getClass());

    }

    @Test
    public void testBytes(){
        String o = "abc";
        byte[] bytes = o.getBytes();
        for (int i = 0; i < bytes.length ; i++) {
            System.out.println(bytes[i]);
        }

        String s = new String(bytes);
        System.out.println(s);
    }

    @Test
    public void test1(){
        int i = 1;
    }

    @Test
    public void test2(){
        String value = "1970-01-01T00:00:01Z";


        TimeZone timeZone = TimeZone.getTimeZone("GMT-8");

        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        sdf.setTimeZone(timeZone);
        Date date = null;
        try {
            date = sdf.parse(value);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(date);
    }

    @Test
    public void test3(){
        Integer integer = new Integer(1);
        Integer integer1 = new Integer(1);

        System.out.println(new Integer(1).getClass());

        System.out.println(integer.equals(integer1));
        System.out.println(integer==integer1);

        if(integer==integer1 || integer.equals(integer1)){
            System.out.println(1);
        }
    }

    @Test
    public void test4() throws Exception{
        String s = "2020-10-15T09:37:34Z";
        long l = 1602689740000L;

        Instant parse = Instant.parse(s);
        System.out.println(parse);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        TimeZone gmt = TimeZone.getTimeZone("GMT");
        sdf.setTimeZone(gmt);
        Date date = sdf.parse(s);
        System.out.println(date);
    }

    //java.time.duration
    @Test
    public  void test5()throws Exception{
        String s = "PT15H35M38S";
        Duration parse = Duration.parse(s);
        long l = parse.toMillis();
        System.out.println(l);

        Date date = new Date(l);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        String format = simpleDateFormat.format(date);
        System.out.println(format);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        Date parse1 = sdf.parse(format);
        System.out.println(parse1);
    }

    @Test
    public  void test6()throws Exception{
        String s = "17:39:15";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        //simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        Date parse = simpleDateFormat.parse(s);
        System.out.println(parse);
    }

    @Test
    public void test7(){
        String s = "1";

        if(s==null){
            System.out.println("1");
        }else if(true){
            if("1".equals(s)){
                System.out.println(2);
            }
        }else if(true) {
            System.out.println(3);
        }else if(true){
            System.out.println(4);
        }
    }

}

