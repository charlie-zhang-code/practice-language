package io.github.charlie.oop.interfaced;

/**
 * @Author: charlie-zhang-code
 * @Date: 2025/3/30
 * @Description: TODO
 */
class SuperClass {
    int x = 1;
}

interface SuperInterface {
    int x = 2;
    int y = 2;
}

interface MotherInterface {
    int x = 4;
}

public class InterfaceDemo09 extends SuperClass implements SuperInterface, MotherInterface {
    public void method() {
//        System.out.println(x); // 模糊不清
        System.out.println(super.x); // 1
        System.out.println(SuperInterface.x); // 2
        System.out.println(MotherInterface.x); // 4
        System.out.println(y); // 没有重名，可以直接访问
    }

    public static void main(String[] args) {
        InterfaceDemo09 demo = new InterfaceDemo09();
        demo.method();
    }
}
