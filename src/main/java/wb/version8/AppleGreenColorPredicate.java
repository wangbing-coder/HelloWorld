package wb.version8;

import wb.module.Apple;

/**
 * @author bing.wang
 * @date 2020/9/10 13:29
 */
public class AppleGreenColorPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        if(apple.getWeight() > 150){
            return true;
        }
        return false;
    }
}
