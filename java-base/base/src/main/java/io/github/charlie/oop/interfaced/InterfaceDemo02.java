package io.github.charlie.oop.interfaced;

/**
 * @Author: charlie-zhang-code
 * @Date: 2025/3/17
 * @Description: 接口使用示例
 */
public class InterfaceDemo02 {
    public static void main(String[] args) {
        Computer.show(new Flash());
        Computer.show(new Print());

        Computer.show(new USBE3() {
            @Override
            public void start() {
                System.out.println("USBE3 start");
            }

            @Override
            public void stop() {
                System.out.println("USBE3 stop");
            }
        });
    }
}

interface USBE3 {
    public void start(); // 默认是public abstract
    public void stop();
}

class Computer {
    public static void show(USBE3 usbe3) {
        usbe3.start();
        System.out.println("USBE3");
        usbe3.stop();
    }
}

class Flash implements USBE3 {
    @Override
    public void start() {
        System.out.println("Flash start");
    }

    @Override
    public void stop() {
        System.out.println("Flash stop");
    }
}

class Print implements USBE3 {

    @Override
    public void start() {
        System.out.println("Print start");
    }

    @Override
    public void stop() {
        System.out.println("Print stop");
    }
}
