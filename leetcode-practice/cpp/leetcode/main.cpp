#include <iostream>
#include <string>
#include <unordered_map>
#include <climits> // 用于 INT_MAX

using namespace std;

class Solution {
public:
    string minWindow(string s, string t) {
        // 检查输入字符串是否有效
        // 如果 s 或 t 为空，或者 s 的长度小于 t 的长度，则无法形成有效的窗口
        if (s.empty() || t.empty() || s.length() < t.length()) {
            return "";
        }

        // 使用 unordered_map 来存储字符及其出现次数
        // originMap 存储字符串 t 中每个字符的出现次数
        unordered_map<char, int> originMap;
        // windowMap 存储当前滑动窗口中每个字符的出现次数
        unordered_map<char, int> windowMap;

        // 初始化 originMap，统计字符串 t 中每个字符的出现次数
        for (char c: t) {
            originMap[c]++;
        }

        // 定义滑动窗口的左右指针，初始都指向字符串 s 的起始位置
        int left = 0;
        int right = 0;

        // valid 用于记录当前窗口中满足 originMap 条件的字符种类数
        int valid = 0;

        // start 记录最小覆盖子串的起始位置
        int start = 0;

        // minLen 记录最小覆盖子串的长度，初始化为 INT_MAX 表示尚未找到有效窗口
        int minLen = INT_MAX;

        // 开始滑动窗口，right 指针不断向右扩展窗口
        while (right < s.length()) {
            char c = s[right]; // 取出当前右指针指向的字符
            right++; // 右指针向右移动，扩大窗口

            // 检查当前字符 c 是否是需要匹配的字符（存在于 originMap 中）
            if (originMap.find(c) != originMap.end()) {
                windowMap[c]++; // 将字符 c 的计数加 1

                // 如果当前字符 c 在窗口中的出现次数等于其在 t 中的出现次数，
                // 则认为这是一个有效的匹配，valid 加 1
                if (windowMap[c] == originMap[c]) {
                    valid++;
                }
            }

            // 当窗口中包含了 t 中所有需要的字符（valid 等于 originMap 的大小）时，
            // 尝试收缩窗口以找到最小的覆盖子串
            while (valid == originMap.size()) {
                // 检查当前窗口的长度是否比之前记录的最小窗口更小
                if (right - left < minLen) {
                    start = left; // 更新最小窗口的起始位置
                    minLen = right - left; // 更新最小窗口的长度
                }

                char d = s[left]; // 取出当前左指针指向的字符

                // 检查当前字符 d 是否是需要匹配的字符
                if (originMap.find(d) != originMap.end()) {
                    windowMap[d]--; // 将字符 d 的计数减 1

                    // 如果当前字符 d 在窗口中的出现次数小于其在 t 中的出现次数，
                    // 则认为这是一个无效的匹配，valid 减 1
                    if (windowMap[d] < originMap[d]) {
                        valid--;
                    }
                }

                left++; // 左指针向右移动，缩小窗口
            }
        }

        // 如果找到了有效的最小窗口，返回对应的子串；否则返回空字符串
        return minLen == INT_MAX ? "" : s.substr(start, minLen);
    }
};

int main() {
    string s = "ADOBECODEBANC";
    string t = "ABC";

    // 创建 Solution 类的实例
    Solution solution;

    // 调用 minWindow 函数并获取结果
    string result = solution.minWindow(s, t);

    // 输出结果
    if (!result.empty()) {
        cout << "Minimum Window Substring: \"" << result << "\"" << endl;
    } else {
        cout << "Not Found" << endl;
    }

    return 0;
}
