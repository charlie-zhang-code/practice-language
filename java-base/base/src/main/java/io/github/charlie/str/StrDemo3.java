package io.github.charlie.str;

import java.io.UnsupportedEncodingException;

/**
 * @Author: charlie-zhang-code
 * @Date: 2025/4/4
 * @Description: TODO
 */
public class StrDemo3 {
    //字面量定义方式：字符串常量对象
    String str = "hello";
    //构造器定义方式：无参构造
    String str1 = new String();
    //构造器定义方式：创建"hello"字符串常量的副本
    String str2 = new String("hello");
    //构造器定义方式：通过字符数组构造
    char chars[] = {'a', 'b', 'c', 'd', 'e'};
    String str3 = new String(chars);
    String str4 = new String(chars, 0, 3);
    //构造器定义方式：通过字节数组构造
    byte bytes[] = {97, 98, 99};
    String str5 = new String(bytes);
    String str6 = new String(bytes, "GBK");

    public StrDemo3() throws UnsupportedEncodingException {
    }

    public static void main(String[] args) {
        char[] data = {'h', 'e', 'l', 'l', 'o', 'j', 'a', 'v', 'a'};
        String s1 = String.copyValueOf(data);
        String s2 = String.copyValueOf(data, 0, 5);
        int num = 123456;
        String s3 = String.valueOf(num);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
