//给你一个正整数 num 。如果 num 是一个完全平方数，则返回 true ，否则返回 false 。 
//
// 完全平方数 是一个可以写成某个整数的平方的整数。换句话说，它可以写成某个整数和自身的乘积。 
//
// 不能使用任何内置的库函数，如 sqrt 。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 16
//输出：true
//解释：返回 true ，因为 4 * 4 = 16 且 4 是一个整数。
// 
//
// 示例 2： 
//
// 
//输入：num = 14
//输出：false
//解释：返回 false ，因为 3.742 * 3.742 = 14 但 3.742 不是一个整数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 2³¹ - 1 
// 
//
// Related Topics 数学 二分查找 👍 602 👎 0


package leetcode.editor.cn;

/**
 * @author Charlie Zhang
 * @version v1.0
 * @date 2025-06-08 11:21:19
 * @description 367 有效的完全平方数
 */
public class ValidPerfectSquare {
    public static void main(String[] args) {
        Solution solution = new ValidPerfectSquare().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPerfectSquare(int num) {
            int left = 0, right = num; // 初始化左右边界

            while (left <= right) { // 使用左闭右闭区间
                int mid = left + (right - left) / 2;

                // mid的平方
                long square = (long) mid * mid;

                // 判断mid的平方是否等于num
                if (square == num) {
                    // 找到了
                    return true;
                } else if (square < num) {
                    // 如果中间值小于目标值，则目标值在右侧，更新左边界
                    left = mid + 1;
                } else {
                    // 如果中间值大于目标值，则目标值在左侧，更新右边界
                    right = mid - 1;
                }
            }

            // 循环结束后，没有找到满足条件的数，返回false
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}