package io.github.charlie.oop.inheritance;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/14
 * @Description: 继承自上而下
 */
public class OOPDemo01 {
    public static void main(String[] args) {
        Student student = new Student();
        int age = student.getAge();
        String name = student.getName();
    }
}


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

class Student extends Person {
    // 继承了Person类，所以Student类可以访问Person类的属性和方法
    private String school;
}

