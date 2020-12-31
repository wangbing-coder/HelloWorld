package classloder;

import module.Man;
import org.junit.Test;

import java.io.File;
import java.util.StringTokenizer;

/**
 * @author bing.wang
 * @date 2020/12/25 14:38
 */
public class classLoderTest {

    @Test
    public void test1() throws Exception{
        /*ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(contextClassLoader);*/

        //Class<?> aClass = this.getClass().getClassLoader().loadClass("");

        String property = System.getProperty("java.ext.dirs");
        StringTokenizer stringTokenizer = new StringTokenizer(property, File.pathSeparator);

        /*System.out.println(stringTokenizer.countTokens());
        System.out.println(stringTokenizer);*/


        ClassLoader current = Thread.currentThread().getContextClassLoader();
        System.out.println(current);

        ClassLoader classLoader = classLoderTest.class.getClassLoader();
        System.out.println(classLoader);
    }

    @Test
    public void test2() throws Exception{
        Man man = new Man(1,"aa");
        test3(man);
        System.out.println(man.getAge());

    }

    public static void test3(Man man){
        System.out.println(man.getAge());
        man.setAge(1111);
    }
}
