package io.github.charlie.oop.method.recursive;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/11
 * @Description: 递归方法示例类
 */
public class Demo01 {
    public static void main(String[] args) {
        // 测试直接递归
        for (int i = 0; i < 5; i++) {
            System.out.println(i + "! = " + factorial(i));
        }

        // 测试间接递归
        for (int i = 0; i < 5; i++) {
            System.out.println(i + " is odd? " + isOdd(i));
            System.out.println(i + " is even? " + isEven(i));
        }
    }

    // 直接递归
    public static int factorial(int n) {
        if (n <= 0) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    // 间接递归
    public static boolean isOdd(int n) {
        if (n == 0) {
            return false;
        } else {
            return isEven(n - 1);
        }
    }

    public static boolean isEven(int n) {
        if (n == 0) {
            return true;
        } else {
            return isOdd(n - 1);
        }
    }
}
