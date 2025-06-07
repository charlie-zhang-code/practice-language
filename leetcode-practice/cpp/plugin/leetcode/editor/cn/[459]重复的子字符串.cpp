//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
private:
    /**
     * @brief 计算KMP算法中的next数组
     * 
     * next数组用于存储模式串中每个位置的最长公共前后缀长度，
     * 在字符串匹配过程中可以跳过不必要的比较，提高效率。
     * 
     * @param next 存储next数组的指针，next[i]表示s[0..i]的最长公共前后缀长度
     * @param s 输入的模式串
     */
    void getNext(int* next, const string& s) {
        next[0] = 0; // 第一个字符没有前缀和后缀，故next[0]初始化为0
        int j = 0;   // j表示当前匹配的前缀长度

        // 遍历字符串s，从第二个字符开始计算next数组
        for (int i = 1; i < s.size(); i++) {
            // 当j > 0且当前字符s[i]不等于前缀的下一个字符s[j]时，
            // 回退j到next[j - 1]，寻找更短的前缀
            while (j > 0 && s[i] != s[j]) {
                j = next[j - 1];
            }
            // 如果当前字符s[i]等于前缀的下一个字符s[j]，则j增加1
            if (s[i] == s[j]) {
                j++;
            }
            // 将当前匹配的前缀长度j赋值给next[i]
            next[i] = j;
        }
    }

public:
    /**
     * @brief 判断字符串s是否由其某个子串重复多次构成
     * 
     * 该方法利用KMP算法中的next数组，通过判断字符串的长度与next数组最后一个值的关系
     * 来确定字符串是否由重复子串构成。
     * 
     * @param s 输入的字符串
     * @return true 如果s由某个子串重复多次构成
     * @return false 否则
     */
    bool repeatedSubstringPattern(string s) {
        // 如果字符串为空，直接返回false
        if (s.size() == 0) {
            return false;
        }

        // 动态分配next数组，大小为字符串的长度
        int next[s.size()];

        // 调用getNext函数计算next数组
        getNext(next, s);

        int strLen = s.size();

        // 判断条件：
        // 1. next[strLen - 1] != 0 表示存在非空的前后缀
        // 2. strLen 整除 (strLen - next[strLen - 1])，表示整个字符串可以由长度为 (strLen - next[strLen - 1]) 的子串重复构成
        if (next[strLen - 1] != 0 && strLen % (strLen - next[strLen - 1]) == 0) {
            return true;
        }

        // 不满足上述条件，则返回false
        return false;
    }
};
//leetcode submit region end(Prohibit modification and deletion)