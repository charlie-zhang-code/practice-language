package io.github.charlie.var;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/7
 * @Description: 局部变量
 */
public class VariablesDemo03 {
    // 实例变量
    private int instanceVar;

    // 一个包含局部变量的方法
    public void method01() {
        // 局部变量，只在这个方法内有效
        int localVar = 10;
        System.out.println("局部变量的值是: " + localVar);

        // 可以有多个局部变量
        String message = "Hello, World!";
        System.out.println(message);

        // 调用另一个带有局部变量的方法
        method02();
    }

    // 另一个包含局部变量的方法
    public void method02() {
        // 局部变量，只在这个方法内有效
        double pi = 3.14159;
        System.out.println("pi的值是: " + pi);
    }
}

class VariablesDemo03Test {
    public static void main(String[] args) {
        VariablesDemo03 var = new VariablesDemo03();

        // 调用含有局部变量的方法
        var.method01();
    }
}
