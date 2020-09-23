package wb.base;

/**
 * @author bing.wang
 * @date 2020/9/22 15:47
 */
public class EnumTest {
    public static void main(String[] args) {
        for (WbEnum e: WbEnum.values()) {
            System.out.println(e+"-"+e.ordinal()+"-"+e.valueOf(e.name()));
        }

        System.out.println(WbEnum.WANGB);
    }
}
