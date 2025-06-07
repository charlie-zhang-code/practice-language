
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    bool isValid(string s) {
        if (s.size() % 2 == 1) { // 如果字符串s的长度是奇数，
            // 则直接返回false，因为有效的括号字符串长度必须为偶数（每个开括号必须有一个对应的闭括号）。
            return false;
        }

        stack<char> stk;

        // 遍历字符串s中的每一个字符。
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '(') {
                // 将预期的右括号')'压入栈中。
                stk.push(')');
            }
            else if (s[i] == '[') {
                // 将预期的右括号']'压入栈中。
                stk.push(']');
            }
            else if (s[i] == '{') {
                // 将预期的右括号'}'压入栈中。
                stk.push('}');
            }
            else if (stk.empty() || stk.top() != s[i]) { // 如果当前字符是右括号，并且栈为空或者栈顶元素不等于当前字符，
                return false; // 返回false，因为这说明括号不匹配。
            }
            else { // 如果当前字符与栈顶元素匹配（即找到了正确的闭合括号），
                stk.pop(); // 移除栈顶元素。
            }
        }

        return stk.empty(); // 最终，如果栈为空，说明所有括号都正确匹配，返回true；否则返回false。
    }
};
//leetcode submit region end(Prohibit modification and deletion)
