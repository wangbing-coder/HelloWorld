package module;

/**
 * @author bing.wang
 * @date 2020/12/29 16:07
 */
public class Man {
    private Integer age;
    private String name;

    public Man(Integer age, String name){
        this.age=age;
        this.name=name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
