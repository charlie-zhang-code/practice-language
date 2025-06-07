//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
private:
    // 反转字符串 s 中从索引 left 到 right 的部分
    void myReverse(string &s, int left, int right) {
        // 使用双指针法反转字符串
        while (left < right) {
            // 交换左右指针所指的字符
            swap(s[left], s[right]);
            // 左指针右移，右指针左移
            left++;
            right--;
        }
    }

    // 去除字符串 s 中多余的空格
    void removeExtraSpaces(string &s) {
        int slow = 0; // 慢指针，用于记录新字符串的位置

        // 快指针 fast 遍历原字符串
        for (int fast = 0; fast < s.size(); fast++) {
            // 如果当前字符不是空格
            if (s[fast] != ' ') {
                // 如果慢指针不为 0，说明前面已经有字符，需要加一个空格
                if (slow != 0) {
                    s[slow++] = ' ';
                }
                // 将连续的非空格字符复制到慢指针位置
                while (fast < s.size() && s[fast] != ' ') {
                    s[slow++] = s[fast++];
                }
            }
        }

        // 调整字符串大小，去除末尾多余的空格
        s.resize(slow);
    }

public:
    // 主函数，反转字符串中的单词
    string reverseWords(string s) {
        // 首先去除字符串中的多余空格
        removeExtraSpaces(s);

        // 然后反转整个字符串
        myReverse(s, 0, s.size() - 1);

        int start = 0; // 用于标记每个单词的起始位置

        // 遍历字符串，找到每个单词的边界并反转
        for (int end = 0; end <= s.size(); end++) {
            // 如果遇到空格或到达字符串末尾，说明一个单词结束
            if (end == s.size() || s[end] == ' ') {
                // 反转当前单词
                myReverse(s, start, end - 1);
                // 更新下一个单词的起始位置
                start = end + 1;
            }
        }

        // 返回处理后的字符串
        return s;
    }
};
//leetcode submit region end(Prohibit modification and deletion)