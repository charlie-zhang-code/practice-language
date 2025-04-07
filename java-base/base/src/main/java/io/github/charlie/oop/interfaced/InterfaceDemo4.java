package io.github.charlie.oop.interfaced;

/**
 * @Author: charlie-zhang-code
 * @Date: 2025/3/30
 * @Description: TODO
 */
interface USBDemo04 {
    void in();
    void out();
}

class MouseDemo04 implements USBDemo04 {
    @Override
    public void in() {
        System.out.println("鼠标插入");
    }

    @Override
    public void out() {
        System.out.println("鼠标拔出");
    }
}

class KeyboardDemo04 implements USBDemo04 {
    @Override
    public void in() {
        System.out.println("键盘插入");
    }

    @Override
    public void out() {
        System.out.println("键盘拔出");
    }
}

public class InterfaceDemo4 {
    public static void main(String[] args) {
        USBDemo04 mouse = new MouseDemo04();
        mouse.in();
        mouse.out();
        mouse = new KeyboardDemo04();
        mouse.in();
        mouse.out();
    }
}
