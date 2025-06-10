//给定一个二维数组 array，请返回「螺旋遍历」该数组的结果。 
//
// 螺旋遍历：从左上角开始，按照 向右、向下、向左、向上 的顺序 依次 提取元素，然后再进入内部一层重复相同的步骤，直到提取完所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：array = [[1,2,3],[8,9,4],[7,6,5]]
//输出：[1,2,3,4,5,6,7,8,9]
// 
//
// 示例 2： 
//
// 
//输入：array  = [[1,2,3,4],[12,13,14,5],[11,16,15,6],[10,9,8,7]]
//输出：[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= array.length <= 100 
// 0 <= array[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
//
// 
//
// Related Topics 数组 矩阵 模拟 👍 612 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Charlie Zhang
 * @version v1.0
 * @date 2025-06-10 20:17:00
 * @description LCR 146 螺旋遍历二维数组
 */
public class ShunShiZhenDaYinJuZhenLcof {
    public static void main(String[] args) {
        Solution solution = new ShunShiZhenDaYinJuZhenLcof().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] spiralArray(int[][] array) {
            if (array.length == 0 || array[0].length == 0) {
                return new int[0];
            }

            int rows = array.length; // 行数
            int cols = array[0].length; // 列数

            // 存放结果
//        int[] result = new int[rows * cols];
            List<Integer> result = new ArrayList<>();

            int left = 0, right = cols - 1;
            int top = 0, bottom = rows - 1;

            while (left <= right && top <= bottom) {
                // 从左到右遍历
                for (int i = left; i <= right; i++) {
                    result.add(array[top][i]);
                }
                top++;

                // 从上到下遍历
                for (int i = top; i <= bottom; i++) {
                    result.add(array[i][right]);
                }
                right--;

                // 判断是否越界
                if (top <= bottom) {
                    for (int i = right; i >= left; i--) {
                        result.add(array[bottom][i]);
                    }
                    bottom--;
                }

                // 判断是否越界
                if (left <= right) {
                    for (int i = bottom; i >= top; i--) {
                        result.add(array[i][left]);
                    }
                    left++;
                }
            }

            return result.stream().mapToInt(Integer::intValue).toArray();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}