//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1462 👎 0


package leetcode.editor.cn;

/**
 * @author Charlie Zhang
 * @version v1.0
 * @date 2025-06-10 20:08:04
 * @description 59 螺旋矩阵 II
 */
public class SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] result = new int[n][n];
            int XRay = 0, YRay = 0;
            int loopCount = n / 2, middle = n / 2; // 中间位置
            int xTemp = 0, yTemp = 0; // 临时记录y轴

            int num = 1; // 计数器
            int offset = 1; // 控制每一圈（即每一层螺旋）中每条边遍历的长度

            while (loopCount-- > 0) {
                // 为什么会有这个临时变量呢，因为每次循环完之后
                // x轴和y轴都会发生变化，所以每次循环完之后，x轴和y轴都会恢复到初始位置
                xTemp = XRay;
                yTemp = YRay;

                // 循环每一层螺旋的每一条边
                // 左往右
                // 这里要注意，x是横坐标，y是纵坐标，左往右是固定x的变化，变化的是y轴
                for (; yTemp < n - offset; yTemp++) {
                    result[xTemp][yTemp] = num++;
                }

                // 上往下，这里要注意，x是横坐标，y是纵坐标，上往下是固定y的变化，变化的是x轴
                for (; xTemp < n - offset; xTemp++) {
                    result[xTemp][yTemp] = num++;
                }

                // 右往左，右往左是固定x的变化，变化的是y轴
                for (; yTemp > YRay; yTemp--) {
                    result[xTemp][yTemp] = num++;
                }

                // 下往上，下往上是固定y的变化，变化的是x轴
                for (; xTemp > XRay; xTemp--) {
                    result[xTemp][yTemp] = num++;
                }

                XRay++;
                YRay++;
                offset++;
            }

            // 奇数时，中间位置赋值
            if (n % 2 != 0) {
                result[middle][middle] = num;
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}