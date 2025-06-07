/*
 * @lc app=leetcode.cn id=209 lang=cpp
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution
{
public:
    int minSubArrayLen(int target, vector<int> &nums)
    {
        int result = INT32_MAX; // 最小子数组长度
        int sum = 0;            // 滑动窗口的和
        int start = 0;          // 滑动窗口的起始位置
        int windowLength = 0;   // 滑动窗口的长度

        // 遍历数组，使用滑动窗口来寻找最小子数组
        for (int end = 0; end < nums.size(); end++)
        {
            sum += nums[end]; // 将当前元素加到滑动窗口的和上

            // 缩小滑动窗口，直到满足最小子数组长度要求
            while (sum >= target) // 滑动窗口的和大于等于目标值
            {
                windowLength = end - start + 1; // 计算滑动窗口的长度
                result = min(result, windowLength); // 更新最小子数组长度
                sum -= nums[start++]; // 从滑动窗口的起始位置开始缩小滑动窗口，直到满足最小子数组长度要求
            }
        }

        return result == INT32_MAX ? 0 : result;
    }
};
// @lc code=end
