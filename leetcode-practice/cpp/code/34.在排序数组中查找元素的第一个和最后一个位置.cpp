/*
 * @lc app=leetcode.cn id=34 lang=cpp
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution
{
public:
    vector<int> searchRange(vector<int> &nums, int target)
    {
        int left = getLeft(nums, target); // 获取目标值的左边界
        int right = getRight(nums, target); // 获取目标值的右边界

         // 检查找到的边界是否有效，并且对应的元素是否等于目标值
        if (left <= right && // 左边界小于等于右边界
            right < nums.size() && // 右边界小于数组大小
            nums[left] == target && // 左边界对应的元素等于目标值
            nums[right] == target) // 右边界对应的元素等于目标值
        {
            return vector<int>{left, right}; // 返回有效的边界
        }

        return vector<int>{-1, -1}; // 返回无效的边界
    }

private:
    // 二分查找左边界
    int getLeft(vector<int> &nums, int target)
    {
        int left = 0;
        int right = (int)nums.size() - 1;
        int leftBoundary = (int)nums.size(); // 初始化左边界为数组长度（表示未找到）

        while (left <= right)
        {
            int middle = left + ((right - left) / 2); // 中间值 等同于(left + right)/2

            if (nums[middle] >= target)  // 如果中间元素大于等于目标值
            {
                right = middle - 1; // 右区间移动（开区间）
                leftBoundary = middle; // 更新左边界为中间值，因为目标值本身的index就是左边界
            }
            else
            {
                left = middle + 1;
            }
        }

        return leftBoundary;
    }

    // 二分查找右边界
    int getRight(vector<int> &nums, int target)
    {
        int left = 0;
        int right = (int)nums.size() - 1;
        int rightBoundary = (int)nums.size();

        while (left <= right)
        {
            int middle = left + ((right - left) / 2); // 中间值 等同于(left + right)/2

            if (nums[middle] > target)
            {
                right = middle - 1; // 右区间移动（开区间）
            }
            else
            {
                left = middle + 1; // 左区间移动（开区间）
                rightBoundary = middle;
            }
        }

        return rightBoundary;
    }
};
// @lc code=end
