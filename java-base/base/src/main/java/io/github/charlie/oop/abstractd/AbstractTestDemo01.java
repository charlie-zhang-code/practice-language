package io.github.charlie.oop.abstractd;

/**
 * @Author: charlie-zhang-code
 * @Date: 2025/3/17
 */
public class AbstractTestDemo01 {
    public static void main(String[] args) {
        Animal cat = new Cat();
        cat.eat();
    }
}

abstract class Animal {
    public abstract void eat();
}

class Cat extends Animal {
    @Override
    public void eat() {
        System.out.println("Cat eat");
    }
}