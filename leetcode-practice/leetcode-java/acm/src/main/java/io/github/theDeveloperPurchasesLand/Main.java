package io.github.theDeveloperPurchasesLand;

//44. 开发商购买土地（第五期模拟笔试）
//题目描述
//在一个城市区域内，被划分成了n * m个连续的区块，每个区块都拥有不同的权值，代表着其土地价值。目前，有两家开发公司，A 公司和 B 公司，希望购买这个城市区域的土地。
//
//现在，需要将这个城市区域的所有区块分配给 A 公司和 B 公司。
//
//然而，由于城市规划的限制，只允许将区域按横向或纵向划分成两个子区域，而且每个子区域都必须包含一个或多个区块。 为了确保公平竞争，你需要找到一种分配方式，使得 A 公司和 B 公司各自的子区域内的土地总价值之差最小。
//
//注意：区块不可再分。
//
//输入描述
//第一行输入两个正整数，代表 n 和 m。
//
//接下来的 n 行，每行输出 m 个正整数。
//
//输出描述
//请输出一个整数，代表两个子区域内土地总价值之间的最小差距。
//输入示例
//3 3
//1 2 3
//2 1 3
//1 2 3
//输出示例
//0
//提示信息
//如果将区域按照如下方式划分：
//
//1 2 | 3
//2 1 | 3
//1 2 | 3
//
//两个子区域内土地总价值之间的最小差距可以达到 0。
//
//数据范围：
//
//1 <= n, m <= 100；
//n 和 m 不同时为 1。
import java.util.Scanner;

/**
 * @author Charlie Zhang
 * @version v1.0
 * @date 17/06/2025
 * @description 开发商购买土地
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Main().new Solution();
        solution.problem();
    }

    class Solution {
        public void problem() {
            Scanner scanner = new Scanner(System.in);

            // 读取矩阵的行列数
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            int[][] matrix = new int[n][m];
            int sum = 0;

            // 读取矩阵数据并计算总和
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = scanner.nextInt();
                    sum += matrix[i][j];
                }
            }

            int result = Integer.MAX_VALUE;
            int count = 0; // 统计遍历过的行

            // 按行遍历计算最小差值
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    count += matrix[i][j];
                    // 遍历到行末尾时统计
                    if (j == m - 1) {
                        // count 表示前i行的总和
                        // (sum - count) 表示剩余行的总和
                        // (sum - count) - count 表示两行总和的差值 关心的只是它们的差值大小，所以用abs()取绝对值
                        result = Math.min(result, Math.abs((sum - count) - count));
                    }
                }
            }

            count = 0; // 重置计数器，统计遍历过的列

            // 按列遍历计算最小差值
            for (int j = 0; j < m; j++) {
                for (int i = 0; i < n; i++) {
                    count += matrix[i][j];
                    // 遍历到列末尾时统计
                    if (i == n - 1) {
                        // count 列的总和
                        // (sum - count) 剩余列的总和
                        // (sum - count) - count 两列总和的差值 关心的只是它们的差值大小，所以用abs()取绝对值
                        result = Math.min(result, Math.abs(sum - count - count));
                    }
                }
            }

            System.out.println(result);
            scanner.close();
        }
    }
}