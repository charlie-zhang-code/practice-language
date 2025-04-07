package io.github.charlie.oop.interfaced;

/**
 * @Author: charlie-zhang-code
 * @Date: 2025/3/17
 * @Description: 接口示例
 */
public class InterfaceDemo01 {

}

interface USB3 {
    // 静态常量
    long MAX_SPEED = 5000;

    // 抽象方法
    void connect();
    void disconnect();

    // 默认方法
    default void test() {
        System.out.println("test");
    }

    // 静态方法
    static void test2() {
        System.out.println("test2");
    }
}
