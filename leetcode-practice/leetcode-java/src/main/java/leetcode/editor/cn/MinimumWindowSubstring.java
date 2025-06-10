//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
//解释：整个字符串 s 是最小覆盖子串。
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 
//o(m+n) 时间内解决此问题的算法吗？
//
// Related Topics 哈希表 字符串 滑动窗口 👍 3273 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Charlie Zhang
 * @version v1.0
 * @date 2025-06-10 19:41:35
 * @description 76 最小覆盖子串
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            // 合法判断
            if (s == null || t == null || s.isEmpty() || t.isEmpty() || s.length() < t.length()) {
                return "";
            }

            // 统计t中每个字符的出现次数
            Map<Character, Integer> targetMap = new HashMap<>();
            for (char c : t.toCharArray()) {
                targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
            }

            int left = 0; // 滑动窗口左边界
            int minLeft = 0; // 最小窗口的左边界
            int minLen = Integer.MAX_VALUE; // 最小窗口长度
            int count = 0; // 匹配到的字符总数

            // 滑动窗口遍历
            for (int right = 0; right < s.length(); right++) {
                char rightChar = s.charAt(right); // 当前字符

                // 如果当前字符在t中存在
                if (targetMap.containsKey(rightChar)) {
                    // 减少该字符的需求计数
                    targetMap.put(rightChar, targetMap.get(rightChar) - 1);
                    // 如果该字符的需求计数仍然>=0，说明匹配到了一个有效字符
                    if (targetMap.get(rightChar) >= 0) {
                        count++;
                    }

                    // 当窗口包含t的所有字符时，尝试收缩左边界
                    while (count == t.length()) {
                        // 更新最小窗口
                        if (right - left + 1 < minLen) {
                            minLen = right - left + 1;
                            minLeft = left;
                        }

                        char leftChar = s.charAt(left);
                        if (targetMap.containsKey(leftChar)) {
                            // 恢复该字符的需求计数
                            targetMap.put(leftChar, targetMap.get(leftChar) + 1);
                            // 如果需求计数>0，说明移除了一个有效字符
                            if (targetMap.get(leftChar) > 0) {
                                count--;
                            }
                        }

                        left++; // 移动窗口的左边界
                    }
                }
            }

            return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}