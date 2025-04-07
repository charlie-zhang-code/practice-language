package io.github.charlie.str;

/**
 * @Author: charlie-zhang-code
 * @Date: 2025/4/4
 * @Description: TODO
 */
public class StrDemo2 {
    public static void main(String[] args) {
//        String s1 = "hello";
//        String s2 = "world";
//        String s3 = "helloworld";
//
//        String s4 = s1 + "world";//s4 字符串内容也 helloworld，s1 是变量，"world"常量，变量 + 常量的结果在堆中
//        String s5 = s1 + s2;//s5 字符串内容也 helloworld，s1 和 s2 都是变量，变量 + 变量的结果在堆中
//        String s6 = "hello" + "world";//常量+ 常量 结果在常量池中，因为编译期间就可以确定结果
//        System.out.println(s3 == s4);//false
//        System.out.println(s3 == s5);//false
//        System.out.println(s3 == s6);//true


//        final String s1 = "hello";
//        final String s2 = "world";
//        String s3 = "helloworld";
//        String s4 = s1 + "world";//s4 字符串内容也 helloworld，s1 是常量，"world"常量，常量+常量结果在常量池中
//        String s5 = s1 + s2;//s5 字符串内容也 helloworld，s1 和 s2 都是常量，常量+ 常量 结果在常量池中
//        String s6 = "hello" + "world";//常量+ 常量 结果在常量池中，因为编译期间就可以确定结果
//        System.out.println(s3 == s4);//true
//        System.out.println(s3 == s5);//true
//        System.out.println(s3 == s6);//true


//        String s1 = "hello";
//        String s2 = "world";
//        String s3 = "helloworld";
//        String s4 = (s1 + "world").intern();//把拼接的结果放到常量池中
//        String s5 = (s1 + s2).intern();
//        System.out.println(s3 == s4);//true
//        System.out.println(s3 == s5);//true


        String str = "hello";
        String str2 = "world";
        String str3 = "helloworld";
        String str4 = "hello".concat("world");
        String str5 = "hello" + "world";
        System.out.println(str3 == str4);//false
        System.out.println(str3 == str5);//true

    }
}
