package io.github.charlie.oop.interfaced;

/**
 * @Author: charlie-zhang-code
 * @Date: 2025/3/30
 * @Description: TODO
 */
interface Friend {
    default void date() {
        System.out.println("date with friend");
    }
}

class Father {
    public void date() {
        System.out.println("date with father");
    }
}

class Son extends Father implements Friend {
    @Override
    public void date() {
        // 不重写默认调用父类的date方法

        // 调用父类被重写的date方法
        // super.date();

        // 保留父类date方法
        // Friend.super.date();

        // 完全重写
//        System.out.println("date with son");
    }
}

public class InterfaceDemo07 {
    public static void main(String[] args) {
        Son son = new Son();
        son.date();
    }
}
