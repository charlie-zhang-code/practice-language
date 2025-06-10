//给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-4,-1,0,3,10]
//输出：[0,1,9,16,100]
//解释：平方后，数组变为 [16,1,0,9,100]
//排序后，数组变为 [0,1,9,16,100] 
//
// 示例 2： 
//
// 
//输入：nums = [-7,-3,2,3,11]
//输出：[4,9,9,49,121]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 已按 非递减顺序 排序 
// 
//
// 
//
// 进阶： 
//
// 
// 请你设计时间复杂度为 O(n) 的算法解决本问题 
// 
//
// Related Topics 数组 双指针 排序 👍 1111 👎 0


package leetcode.editor.cn;

/**
 * @author Charlie Zhang
 * @version v1.0
 * @date 2025-06-08 11:33:12
 * @description 977 有序数组的平方
 */
public class SquaresOfASortedArray {
    public static void main(String[] args) {
        Solution solution = new SquaresOfASortedArray().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortedSquares(int[] nums) {
            int left = 0; // 左指针
            int right = nums.length - 1; // 右指针

            int[] result = new int[nums.length]; // 结果数组

            // 遍历数组
            for (int i = nums.length - 1; i >= 0; i--) {
                if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                    // 如果左指针指向的元素绝对值大于右指针指向的元素绝对值
                    // 则将左指针指向的元素平方赋值给结果数组的当前位置
                    // 并移动左指针
                    result[i] = nums[left] * nums[left];
                    left++;
                } else {
                    result[i] = nums[right] * nums[right];
                    right--;
                }
            }

            // 返回结果数组
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}