package timetype;

import org.junit.Test;

import java.math.BigInteger;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

/**
 * @author bing.wang
 * @date 2020/9/17 11:14
 */
public class bigintToTimestamp {

    @Test
    public void test() throws Exception{

        BigInteger bigInteger = new BigInteger("1600313029000");

        Long l = 1600313029000L;
        Instant instant = Instant.ofEpochMilli(l);
        System.out.println(instant);

       /* java.util.Date from = Date.from(instant);
        System.out.println(from);*/



        ZonedDateTime ctt = instant.atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(ctt);

       /* SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        sdf.setTimeZone(timeZone);
        java.util.Date parse = sdf.parse(instant.toString().replace("T"," ").replace("Z",""));

        System.out.println(parse);*/
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


}

