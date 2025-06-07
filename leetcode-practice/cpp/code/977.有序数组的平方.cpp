/*
 * @lc app=leetcode.cn id=977 lang=cpp
 *
 * [977] 有序数组的平方
 */

// @lc code=start
class Solution
{
public:
    vector<int> sortedSquares(vector<int> &nums)
    {
        // 结果数据
        vector<int> result(nums.size(), 0);

        // 低指针
        int lowIndex = 0;
        int highIndex = nums.size() - 1; // 高指针
        int postion = nums.size() - 1;   // 插入位置（倒序插入）

        while (lowIndex <= highIndex)
        {
            // 低高指针比较，取大的插入到结果数组中
            if (nums[lowIndex] * nums[lowIndex] > nums[highIndex] * nums[highIndex])
            {
                // 低指针插入到结果数组中
                result[postion] = nums[lowIndex] * nums[lowIndex];
                lowIndex++; // 低指针后移
            }
            else
            {
                // 高指针插入到结果数组中
                result[postion] = nums[highIndex] * nums[highIndex];
                highIndex--; // 高指针前移
            }

            // 插入位置前移（倒序）
            postion--;
        }

        // 返回结果
        return result;
    }
};
// @lc code=end
