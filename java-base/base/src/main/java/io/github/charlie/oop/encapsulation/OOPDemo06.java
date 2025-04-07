package io.github.charlie.oop.encapsulation;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/14
 * @Description: TODO
 */
public class OOPDemo06 {
    private String name;
    private int age;

    // 构造器一
    public OOPDemo06(String name) {
        this.name = name;
    }

    // 构造器二
    public OOPDemo06(String name, int age) {
        this(name); // 调用构造器一
        this.age = age;
    }

    // 构造器三
    public OOPDemo06() {
        this("Charlie Zhang"); // 调用构造器二
    }
}
