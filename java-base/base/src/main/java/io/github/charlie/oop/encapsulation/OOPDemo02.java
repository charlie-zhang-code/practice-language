package io.github.charlie.oop.encapsulation;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/14
 * @Description: 私有化方法
 */
public class OOPDemo02 {
    // 私有化成员变量
    private String name;

    // 私有化成员方法
    private void test() {
        System.out.println("test");
    }

    public static void main(String[] args) {
        OOPDemo02 oopDemo02 = new OOPDemo02();
        oopDemo02.test(); // 类内部，可以访问test方法
    }
}

class Test1 {
    public static void main(String[] args) {
        OOPDemo02 oopDemo02 = new OOPDemo02();
//        oopDemo02.test(); // 类外部，不可以访问test方法
    }
}
