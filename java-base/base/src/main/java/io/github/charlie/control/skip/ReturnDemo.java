package io.github.charlie.control.skip;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/7
 * @Description: TODO
 */
public class ReturnDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                return;
            }
            System.out.println("i = " + i);
        }
    }
}
