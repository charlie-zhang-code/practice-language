package io.github.charlie.oop.clazz.demo01;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/11
 * @Description: 类的示例
 */
public class PhoneDemo {
    // 属性
    String brand; // 品牌
    double price; // 价格

    // 方法
    public void call() {
        System.out.println("打电话");
    }

    public void sendMessage(String message) {
        System.out.println("发短信：" + message);
    }

    public void playGame() {
        System.out.println("玩游戏");
    }
}
