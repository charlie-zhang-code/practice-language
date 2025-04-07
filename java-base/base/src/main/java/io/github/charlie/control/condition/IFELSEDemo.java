package io.github.charlie.control.condition;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/7
 * @Description: TODO
 */
public class IFELSEDemo {
    public static void main(String[] args) {
        int a = 10;
        if (a > 5) {
            System.out.println("a > 5");
        } else {
            System.out.println("a <= 5");
        }

        if (a < 5) {
            System.out.println("a < 5");
        } else {
            System.out.println("a >= 5");
        }

        if (a == 5) {
            System.out.println("a == 5");
        } else {
            System.out.println("a != 5");
        }
    }
}
