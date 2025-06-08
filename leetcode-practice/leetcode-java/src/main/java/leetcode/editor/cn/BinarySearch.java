//给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否
//则返回 -1。 
//
// 示例 1: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 9
//输出: 4
//解释: 9 出现在 nums 中并且下标为 4
// 
//
// 示例 2: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 2
//输出: -1
//解释: 2 不存在 nums 中因此返回 -1
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设 nums 中的所有元素是不重复的。 
// n 将在 [1, 10000]之间。 
// nums 的每个元素都将在 [-9999, 9999]之间。 
// 
//
// Related Topics 数组 二分查找 👍 1766 👎 0


package leetcode.editor.cn;

/**
 * @author Charlie Zhang
 * @version v1.0
 * @date 2025-06-08 10:58:58
 * @description 704 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        Solution solution = new BinarySearch().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            /* ====================================================
             *方式一：[左闭，右闭]
             * 目标值可能会落在区间内，边界相等是有意义的，采用迭代方式实现
             * 循环条件为：left <= right 都指向数组有效的元素
             * nums[left] 和 nums[right] 都是被搜索范围内的元素
             * 终止条件为：left > right
             * 则说明没有找到目标值
             * ==================================================== */

            /*
            int left = 0; // 左边界
            int right = nums.length - 1; // 右边界

            // 注意：left <= right，区间[left, right]有效
            while (left <= right) {
                int mid = left + ((right - left) / 2); // 中间值 等同于(left + right)/2

                // nums[mid] 含义 -> 中间值
                if (target > nums[mid]) {
                    // 如果中间值小于目标值，则将左边界扩大为mid+1
                    left = mid + 1;
                } else if (target < nums[mid]) {
                    // 如果中间值大于目标值，则将右边界缩小为mid-1
                    right = mid - 1;
                } else {
                    // 如果中间值等于目标值，则返回中间值
                    return mid;
                }
            }

            // 循环结束后，还没有找到目标值，返回-1
            return -1;
            */

            /* ====================================================
             * 方式二：[左闭，右开)
             * ==================================================== */
            int left = 0;
            int right = nums.length;
            while (left < right) {
                int mid = left + ((right - left) / 2);
                if (target > nums[mid]) {
                    left = mid + 1;
                } else if (target < nums[mid]) {
                    right = mid;
                } else {
                    return mid;
                }
            }

            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}