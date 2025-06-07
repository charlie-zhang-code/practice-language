/*
 * @lc app=leetcode.cn id=704 lang=cpp
 *
 * [704] 二分查找
 */

// @lc code=start
// class Solution
// {
// public:
//     int search(vector<int> &nums, int target)
//     {
//         int left = 0;                // 指向第一个元素
//         int right = nums.size() - 1; // 指向最后一个元素的索引

//         while (left <= right)
//         {
//             int middle = left + ((right - left) / 2); // 中间值 等同于(left + right)/2

//             if (nums[middle] > target) // 如果中间值大于目标值
//             {
//                 right = middle - 1; // 右区间移动
//             }
//             else if (nums[middle] < target) // 如果中间值小于目标值
//             {
//                 left = middle + 1;
//             }
//             else // 都不是，就是中间值了
//             {
//                 return middle;
//             }
//         }

//         return -1;
//     }
// };

class Solution
{
public:
    int search(vector<int> &nums, int target)
    {
        int left = 0;            // 指向第一个元素
        int right = nums.size(); // 指向最后一个元素的开区间

        while (left < right) // 相等无意义
        {
            int middle = left + ((right - left) / 2); // 中间值 等同于(left + right)/2

            if (nums[middle] > target) // 如果中间值大于目标值
            {
                right = middle; // 右区间移动（开区间）
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

        return -1; // 找不到，返回-1
    }
};
// @lc code=end
