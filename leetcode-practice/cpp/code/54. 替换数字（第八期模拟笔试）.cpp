#include <iostream>

using namespace std;

int main() {
    string s; // 定义字符串变量s
    while (cin >> s) {
        // 循环读取输入流中的字符串（以空格分隔），直到输入结束
        // 记录原字符串末尾索引（从0开始计数）
        int strOldIndex = s.size() - 1;
        // 初始化数字计数器为0
        int count = 0;

        // 遍历字符串，统计数字字符的个数
        for (int i = 0; i < s.size(); i++) {
            // 判断字符是否为数字码范围判断）
            if (s[i] >= '0' && s[i] <= '9') {
                // 数字字符个数加1
                count++;
            }
        }

        int newLength = s.size() + count * 5;
        s.resize(newLength); // 使用resize调整大小
        int strNewIndex = newLength - 1; // 从真实末尾开始写入

        // 从末尾开始遍历原字符串
        // 逆序处理保证原字符串前半部分不受影响
        while (strOldIndex >= 0) {
            if (s[strOldIndex] >= '0' && s[strOldIndex] <= '9') {
                // 遇到数字字符，替换为"number"
                s[strNewIndex--] = 'r';
                s[strNewIndex--] = 'e';
                s[strNewIndex--] = 'b';
                s[strNewIndex--] = 'm';
                s[strNewIndex--] = 'u';
                s[strNewIndex--] = 'n';
            } else {
                // 遇到非数字字符，原字符直接复制到新字符串末尾
                s[strNewIndex--] = s[strOldIndex];
            }

            strOldIndex--;
        }

        cout << s << endl;
    }

    return 0;
}
