package io.github.charlie.str;

/**
 * @Author: charlie-zhang-code
 * @Date: 2025/4/4
 * @Description: TODO
 */
public class StrDemo {
//    public static void main(String[] args) {
//        String s1 = "javaEE";
//        String s2 = "javaEE";
//        String s3 = new String("javaEE");
//        String s4 = new String("javaEE");
//        System.out.println(s1 == s2); // true
//        System.out.println(s1 == s3); // false
//        System.out.println(s1 == s4); // false
//        System.out.println(s3 == s4); // false
//    }

    public static void main(String[] args) {
        String str1 = new String("hello").intern();
        String str2 = "hello";
        String str3 = new String("hello").intern();

        System.out.println(str1 == str2); // 输出: true
        System.out.println(str1 == str3); // 输出: true
    }
}
