package version8;

import org.junit.Test;
import wb.module.Apple;
import wb.version8.ApplePredicate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bing.wang
 * @date 2020/9/10 13:38
 */
public class PredicateTest {

    @Test
    public void predicate1(List<Apple> inventory, ApplePredicate predicate){
        List<Apple> list = new ArrayList<>();
        for(Apple apple: inventory){
            if(predicate.test(apple)){
                list.add(apple);
            }
        }
    }


}
