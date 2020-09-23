package wb.version8;

import wb.module.Apple;

/**
 * @author bing.wang
 * @date 2020/9/10 13:27
 *
 * 策略模式：不同的行为有不同的实现类
 */
public interface ApplePredicate {
    boolean test(Apple apple);
}
