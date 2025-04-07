package io.github.charlie.var.convert;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/11
 * @Description: 强制类型转换
 */
public class Manual {
    public static void main(String[] args) {
        double d = 50; // 自动类型转换（自动提升）

        int i = (int) d; // 强制类型转换
        System.out.println(i);
    }
}
