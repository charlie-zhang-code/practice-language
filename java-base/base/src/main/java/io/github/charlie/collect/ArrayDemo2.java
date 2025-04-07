package io.github.charlie.collect;

import org.junit.Test;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/11
 * @Description: 二维数组
 */
public class ArrayDemo2 {
    @Test
    public void test1() {
        // 数组的声明和初始化
        // 静态初始化，数组变量的赋值与数组元素的赋值操作同时进行
        int[][] scores = new int[][]{{1, 2, 3}, {4, 5, 6}};

        // 动态初始化，数组变量的赋值与数组元素的赋值操作分开进行
        int[][] scores2 = new int[2][3];

        // 数组的长度
        System.out.println(scores.length);
        System.out.println(scores2.length);

        // 数组的调用
        System.out.println(scores[0][0]);
        System.out.println(scores[0][1]);

        // 数组的赋值
        scores[0][0] = 10;
        scores[0][1] = 20;

        // 数组的遍历
        // 方式一
        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores[i].length; j++) {
                System.out.println(scores[i][j] + " ");
            }
        }
        System.out.println();
        // 方式二
        for (int[] score : scores) {
            for (int s : score) {
                System.out.println(s + " ");
            }
        }
        System.out.println();
    }

    @Test
    public void test2() {
        int[][] scores3 = new int[2][3];

        System.out.println(scores3[0]); // 地址值
        System.out.println(scores3[1][1]); // 0
    }

    @Test
    public void test3() {
        String[][] arr1 = new String[3][2];
        int[][] arr2 = new int[4][];
        arr2[1] = new int[5];
        arr2[1][1] = 10;
        arr2[2][2] = 40; // 报错, "arr2[2]" is null
    }
}
