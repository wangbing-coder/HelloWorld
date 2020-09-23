package version8;

import org.junit.Test;
import wb.module.Apple;
import wb.version8.AppleProcessor;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static java.util.stream.Collectors.toList;

/**
 * @author bing.wang
 * @date 2020/9/10 23:11
 */
public class LambdaTest {


    /**
     * 常用函数式接口
     */
    @Test
    public void testInterface(){
        List<Apple> apples = Arrays.asList(new Apple("green", 160), new Apple("red", 150));

        /**
         * boolean test(T t);
         */
        Predicate<String> pr = (String s) -> s.equals("green");
        for (Apple apple: apples){
            if(pr.test(apple.getColor())){
                System.out.println(apple.getColor()+"==="+apple.getWeight());
            }
        }

        /**
         * void accept(T t);
         */
        Consumer<String> cs = (String s) -> System.out.println(s);
        for (Apple apple: apples) {
            cs.accept(apple.getColor());
        }

        /**
         *R apply(T t);
         */
        Function<String,Integer> ft = (String s) -> s.length();

        for (Apple apple: apples) {
            Integer apply = ft.apply(apple.getColor());
            System.out.println(apply);
        }

        /**
         * T get();
         */
        Supplier<Apple> sl = () -> new Apple("yellow",130);

        Apple apple1 = sl.get();
        System.out.println(apple1.getColor()+"==="+apple1.getWeight());



    }


    @Test
    public void testProcess(){
        //lambda
        String color = process((Apple apple)-> apple.getColor());
        System.out.println(color);

    }

    public String process(AppleProcessor ap){
        Apple apple = new Apple("green", 160);
        return ap.appleProcessor(apple);
    }


    @Test
    public void testStream(){


        List<Apple> apples = Arrays.asList(
                new Apple("green", 160)
                ,new Apple("red", 170)
                ,new Apple("yellow", 130)
                ,new Apple("white", 140));

        //apples.stream().sorted(comparing(Apple::getWeight).reversed()).forEach(System.out::println);
        //apples.stream().map(Apple::getColor).forEach(System.out::println);

        //apples.stream().filter(a -> a.getWeight() > 140).forEach(System.out::println);


        List<Integer> integers = Arrays.asList(1, 2, 4, 2, 4, 2, 3, 1);

        integers.stream().filter(x -> x % 2 == 0).distinct().forEach(System.out::println);


        List<Integer> numbers1 = Arrays.asList(1, 2, 3);

        List<Integer> numbers2 = Arrays.asList(3, 4);

        List<int[]> pairs =
                numbers1.stream()
                        .flatMap(i -> numbers2.stream()
                                .map(j -> new int[]{i, j})

                        ).collect(toList());

    }


    public static <T> void copy(List<? super T> dest, List<? extends T> src) {
        for (int i = 0; i < src.size(); i++){
            dest.set(i, src.get(i));
        }
    }


}
