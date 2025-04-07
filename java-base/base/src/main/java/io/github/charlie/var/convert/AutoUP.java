package io.github.charlie.var.convert;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/11
 * @Description: 自动提升数据类型
 */
public class AutoUP {
    public static void main(String[] args) {
        byte b = 1;
        short s = b;
        int s1 = b + s;
    }
}
