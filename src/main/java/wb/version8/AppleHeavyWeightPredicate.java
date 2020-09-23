package wb.version8;

import wb.module.Apple;

/**
 * @author bing.wang
 * @date 2020/9/10 13:31
 */
public class AppleHeavyWeightPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        if(apple.getColor().equals("green")){
            return true;
        }
        return false;
    }
}
