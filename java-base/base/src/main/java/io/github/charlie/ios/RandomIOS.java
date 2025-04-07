package io.github.charlie.ios;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/11
 * @Description: 随机数
 */
public class RandomIOS {
    public static void main(String[] args) {
        double random = Math.random();
        System.out.println(random);

        // 获取[0, 100]范围的随机整数
        int num = (int) (Math.random() * 101);
        System.out.println(num);

        // 获取[1, 100]范围的随机整数
        int num1 = (int) (Math.random() * 100) + 1;
        System.out.println(num1);

        // 如何获取[a, b]范围的随机整数
        // (int)(Math.random() * (b - a + 1)) + a;
    }
}
