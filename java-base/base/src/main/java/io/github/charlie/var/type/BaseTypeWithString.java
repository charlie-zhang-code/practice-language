package io.github.charlie.var.type;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/11
 * @Description: 基本类型与String
 */
public class BaseTypeWithString {
    public static void main(String[] args) {
        String str = "hello world";
        System.out.println(str);
        System.out.println("str");

        int num = 10;
        boolean flag = true;
        String str1 = "hello world-----";
        System.out.println(str1 + flag);
        System.out.println(str1 + num);

        // 只能连接，不能运算
//        System.out.println(str1 + num - 3);

        // 不能编译通过
//        String str2 = flag + num;

//        String转换成基本类型
        String str2 = "123";
        int num1 = Integer.parseInt(str2);
    }
}

