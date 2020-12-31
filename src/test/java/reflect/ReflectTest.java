package reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @author bing.wang
 * @date 2020/12/16 18:00
 */
public class ReflectTest {

    //获取Class实例的三种方式
    @Test
    public void test1() throws Exception{
        Student student = new Student();
        Class<? extends Student> aClass = student.getClass();

        Class<Student> studentClass = Student.class;

        Class<?> forName = Class.forName("reflect.Student");

        System.out.println(aClass==studentClass);
    }

    /**
     * 1 批量获取构造方法
     *      getConstructors
     *      getDeclaredConstructors
     * 2 获取单个构造方法
     *      getConstructor
     *      getDeclaredConstructor
     */
    @Test
    public void test2() throws Exception{
        Class<?> aClass = Class.forName("reflect.Student");

        Constructor<?>[] constructors = aClass.getConstructors();
        for (Constructor c:constructors ) {
            System.out.println(c);
        }
    }

    @Test
    public void test3() throws Exception{
        Class<?> aClass = Class.forName("reflect.Student");

        Constructor<?>[] constructors = aClass.getDeclaredConstructors();
        for (Constructor c:constructors ) {
            System.out.println(c);
        }
    }

    @Test
    public void test4()throws Exception{
        Class<?> aClass = Class.forName("reflect.Student");

        Constructor constructors = aClass.getConstructor(null);
        System.out.println(constructors);

        Object o = constructors.newInstance();
        Student o1 = (Student) o;
    }

    @Test
    public void test5()throws Exception{
        Class<?> aClass = Class.forName("reflect.Student");

        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(int.class);
        declaredConstructor.setAccessible(true);
        Object a = declaredConstructor.newInstance(11);
        Student s = (Student) a;
        int age = s.getAge();
        System.out.println(age);
    }

}

class Student{
    //默认
    Student(String s){
        System.out.println(s);
    }

    Student(){
        System.out.println("无参数");
    }

    Student(char name){
        System.out.println(name);
    }

    Student(String name,int age){
        System.out.println(name+":"+age);
    }

    protected Student(boolean b){
        System.out.println("protected=="+b);
    }

    private Student(int age){
        this.age = age;
    }


    /**
     *
     */
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
