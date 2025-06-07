
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        // 使用栈来存储运算过程中的数字
        // 选择long long类型是为了防止大数计算时的溢出
        stack<long long> s;

        // 遍历逆波兰表达式中的所有token(符号)
        for (auto& token : tokens) {
            // 检查当前token是否是运算符
            if (token == "+" || token == "-" || token == "*" || token == "/") {
                // 如果是运算符，从栈顶弹出两个数字
                // 注意顺序：先弹出的是第二个操作数(num1)，后弹出的是第一个操作数(num2)
                long long num1 = s.top();
                s.pop();
                long long num2 = s.top();
                s.pop();

                // 根据运算符类型执行相应计算
                if (token == "+") {
                    s.push(num2 + num1);  // 加法运算
                } else if (token == "-") {
                    s.push(num2 - num1);  // 减法运算
                } else if (token == "*") {
                    s.push(num2 * num1);  // 乘法运算
                } else if (token == "/") {
                    s.push(num2 / num1);  // 除法运算
                }
            } else {
                // 如果不是运算符，则是数字，将其转换为long long后压入栈中
                // stoll: string to long long
                s.push(stoll(token));
            }
        }

        // 最后栈中剩下的唯一元素就是计算结果
        long long res = s.top();
        s.pop();  // 弹出结果
        return res;  // 返回最终结果
    }
};
//leetcode submit region end(Prohibit modification and deletion)
