/*
 * @lc app=leetcode.cn id=35 lang=cpp
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution
{
public:
    int searchInsert(vector<int> &nums, int target)
    {
        int left = 0;                // 指向第一个元素
        int right = nums.size() - 1; // 指向最后一个元素的开区间

        while (left <= right)
        {
            int middle = left + ((right - left) / 2); // 中间值 等同于(left + right)/2

            if (nums[middle] > target) // 如果中间值大于目标值
            {
                right = middle - 1; // 右区间移动（开区间）
            }
            else if (nums[middle] < target) // 如果中间值小于目标值
            {
                left = middle + 1;
            }
            else // 都不是，就是中间值了
            {
                return middle;
            }
        }

        return right + 1; // 找不到，塞右边，因为是闭合区间，所以增1为下一个位置
    }
};
// @lc code=end
