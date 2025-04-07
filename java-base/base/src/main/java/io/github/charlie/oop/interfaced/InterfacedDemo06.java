package io.github.charlie.oop.interfaced;

/**
 * @Author: charlie-zhang-code
 * @Date: 2025/3/30
 * @Description: TODO
 */
interface USEDemo07 {
    void in();
    void out();

    // 默认方法
    default void reverse() {
        System.out.println("手机倒置");
    }

    // 静态方法
    static void reverse1() {
        System.out.println("手机倒置");
    }
}

class MobileHandset implements USEDemo07 {
    public void in() {
        System.out.println("手机充电");
    }

    public void out() {
        System.out.println("手机拔出");
    }
}

public class InterfacedDemo06 {
    public static void main(String[] args) {
        // 创建实现接口的对象
        MobileHandset mobileHandset = new MobileHandset();

        // 通过实现类对象调用重写的抽象方法，默认方法，静态方法，
        // 如果实现类重写就会调用实现类的方法，
        // 如果没有重写就会调用接口的默认方法，
        // 如果接口没有默认方法就会调用接口的静态方法
        mobileHandset.in();
        mobileHandset.out();

        // 通过接口名调用静态方法
        USEDemo07.reverse1();
    }
}
