package io.github.charlie.oop.inheritance;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/14
 * @Description: 继承自下而上
 */
public class OOPDemo02 {
    public static void main(String[] args) {
        Person1 person = new Person1();
        person.setName("Charlie");
        person.setAge(18);
        System.out.println(person.getName());
        System.out.println(person.getAge());

        Student1 student = new Student1();
        student.setName("Charlie");
        student.setAge(18);
        System.out.println(student.getName());
        System.out.println(student.getAge());

        Teacher1 teacher = new Teacher1();
        teacher.setName("Charlie");
        teacher.setAge(18);
        System.out.println(teacher.getName());
        System.out.println(teacher.getAge());
    }
}

class Teacher1 extends Person1 {
    //    private String name;
//    private int age;
    private int year;

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
}


class Student1 extends Person1 {
    //    private String name;
//    private int age;
    private int score;

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
}

// 抽取出学生和教师类的公共属性
class Person1 {
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