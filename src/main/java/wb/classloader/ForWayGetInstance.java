package wb.classloader;


import org.junit.Test;
import wb.module.Person;

import java.lang.annotation.ElementType;

/**
 * @author bing.wang
 * @date 2020/7/28 20:53
 */
public class ForWayGetInstance {

    /**
     * 获取运行时 Class 实例的四种方式
     */
    @Test
    public void getInstance() throws Exception{
        //运行时类的属性：.class
        Class<Person> personClass = Person.class;
        System.out.println(personClass);

        //通过运行时类的对象调用 getClass 方法
        Person person = new Person();
        Class<? extends Person> objectClass = person.getClass();
        System.out.println(objectClass);

        //调用 Class 的静态方法 forName（String classPath）「最常用的一种」
        Class<?> forNameClass = Class.forName("wb.module.Person");
        System.out.println(forNameClass);

        //使用类的加载器「了解」
        ClassLoader classLoader = ForWayGetInstance.class.getClassLoader();
        Class<?> loadClass = classLoader.loadClass("wb.module.Person");
        System.out.println(loadClass);
    }

    /**
     * Class 实例可以是哪些结构
     *
     * 对象可以有多个对象，但是结构只能有一个结构
     */
    @Test
    public void structInstance(){
        Class<Object> objectClass = Object.class;
        Class<Comparable> comparableClass = Comparable.class;
        Class<String[]> aClass = String[].class;
        Class<int[][]> aClass1 = int[][].class;
        Class<ElementType> elementTypeClass = ElementType.class;
        Class<Override> overrideClass = Override.class;
        Class<Integer> integerClass = int.class;
        Class<Void> voidClass = void.class;
        Class<Class> classClass = Class.class;

        int[] ints = new int[10];
        int[] ints1 = new int[100];
        //只要元素和数据类型一致，那就一样
        System.out.println(ints.getClass()==ints1.getClass());
    }

}
