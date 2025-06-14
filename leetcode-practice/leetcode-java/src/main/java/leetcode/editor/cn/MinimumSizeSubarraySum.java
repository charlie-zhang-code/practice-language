//给定一个含有 n 个正整数的数组和一个正整数 target 。 
//
// 找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其
//长度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 10⁹ 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
//
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 2462 👎 0


package leetcode.editor.cn;

/**
 * @author Charlie Zhang
 * @version v1.0
 * @date 2025-06-10 19:17:04
 * @description 209 长度最小的子数组
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        Solution solution = new MinimumSizeSubarraySum().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {

            /* ====================================================
             * 方式一 暴力破解（没通过）
             * ==================================================== */

            /*
            int min = Integer.MAX_VALUE;
            int sum = 0;
            int length = 0;
            for (int i = 0; i < nums.length; i++) {
                sum = 0;
                for (int j = i; j < nums.length; j++) {
                    sum += nums[j];
                    if (sum >= target) {
                        length = j - i + 1;
                        min = Math.min(min, length);
                        break;
                    }
                }
            }

            return min == Integer.MAX_VALUE ? 0 : min;
            */

            /* ====================================================
             * 方式二 滑动窗口
             * ==================================================== */
            int min = Integer.MAX_VALUE;
            int sum = 0;
            int left = 0;
            int length = 0;

            for (int right = 0; right < nums.length; right++) {
                sum += nums[right];
                while (sum >= target) {
                    length = right - left + 1;
                    min = Math.min(min, length);
                    sum -= nums[left++]; // 缩小窗口
                }
            }

            return min == Integer.MAX_VALUE ? 0 : min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}