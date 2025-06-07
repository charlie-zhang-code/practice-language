
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    string removeDuplicates(string s) {
        string res;

        for (char c : s) { // 遍历字符串s中的每一个字符c。
            if (!res.empty() && res.back() == c) { // 如果res不为空且其最后一个字符等于当前字符c，
                res.pop_back(); // 从res中移除最后一个字符（因为它与当前字符重复）。
            } else {
                res.push_back(c); // 将当前字符c添加到res的末尾。
            }
        }
        
        return res; // 返回处理后的字符串res。
    }
};
//leetcode submit region end(Prohibit modification and deletion)
