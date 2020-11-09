package wb.base;

import org.junit.Test;
import wb.module.Apple;
import wb.module.Person;

import java.util.Optional;

/**
 * @author bing.wang
 * @date 2020/9/27 22:51
 */
public class optionalTest {

    @Test
    public void testOptional(){
        //空对象
        Optional<Person> optional = Optional.empty();

        //依据非空值创造一个对象
        Person p = null;
        //Optional<Person> p1 = Optional.of(p);

        //可接受空值创造一个对象
        Apple a = null;
        Optional<Apple> a1 = Optional.ofNullable(a);


    }
}
