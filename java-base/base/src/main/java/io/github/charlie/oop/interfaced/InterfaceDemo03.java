package io.github.charlie.oop.interfaced;

/**
 * @Author: charlie-zhang-code
 * @Date: 2025/3/30
 * @Description: 接口继承demo
 */
interface ChargeableDemo03 {
    void charge();
    void in();
    void out();
}

interface USB33 {
    void charge();
    void in1();
    void out1();
}

interface UsbC extends ChargeableDemo03, USB33 {
   void reverse();
}

public class InterfaceDemo03 implements UsbC {
    @Override
    public void reverse() {

    }

    @Override
    public void charge() {

    }

    @Override
    public void in1() {

    }

    @Override
    public void out1() {

    }

    @Override
    public void in() {

    }

    @Override
    public void out() {

    }
}

