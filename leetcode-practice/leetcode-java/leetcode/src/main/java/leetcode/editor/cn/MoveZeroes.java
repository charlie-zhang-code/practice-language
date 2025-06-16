//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
// 
//
// 示例 2: 
//
// 
//输入: nums = [0]
//输出: [0] 
//
// 
//
// 提示: 
// 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能尽量减少完成的操作次数吗？ 
//
// Related Topics 数组 双指针 👍 2657 👎 0


package leetcode.editor.cn;

/**
 * @author Charlie Zhang
 * @version v1.0
 * @date 2025-06-08 11:26:59
 * @description 283 移动零
 */
public class MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            int slowIndex = 0;
            int fastIndex = 0;

            while (fastIndex < nums.length) {
                if (nums[fastIndex] != 0) {
                    // 快指针指向的元素非0，则交换
                    int temp = nums[slowIndex];
                    nums[slowIndex] = nums[fastIndex];
                    nums[fastIndex] = temp;

                    // 慢指针移动
                    slowIndex++;
                }

                // 快指针移动
                fastIndex++;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}