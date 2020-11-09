import org.junit.Test;

import java.util.*;

/**
 * @author bing.wang
 * @date 2020/8/30 00:07
 */
public class EqualsTest {
    @Test
    public void eqTest(){
        Integer a = 1;
        Integer b = 1;

        System.out.println(a.equals(b));
    }

    @Test
    public void convertStringMap(){
        HashMap<String, String> colmap = new HashMap<>();
        String s = "a:a1,b:b1,c:c1";
        List<String> strings = Arrays.asList(s.split(","));
        for (String cols:strings){
            String[] col = cols.split(":");
            colmap.put(col[0],col[1]);
        }


        Set<String> set = colmap.keySet();
        for(String str:colmap.keySet()){
            String s1 = colmap.get("a") == null ? colmap.get(str) : "hello";
            System.out.println(s1);
        }

        //System.out.println(colmap.get("1") == null);


    }

    @Test
    public void test(){
        String s = "abc d";

        boolean equals = s.equals("");
        System.out.println(equals);

        boolean empty = s.isEmpty();
        System.out.println(empty);

        System.out.println(s.length());

        char[] chars = s.toCharArray();
        for(char c :chars){
            System.out.println(c);
        }
    }
}
