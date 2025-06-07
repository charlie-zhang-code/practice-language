//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
private:
    // 函数：getNext
    // 作用：计算KMP算法中的next数组，用于在匹配失败时快速跳过不必要的比较
    // 参数：
    //   next: 存储next数组的指针
    //   s: 需要计算next数组的字符串
    void getNext(int *next, const string &s) {
        int j = 0;  // j表示当前匹配的前缀长度
        next[0] = 0;  // 第一个字符的next值总是0，因为没有前缀

        // 遍历字符串s，从第二个字符开始
        for (int i = 1; i < s.size(); i++) {
            // 当j > 0且s[i] != s[j]时，说明当前字符不匹配，需要回退j到next[j - 1]
            // 这样做的目的是找到更短的前缀，使得s[i]和s[j]能够匹配
            while (j > 0 && s[i] != s[j]) {
                j = next[j - 1];
            }
            // 如果s[i] == s[j]，说明当前字符匹配，j增加1
            if (s[i] == s[j]) {
                j++;
            }
            // 将当前匹配的前缀长度j赋值给next[i]
            next[i] = j;
        }
    }

public:
    // 函数：strStr
    // 作用：在haystack中查找needle的第一次出现位置，返回其索引，如果不存在则返回-1
    // 参数：
    //   haystack: 主字符串
    //   needle: 需要查找的子字符串
    int strStr(string haystack, string needle) {
        // 如果needle为空字符串，直接返回0
        if (needle.size() == 0) {
            return 0;
        }

        // 创建一个next数组，大小为needle的长度
        vector<int> next(needle.size());
        // 调用getNext函数计算needle的next数组
        getNext(&next[0], needle);

        int j = 0;  // j表示当前匹配的needle的字符位置

        // 遍历haystack字符串
        for (int i = 0; i < haystack.size(); i++) {
            // 当j > 0且haystack[i] != needle[j]时，说明当前字符不匹配，需要回退j到next[j - 1]
            // 这样做的目的是利用next数组跳过不必要的比较
            while (j > 0 && haystack[i] != needle[j]) {
                j = next[j - 1];
            }
            // 如果haystack[i] == needle[j]，说明当前字符匹配，j增加1
            if (haystack[i] == needle[j]) {
                j++;
            }
            // 如果j等于needle的长度，说明已经完全匹配，返回匹配的起始位置
            if (j == needle.size()) {
                return (i - needle.size() + 1);
            }
        }

        // 如果遍历完haystack仍未找到匹配的needle，返回-1
        return -1;
    }
};
//leetcode submit region end(Prohibit modification and deletion)