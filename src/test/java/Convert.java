/**
 * @author bing.wang
 * @date 2020/12/8 16:58
 */

@FunctionalInterface
interface Convert<F,T> {
    T convert(F f);
}
