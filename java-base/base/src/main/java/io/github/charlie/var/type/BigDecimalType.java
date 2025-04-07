package io.github.charlie.var.type;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/11
 * @Description: BigDecimal 类型 精度丢失问题
 */
public class BigDecimalType {
    public static void main(String[] args) {
        System.out.println(0.1 + 0.2);

        float ff1 = 123123456f;
        float ff2 = ff1 + 1;
        System.out.println(ff1);
        System.out.println(ff2);
        System.out.println(ff1 == ff2);
    }
}
