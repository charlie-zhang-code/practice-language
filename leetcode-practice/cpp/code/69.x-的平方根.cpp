/*
 * @lc app=leetcode.cn id=69 lang=cpp
 *
 * [69] x 的平方根
 */

// @lc code=start
class Solution
{
public:
    int mySqrt(int x)
    {
        int left = 0; // 指向第一个元素
        int right = x; // 指向最后一个元素的闭区间
        int result = 0; // 结果

        while (left <= right)
        {
            int middle = left + ((right - left) / 2); // 中间值 等同于(left + right)/2

            if ((long long)middle * middle > x) // 如果中间值的平方大于目标值，说明要找的平方根在左区间
            {
                right = middle - 1; // 缩小右区间
            }
            else // 如果中间值的平方小于等于目标值，说明要找的平方根在右区间
            {
                result = middle;   // 记录结果
                left = middle + 1; // 增加左区间
            }
        }

        return result; // 返回结果
    }
};
// @lc code=end
