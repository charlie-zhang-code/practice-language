package io.github.charlie.oop.interfaced;

/**
 * @Author: charlie-zhang-code
 * @Date: 2025/3/30
 * @Description: TODO
 */
interface Friend01 {
    default void date() {
        System.out.println("date with friend");
    }
}

interface BoyFriend {
    default void date() {
        System.out.println("date with boy friend");
    }
}

class Girl implements Friend01, BoyFriend {
    public void date() {
        // 保留其中一个接口的date方法
//        Friend01.super.date();
//        BoyFriend.super.date();

        // 完全重写
        System.out.println("date with girl");
    }
}

public class InterfaceDemo08 {
    public static void main(String[] args) {
        Girl girl = new Girl();
        girl.date();
    }
}
