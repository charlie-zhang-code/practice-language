package io.github.charlie.oop.method.vars;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/11
 * @Description: 可变个数形参示例类
 */
public class Demo01 {
    public void method(String... args) {
        for (String arg : args) {
            System.out.println(arg);
        }
    }

    public void method1(String arg1, String arg2, String arg3) {
        System.out.println(arg1);
        System.out.println(arg2);
        System.out.println(arg3);
    }

    public static void main(String[] args) {
        Demo01 demo01 = new Demo01();
        demo01.method("a", "b", "c");
        demo01.method("a", "b");
        demo01.method("a");
        demo01.method();

        demo01.method1("a", "b", "c");
    }
}
