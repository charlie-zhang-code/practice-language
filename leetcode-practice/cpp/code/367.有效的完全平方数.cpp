/*
 * @lc app=leetcode.cn id=367 lang=cpp
 *
 * [367] 有效的完全平方数
 */

// @lc code=start
class Solution
{
public:
    bool isPerfectSquare(int num)
    {
        int left = 0;    // 指向第一个元素
        int right = num; // 指向最后一个元素的闭区间

        while (left <= right)
        {
            int middle = left + ((right - left) / 2); // 中间值 等同于(left + right)/2

            long long square = (long long)middle * middle; // 计算平方，使用 long long 防止溢出

            if (square > num)
            {
                right = middle - 1; // 缩小右区间
            }
            else if (square < num)
            {
                left = middle + 1; // 增加左区间
            }
            else // 都不是，就是中间值了
            {
                return true; // 找到完全平方数
            }
        }

        return false; // 返回结果
    }
};
// @lc code=end
