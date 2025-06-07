/*
 * @lc app=leetcode.cn id=904 lang=cpp
 *
 * [904] 水果成篮
 */

// @lc code=start
class Solution
{
public:
    int totalFruit(vector<int> &fruits)
    {
        unordered_map<int, int> mp; // 记录每个水果出现的次数

        int start = 0;
        int result = 0;

        for (int end = 0; end < fruits.size(); end++)
        {
            mp[fruits[end]]++;

            while (mp.size() > 2) // 窗口内水果种类大于2
            {
                mp[fruits[start]]--;

                if (mp[fruits[start]] == 0) // 如果该水果已经没有，则删除
                {
                    mp.erase(fruits[start]);
                }

                start++; // 窗口左指针右移
            }

            result = max(result, end - start + 1); // 更新结果
        }

        return result;
    }
};
// @lc code=end
