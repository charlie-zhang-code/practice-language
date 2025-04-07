package io.github.charlie.collect;

import org.junit.Test;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/11
 * @Description: 一维数组
 */
public class ArrayDemo1 {
    @Test
    public void test1() {
        // 声明数组
        double[] prices;
        // 数组的初始化
        // 静态初始化，数组变量的赋值与数组元素的赋值操作同时进行
        prices = new double[]{20.0, 30.0, 40.0};

        // 数组的声明和初始化
        // 动态初始化，数组变量的赋值与数组元素的赋值操作分开进行
        String[] foods = new String[3];

        // 数组元素的调用
        System.out.println(prices[0]);
        System.out.println(prices[1]);

        // 数组的长度
        System.out.println(prices.length);
        System.out.println(foods.length);

        // 数组的赋值
        prices[0] = 10.0;
        prices[1] = 20.0;

        // 数组的遍历
        // 方式一
        for (int i = 0; i < prices.length; i++) {
            System.out.println(prices[i]);
        }
        // 方式二
        for (double price : prices) {
            System.out.println(price);
        }
    }

    @Test
    public void test2() {
        // 数组元素的默认初始化值
        // int类型数组的默认初始化值是0
        int[] ints = new int[3];
        for (int i : ints) {
            System.out.println(i);
        }
        // double类型数组的默认初始化值是0.0
        double[] doubles = new double[3];
        for (double d : doubles) {
            System.out.println(d);
        }
        // boolean类型数组的默认初始化值是false
        boolean[] booleans = new boolean[3];
        for (boolean b : booleans) {
            System.out.println(b);
        }
        // char类型数组的默认初始化值是\u0000 0
        char[] chars = new char[3];
        for (char c : chars) {
            System.out.println(c);
        }
        if (chars[0] == '\u0000') {
            System.out.println("默认初始化值是\\u0000");
        }
        if (chars[0] == '0') {
            System.out.println("默认初始化值是0");
        }
        if (chars[0] == 0) {
            System.out.println("默认初始化值是0");
        }

        // 引用数据类型的数组的默认初始化值是null
        String[] strings = new String[3];
        for (String s : strings) {
            System.out.println(s);
        }
        if (strings[0] == null) {
            System.out.println("默认初始化值是null");
        }
        if (strings[0] == "") {
            System.out.println("默认初始化值是空字符串");
        }
        if (strings[0] == "null") {
            System.out.println("默认初始化值是null字符串");
        }
    }

    @Test
    public void test3() {
        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 2;

        String[] arr2 = new String[5];
        arr2[0] = "177";
        arr2 = new String[10];
    }

    @Test
    public void test4() {
        int[] arr1 = new int[]{1, 2, 3};
        int[] arr2 = arr1;
        arr2[1] = 10;
        System.out.println(arr1[1]);
        System.out.println(arr1);
        System.out.println(arr2);
    }
}
