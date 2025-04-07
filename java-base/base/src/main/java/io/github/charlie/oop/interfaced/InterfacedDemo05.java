package io.github.charlie.oop.interfaced;

/**
 * @Author: charlie-zhang-code
 * @Date: 2025/3/30
 * @Description: TODO
 */
interface USBDemo05 {
    Long MAX_SIZE = 1024L;

    // 静态方法
    static void reverse() {
        System.out.println("reverse");
    }
}

public class InterfacedDemo05 {
    public static void main(String[] args) {
        // 通过接口名调用静态方法
        USBDemo05.reverse();

        // 通过接口名调用常量
        System.out.println(USBDemo05.MAX_SIZE);
    }
}
