//给你一个非负整数 x ，计算并返回 x 的 算术平方根 。 
//
// 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。 
//
// 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 4
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：x = 8
//输出：2
//解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= x <= 2³¹ - 1 
// 
//
// Related Topics 数学 二分查找 👍 1674 👎 0


package leetcode.editor.cn;

/**
 * @author Charlie Zhang
 * @version v1.0
 * @date 2025-06-08 11:18:02
 * @description 69 x 的平方根
 */
public class Sqrtx {
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            int left = 0; // 左边界
            int right = x; // 右边界
            int ans = -1; // 初始化结果为-1

            while (left <= right) { // 左闭右闭区间
                int mid = left + (right - left) / 2;

                // 判断mid的平方是否小于等于x
                if ((long) mid * mid <= x) {
                    ans = mid; // 更新结果
                    left = mid + 1; // 更新左边界
                } else {
                    right = mid - 1; // 否则更新右边界
                }
            }

            // 返回结果
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}