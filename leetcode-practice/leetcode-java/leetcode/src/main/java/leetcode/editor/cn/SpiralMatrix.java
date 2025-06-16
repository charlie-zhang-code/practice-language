//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1933 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Charlie Zhang
 * @version v1.0
 * @date 2025-06-10 20:12:44
 * @description 54 螺旋矩阵
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            // 如果矩阵为空，则返回空数组
            if (matrix.length == 0 || matrix[0].length == 0) {
                return new ArrayList<>();
            }

            // 获取矩阵的行数和列数
            int rows = matrix.length;
            int columns = matrix[0].length;

            List<Integer> result = new ArrayList<>();

            // 定义每一层的起始和结束位置
            int left = 0, right = columns - 1;
            int top = 0, bottom = rows - 1;

            // 按层模拟遍历
            while (left <= right && top <= bottom) {
                // 从左到右遍历上边
                for (int column = left; column <= right; column++) {
                    result.add(matrix[top][column]);
                }
                top++; // 上边遍历完毕，上边界下移

                // 从上到下遍历右边
                for (int row = top; row <= bottom; row++) {
                    result.add(matrix[row][right]);
                }
                right--; // 右边遍历完毕，右边界左移

                // 从右到左遍历下边
                if (top <= bottom) { // 如果遍历的层数在bottom之下，才遍历下边，受到bottom--;限制
                    for (int i = right; i >= left; i--) {
                        result.add(matrix[bottom][i]);
                    }
                    bottom--; // 下边遍历完毕，下边界上移
                }

                // 从下到上遍历左边
                if (left <= right) { // 如果遍历的列数在right之下，才遍历左边，受到left++;限制
                    for (int i = bottom; i >= top; i--) {
                        result.add(matrix[i][left]);
                    }
                    left++; // 左边遍历完毕，左边界右移
                }
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}