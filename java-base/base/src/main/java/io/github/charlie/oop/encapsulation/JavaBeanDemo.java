package io.github.charlie.oop.encapsulation;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/14
 * @Description: javabean
 */
public class JavaBeanDemo {
    private String name;

    private int age;

    public JavaBeanDemo() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
