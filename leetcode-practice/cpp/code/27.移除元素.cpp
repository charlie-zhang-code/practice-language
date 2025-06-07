/*
 * @lc app=leetcode.cn id=27 lang=cpp
 *
 * [27] 移除元素
 */

// @lc code=start
class Solution
{
public:
    int removeElement(vector<int> &nums, int val)
    {
        int slowPointer = 0; // 慢指针
        int fastPointer = 0; // 快指针

        // 快指针遍历整个数组
        for (fastPointer = 0; fastPointer < nums.size(); fastPointer++)
        {
            // 如果不是目标值，快指针移动
            if (val != nums[fastPointer])
            {
                nums[slowPointer++] = nums[fastPointer];
            }
        }

        // 返回nums中前面的元素个数，也就是 slowPointer
        return slowPointer;
    }
};
// @lc code=end
