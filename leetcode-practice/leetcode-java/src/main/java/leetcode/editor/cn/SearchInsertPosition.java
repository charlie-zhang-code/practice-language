//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 请必须使用时间复杂度为 O(log n) 的算法。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,3,5,6], target = 5
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,3,5,6], target = 2
//输出: 1
// 
//
// 示例 3: 
//
// 
//输入: nums = [1,3,5,6], target = 7
//输出: 4
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 为 无重复元素 的 升序 排列数组 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics 数组 二分查找 👍 2516 👎 0


package leetcode.editor.cn;

/**
 * @author Charlie Zhang
 * @version v1.0
 * @date 2025-06-08 11:04:15
 * @description 35 搜索插入位置
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new SearchInsertPosition().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            /* ====================================================
             * 暴力搜索
             * ==================================================== */

            /*
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= target) {
                    return i;
                }
            }
            return nums.length;
            */

            /* ====================================================
             * 题目中数组是已经排序好的，因此可以使用二分查找，
             * ==================================================== */
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (target > nums[mid]) {
                    left = mid + 1;
                } else if (target < nums[mid]) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            }

            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}