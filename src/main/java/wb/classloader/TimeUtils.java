package wb.classloader;

import com.sun.xml.internal.ws.util.StringUtils;
import oracle.sql.BINARY_DOUBLE;
import org.junit.Test;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Optional;


/**
 * @author bing.wang
 * @date 2020/8/17 16:58
 */
public class TimeUtils {

    @Test
    public void decimalTest(){
        Object f = 1.223413f;



        BigDecimal decimal1 = new BigDecimal(String.valueOf(f));
        System.out.println(decimal1.toString().split("\\.")[1].length());


        BigDecimal decimal = BigDecimal.valueOf(((Float) f).doubleValue());

        //kafka
        /*byte[] bytes = decimal.unscaledValue().toByteArray();
        BigDecimal decimal1 = new BigDecimal(new BigInteger(bytes), 1);
        System.out.println(decimal1);*/

        //dbz
        System.out.println(Optional.ofNullable(decimal).isPresent());
        System.out.println(Optional.ofNullable(decimal).get().doubleValue());
        System.out.println(decimal);

        System.out.println(decimal instanceof BigDecimal);

    }

    @Test
    public void test1(){

        Object x = 1768.6868;

        Double aDouble = Double.valueOf(x.toString());
        System.out.println(aDouble);




        /*int size = 0;
        String s = "0";
        String value = x.toString();

        int len = value.split("\\.").length;
        if (len != 1) {
            size = value.split("\\.")[1].length();
        }

        for (int i = size; i < 38; i++) {
            value = value + s;
        }

        System.out.println(value);

        byte[] bytes = new BigDecimal(value).unscaledValue().toByteArray();


        //BigDecimal decimal1 = new BigDecimal(s.toCharArray(), 1, 3);

        BigDecimal decimal = new BigDecimal(new BigInteger(bytes),38);

        System.out.println(decimal.toPlainString());*/

    }
}
