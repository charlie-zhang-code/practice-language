package io.github.charlie.clazz;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/7
 * @Description: TODO
 */
public class Father {
    // 字段
    String name;
    int age;

    // 构造器
    public Father(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 方法
    public void sayHello() {
        System.out.println("Hello, " + name);
    }
}

class Son extends Father {
    // 构造器
    public Son(String name, int age) {
        super(name, age);
    }

    // 方法（继承自父类，所以可以不用再写一遍）
//    public void sayHello() {
//        System.out.println("Hello, " + name);
//    }
}