//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 👍 3024 👎 0


package leetcode.editor.cn;

/**
 * @author Charlie Zhang
 * @version v1.0
 * @date 2025-06-08 11:10:40
 * @description 34 在排序数组中查找元素的第一个和最后一个位置
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int findBound(int[] nums, int target, boolean lower) {
            int index = -1; // 初始化index为-1，表示未找到目标值
            int left = 0; // 定义左指针
            int right = nums.length - 1; // 定义右指针

            while (left <= right) { // 左闭右闭区间
                int mid = left + (right - left) / 2;

                if (nums[mid] > target) {
                    // 如果中间值大于目标值，目标值可能在左侧，更新右边界
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    // 如果中间值小于目标值，目标值可能在右侧，更新左边界
                    left = mid + 1;
                } else {
                    // 找到目标值，然后再根据lower参数来决定缩小范围
                    index = mid;
                    if (lower) {
                        // 如果是左边界查找，更新右边界
                        right = mid - 1;
                    } else {
                        // 如果是右边界查找，更新左边界
                        left = mid + 1;
                    }
                }
            }

            // 返回index
            return index;
        }

        public int[] searchRange(int[] nums, int target) {
            return new int[]{findBound(nums, target, true), findBound(nums, target, false)};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}