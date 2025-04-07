package io.github.charlie.oop.inheritance;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/14
 * @Description: 方法的重写
 */
public class OOPDemo03 {
    public static void main(String[] args) {
        Person2 person = new Person2();
        person.setName("Charlie");
        person.setAge(18);
        int age = person.getAge();
        String name = person.getName();
        System.out.println(name);
        System.out.println(age);

        Student2 student = new Student2();
        student.setName("Charlie");
        student.setAge(18);
        System.out.println(student.getName());
        System.out.println(student.getAge());
    }
}

class Person2 {
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

class Student2 extends Person2 {
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        // 重写方法，不设置学生名字为固定
    }
}


