package wb.collector;

import org.junit.Test;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author bing.wang
 * @date 2020/9/15 15:29
 */
public class LinkedHashMapTest {

    @Test
    public void testLinked(){
        LinkedHashMap<String,String> map = new LinkedHashMap();
        map.put("1","1");
        map.put("2","2");
        map.put("3","3");
        map.put("4","4");

        for (String s:map.keySet()) {
            if(s.equals("3")){
            }
        }
    }

    @Test
    public void test(){
        String s = "";

        String[] split = s.toLowerCase().split("\\,");

        List<String> strings = Arrays.asList(split);

        boolean a = strings.contains("a");

        System.out.println(strings.isEmpty());


    }
}
