package io.github.charlie.collect;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: Charlie Zhang(Github: @charlie-zhang-code)
 * @Date: 2025/1/11
 * @Description: 数组工具类
 */
public class ArrayUtilClass {
    @Test
    public void test1() {
        int[] scores = new int[]{1, 2, 3, 4, 5};
        int[] scores1 = new int[]{1, 2, 3, 4, 8};
        int[] scores2 = new int[]{1, 2, 3, 4, 8};

        // 判断两个数组是否相等
        System.out.println(Arrays.equals(scores, scores1));
        System.out.println(Arrays.equals(scores2, scores1));
    }
}
