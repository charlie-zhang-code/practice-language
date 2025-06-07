/*
 * @lc app=leetcode.cn id=283 lang=cpp
 *
 * [283] 移动零
 */

// @lc code=start
class Solution
{
public:
    void moveZeroes(vector<int> &nums)
    {
        int slowPointer = 0; // 慢指针
        int fastPointer = 0; // 快指针

        while (fastPointer < nums.size())
        {
            // 快指针指向非零元素时，慢指针指向的位置与快指针指向的位置交换
            if (nums[fastPointer] != 0)
            {
                swap(nums[slowPointer], nums[fastPointer]);
                slowPointer++;
            }

            fastPointer++;
        }
    }
};
// @lc code=end
