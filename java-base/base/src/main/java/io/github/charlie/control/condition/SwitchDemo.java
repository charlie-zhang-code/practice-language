package io.github.charlie.control.condition;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/7
 * @Description: TODO
 */
public class SwitchDemo {
    public static void main(String[] args) {
        int a = 10;
        switch (a) {
            case 1:
                System.out.println("a == 1");
                break;
            case 2:
                System.out.println("a == 2");
                break;
            case 3:
                System.out.println("a == 3");
                break;
            default:
                System.out.println("a == 4");
        }
    }
}
