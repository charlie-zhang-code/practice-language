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

    /* ====================================================
     * 双指针解决
     * ==================================================== */
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean backspaceCompare(String s, String t) {
            int sIndex = s.length() - 1;
            int tIndex = t.length() - 1;

            int sSkip = 0;
            int tSkip = 0;

            while (sIndex >= 0 || tIndex >= 0) {
                while (sIndex >= 0) {
                    if (s.charAt(sIndex) == '#') {
                        sSkip++;
                        sIndex--;
                    } else if (sSkip > 0) {
                        sSkip--;
                        sIndex--;
                    } else {
                        break;
                    }
                }

                while (tIndex >= 0) {
                    if (t.charAt(tIndex) == '#') {
                        tSkip++;
                        tIndex--;
                    } else if (tSkip > 0) {
                        tSkip--;
                        tIndex--;
                    } else {
                        break;
                    }
                }

                if (sIndex >= 0 && tIndex >= 0) {
                    if (s.charAt(sIndex) != t.charAt(tIndex)) {
                        return false;
                    }
                } else {
                    if (sIndex >= 0 || tIndex >= 0) {
                        return false;
                    }
                }

                sIndex--;
                tIndex--;
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}