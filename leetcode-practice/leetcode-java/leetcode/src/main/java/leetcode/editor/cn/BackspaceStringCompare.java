//给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。 
//
// 注意：如果对空文本输入退格字符，文本继续为空。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ab#c", t = "ad#c"
//输出：true
//解释：s 和 t 都会变成 "ac"。
// 
//
// 示例 2： 
//
// 
//输入：s = "ab##", t = "c#d#"
//输出：true
//解释：s 和 t 都会变成 ""。
// 
//
// 示例 3： 
//
// 
//输入：s = "a#c", t = "b"
//输出：false
//解释：s 会变成 "c"，但 t 仍然是 "b"。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 200 
// s 和 t 只含有小写字母以及字符 '#' 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以用 O(n) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？ 
// 
//
// Related Topics 栈 双指针 字符串 模拟 👍 820 👎 0


package leetcode.editor.cn;

/**
 * @author Charlie Zhang
 * @version v1.0
 * @date 2025-06-08 11:29:37
 * @description 844 比较含退格的字符串
 */
public class BackspaceStringCompare {
    public static void main(String[] args) {
        Solution solution = new BackspaceStringCompare().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean backspaceCompare(String s, String t) {
            /*
            // 初始化两个指针，分别从两个字符串的末尾开始遍历
            int sIndex = s.length() - 1; // s字符串的遍历指针，初始指向最后一个字符
            int tIndex = t.length() - 1; // t字符串的遍历指针，初始指向最后一个字符

            // 记录需要跳过的字符数（由于退格符'#'的影响）
            int sSkip = 0; // s字符串中需要跳过的字符数
            int tSkip = 0; // t字符串中需要跳过的字符数

            // 只要任一字符串还有字符需要比较，就继续循环
            while (sIndex >= 0 || tIndex >= 0) {
                // 处理s字符串中的退格符和需要跳过的字符
                while (sIndex >= 0) {
                    if (s.charAt(sIndex) == '#') { // 遇到退格符
                        sSkip++; // 增加需要跳过的字符数
                        sIndex--; // 指针前移
                    } else if (sSkip > 0) { // 当前字符需要被跳过
                        sSkip--; // 减少需要跳过的字符数
                        sIndex--; // 指针前移（跳过当前字符）
                    } else {
                        break; // 遇到有效字符，停止处理
                    }
                }

                // 处理t字符串中的退格符和需要跳过的字符（逻辑同上）
                while (tIndex >= 0) {
                    if (t.charAt(tIndex) == '#') { // 遇到退格符
                        tSkip++; // 增加需要跳过的字符数
                        tIndex--; // 指针前移
                    } else if (tSkip > 0) { // 当前字符需要被跳过
                        tSkip--; // 减少需要跳过的字符数
                        tIndex--; // 指针前移（跳过当前字符）
                    } else {
                        break; // 遇到有效字符，停止处理
                    }
                }

                // 比较两个字符串当前的有效字符
                if (sIndex >= 0 && tIndex >= 0) {
                    // 如果两个字符不相等，返回false
                    if (s.charAt(sIndex) != t.charAt(tIndex)) {
                        return false;
                    }
                } else {
                    // 如果一个字符串已经遍历完，另一个还有字符剩余，返回false
                    if (sIndex >= 0 || tIndex >= 0) {
                        return false;
                    }
                }

                // 指针前移，准备比较前一个字符
                sIndex--;
                tIndex--;
            }

            // 所有字符都比较完毕且都匹配，返回true
            return true;
            */

            // 从后向前遍历两个字符串
            int i = s.length() - 1, j = t.length() - 1;
            int skipS = 0, skipT = 0;

            while (i >= 0 || j >= 0) {
                // 处理s中的退格
                while (i >= 0) {
                    if (s.charAt(i) == '#') {
                        skipS++;
                        i--;
                    } else if (skipS > 0) {
                        skipS--;
                        i--;
                    } else {
                        break;
                    }
                }

                // 处理t中的退格
                while (j >= 0) {
                    if (t.charAt(j) == '#') {
                        skipT++;
                        j--;
                    } else if (skipT > 0) {
                        skipT--;
                        j--;
                    } else break;
                }

                // 比较当前字符
                if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) {
                    return false;
                }

                // 如果一个字符串已结束而另一个还有字符
                if ((i >= 0) != (j >= 0)) {
                    return false;
                }

                i--;
                j--;
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}