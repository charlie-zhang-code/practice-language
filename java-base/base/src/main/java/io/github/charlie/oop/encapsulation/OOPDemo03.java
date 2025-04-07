package io.github.charlie.oop.encapsulation;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/14
 * @Description: 构造器
 */
public class OOPDemo03 {
    private String name;
    private int age;

    // 默认构造器，默认无参构造器
    public OOPDemo03() {
        this.name = "charlie";
        this.age = 18;
    }

    // 有参构造器
    public OOPDemo03(String name, int age) {
        this.name = name;
        this.age = age;
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


class OOPDemo03Test {
    public static void main(String[] args) {
        OOPDemo03 oopDemo03 = new OOPDemo03();
        System.out.println(oopDemo03.getAge());
        System.out.println(oopDemo03.getName());

        OOPDemo03 oopDemo03_1 = new OOPDemo03("charlieT", 120);
        System.out.println(oopDemo03_1.getAge());
        System.out.println(oopDemo03_1.getName());
    }
}