package io.github.charlie.oop.clazz.demo02;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/11
 * @Description: PersonDemo 测试类
 */
public class PersonDemoTest {
    public static void main(String[] args) {
        PersonDemo p1 = new PersonDemo();
        p1.name = "Charlie Zhang 01";
        p1.age = 18;

        PersonDemo p2 = new PersonDemo();
        p2.name = "Charlie Zhang 02";
        p2.age = 19;

        System.out.println(p1);
        System.out.println(p2);
    }
}
