package io.github.charlie.oop.encapsulation;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/13
 * @Description: 封装性的体现
 */
public class OOPDemo01 {
    private int age; // 私有化类的成员变量
    private String name; // 私有化类的成员变量

    // 提供外界访问类的成员变量的getter和setter方法
    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Test {
    public static void main(String[] args) {
        OOPDemo01 o = new OOPDemo01();
        // 访问类的成员变量
        int age = o.getAge();
        // o.age 访问不到，因为age是私有的
        String name = o.getName();
        o.setAge(18);
        o.setName("Charlie");
    }
}