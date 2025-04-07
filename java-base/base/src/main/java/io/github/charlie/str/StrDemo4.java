package io.github.charlie.str;

import org.junit.Test;

/**
 * @Author: charlie-zhang-code
 * @Date: 2025/4/4
 * @Description: TODO
 */
public class StrDemo4 {
    @Test
    public void test01() {
        String s1 = "hello";
        String s2 = "world";
        String s3 = "helloworld";

        String s4 = s1 + "world";//s4字符串内容也helloworld，s1是变量，"world"常量，变量 + 常量的结果在堆中
        String s5 = s1 + s2;//s5字符串内容也helloworld，s1和s2都是变量，变量 + 变量的结果在堆中
        String s6 = "hello" + "world";//常量+ 常量 结果在常量池中，因为编译期间就可以确定结果

        System.out.println(s3 == s4);//false
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//true
    }

    @Test
    public void test02() {
        final String s1 = "hello";
        final String s2 = "world";
        String s3 = "helloworld";

        String s4 = s1 + "world";//s4字符串内容也helloworld，s1是常量，"world"常量，常量+常量结果在常量池中
        String s5 = s1 + s2;//s5字符串内容也helloworld，s1和s2都是常量，常量+ 常量 结果在常量池中
        String s6 = "hello" + "world";//常量+ 常量 结果在常量池中，因为编译期间就可以确定结果

        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//true
        System.out.println(s3 == s6);//true
    }

    @Test
    public void test03() {
        String s1 = "hello";
        String s2 = "world";
        String s3 = "helloworld";

        String s4 = (s1 + "world").intern();//把拼接的结果放到常量池中
        String s5 = (s1 + s2).intern();

        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//true
    }

    @Test
    public void test04() throws Exception {
        String str = "中国";
        System.out.println(str.getBytes("ISO8859-1").length);// 2
        // ISO8859-1把所有的字符都当做一个byte处理，处理不了多个字节
        System.out.println(str.getBytes("GBK").length);// 4 每一个中文都是对应2个字节
        System.out.println(str.getBytes("UTF-8").length);// 6 常规的中文都是3个字节

        /*
         * 不乱码：（1）保证编码与解码的字符集名称一样（2）不缺字节
         */
        System.out.println(new String(str.getBytes("ISO8859-1"), "ISO8859-1"));// 乱码
        System.out.println(new String(str.getBytes("GBK"), "GBK"));// 中国
        System.out.println(new String(str.getBytes("UTF-8"), "UTF-8"));// 中国
    }
}
