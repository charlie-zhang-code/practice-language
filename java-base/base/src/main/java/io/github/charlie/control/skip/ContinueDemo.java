package io.github.charlie.control.skip;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/7
 * @Description: TODO
 */
public class ContinueDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                continue;
            }
            System.out.println("i = " + i);
        }
    }
}
