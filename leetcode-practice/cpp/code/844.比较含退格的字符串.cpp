/*
 * @lc app=leetcode.cn id=844 lang=cpp
 *
 * [844] 比较含退格的字符串
 */

// @lc code=start
class Solution
{
public:
    bool backspaceCompare(string s, string t)
    {
        // 初始化 sIndex 为字符串 s 的最后一个字符的索引
        int sIndex = s.size() - 1;
        // 初始化 tIndex 为字符串 t 的最后一个字符的索引
        int tIndex = t.size() - 1;
        // 初始化 sSkip 为 0，用于记录在字符串 s 中需要跳过的字符数（退格符的影响）
        int sSkip = 0;
        // 初始化 tSkip 为 0，用于记录在字符串 t 中需要跳过的字符数（退格符的影响）
        int tSkip = 0;

        // 主循环条件：只要 s 或 t 中还有未处理的字符，就继续循环
        while (sIndex >= 0 || tIndex >= 0)
        {
            // s字符串的退格符
            while (sIndex >= 0)
            {
                // 如果当前字符是退格符 '#'
                if (s[sIndex] == '#')
                {
                    sSkip++;  // 增加需要跳过的字符数
                    sIndex--; // 指针后退，移动到前一个字符
                }
                // 如果当前字符不是退格符，但前面有退格符需要跳过
                else if (sSkip > 0) // 退格符大于0
                {
                    sSkip--;  // 减少需要跳过的字符数
                    sIndex--; // 指针后退，跳过当前字符
                }
                // 如果当前字符不是退格符，且没有需要跳过的字符，退出内层循环
                else
                {
                    break;
                }
            }

            // t字符串的退格符
            while (tIndex >= 0)
            {
                if (t[tIndex] == '#') // 遇到退格符
                {
                    tSkip++;  // 退格符加一
                    tIndex--; // 指针后退
                }
                else if (tSkip > 0) // 退格符大于0
                {
                    tSkip--; // 退格符减一
                    tIndex--;
                }
                else // 退格符为0，说明没有退格符，直接退出循环
                {
                    break;
                }
            }

            // 如果 s 和 t 都还有未处理的字符
            if (sIndex >= 0 && tIndex >= 0) // 都有字符
            {
                // 比较当前字符是否相等
                if (s[sIndex] != t[tIndex])
                {
                    // 如果不相等，直接返回 false
                    return false;
                }
            }
            // 如果 s 和 t 中只有一个还有未处理的字符
            else
            {
                // 如果其中一个字符串还有字符，另一个已经遍历完，说明长度不同，返回 false
                if (sIndex >= 0 || tIndex >= 0)
                {
                    return false;
                }
            }

            // 无论是否比较字符，sIndex 和 tIndex 都向前移动一位，继续处理下一个字符
            sIndex--; // 指针后退
            tIndex--; // 指针后退
        }

        // 如果循环结束后没有发现不相等的情况，说明两个字符串在经过退格操作后相等，返回 true
        return true;
    }
};
// @lc code=end
