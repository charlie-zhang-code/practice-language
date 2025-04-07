package io.github.charlie.oop.method.override;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/11
 * @Description: 方法重载示例类
 */
public class Demo01 {
    public static void main(String[] args) {
        // 创建对象
        Person person = new Person();
        // 调用方法
        person.eat("苹果");
        person.eat("苹果", "香蕉");
        person.eat("苹果", "香蕉", "橙子");
    }
}

class Person {
    public void eat(String food) {
        System.out.println("吃" + food);
    }

    public void eat(String food1, String food2) {
        System.out.println("吃" + food1 + "和" + food2);
    }

    public void eat(String food1, String food2, String food3) {
        System.out.println("吃" + food1 + "、" + food2 + "和" + food3);
    }
}
