/*
 * @lc app=leetcode.cn id=26 lang=cpp
 *
 * [26] 删除有序数组中的重复项
 */

// @lc code=start
class Solution
{
public:
    int removeDuplicates(vector<int> &nums)
    {
        // 如果数组为空，直接返回0
        if (nums.size() == 0)
        {
            return 0;
        }

        int slowPointer = 1; // 慢指针
        int fastPointer = 1; // 快指针

        while (fastPointer < nums.size())
        {
            // 如果快指针遍历的过程中，遇到快指针和快指针前一个元素不相等，说明已经是新的元素，慢指针加一，并且慢指针指向的值等于快指针的值
            if (nums[fastPointer] != nums[fastPointer - 1])
            {
                // 慢指针加一，慢指针指向的值等于快指针的值
                nums[slowPointer++] = nums[fastPointer];
            }

            fastPointer++; // 快指针加一
        }

        return slowPointer; // 返回慢指针，也就是nums前几个元素的长度
    }
};
// @lc code=end
