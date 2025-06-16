package io.github.intervalSum;

//58. 区间和（第九期模拟笔试）
//题目描述
//给定一个整数数组 Array，请计算该数组在每个指定区间内元素的总和。
//输入描述
//第一行输入为整数数组 Array 的长度 n，接下来 n 行，每行一个整数，表示数组的元素。随后的输入为需要计算总和的区间下标：a，b （b > = a），直至文件结束。
//输出描述
//输出每个指定区间内元素的总和。
//输入示例
//5
//1
//2
//3
//4
//5
//0 1
//1 3
//输出示例
//3
//9
//提示信息
//数据范围：
//0 < n <= 100000
import java.util.Scanner;

/**
 * @author Charlie Zhang
 * @version v1.0
 * @date 17/06/2025
 * @description 区间和 输出每个指定区间内元素的总和
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Main().new Solution();
        solution.problem();
    }

    class Solution {
        public void problem() {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();

            int[] a = new int[n]; // 输入数组
            int[] p = new int[n]; // 前缀和
            int presum = 0; // 前缀和

            /*
            p[1] = a[0] + a[1];
            p[5] = a[0] + a[1] + a[2] + a[3] + a[4] + a[5];
            p[5] - p[1] = a[2] + a[3] + a[4] + a[5];
             */
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt(); // 输入数组元素
                presum += a[i]; // 计算前缀和
                p[i] = presum; // 将前缀和保存到前缀和数组中
            }

            while (scanner.hasNextInt()) {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                int sum = (l == 0) ? p[r] : p[r] - p[l - 1];
                System.out.println(sum);
            }

            scanner.close();
        }
    }
}
