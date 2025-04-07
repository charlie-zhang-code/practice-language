package io.github.charlie.clazz;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/27
 * @Description: getClass测试
 */
class Person {
    private String name;
    private int age;

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

public class ObjectClass {
    public static void main(String[] args) {
        Object obj = new Person();
        System.out.println(obj.getClass());
    }
}
