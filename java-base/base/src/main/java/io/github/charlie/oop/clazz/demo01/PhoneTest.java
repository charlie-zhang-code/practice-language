package io.github.charlie.oop.clazz.demo01;

import org.junit.Test;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/11
 * @Description: PhoneDemo类的测试类
 */
public class PhoneTest {
    public static void main(String[] args) {
        // 创建Phone对象
        PhoneDemo phoneDemo = new PhoneDemo();

        // 通过对象，调用内部声明的属性或方法
        // 格式 对象.属性 或 对象.方法()
        phoneDemo.brand = "iPhone";
        phoneDemo.price = 9999.99;
        System.out.println("brand = " + phoneDemo.brand + ", price = " + phoneDemo.price);

        // 调用方法
        phoneDemo.call();

        // 再创建实例
        PhoneDemo phoneDemo2 = new PhoneDemo();
    }

    @Test
    public void test() {
        // 匿名对象
        new PhoneDemo().call();
    }
}
