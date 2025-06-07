//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 反转 StringBuilder s 中从索引 left 到 right 的部分
    private void myReverse(StringBuilder s, int left, int right) {
        // 使用双指针法反转字符串
        while (left < right) {
            // 交换左右指针所指的字符
            char temp = s.charAt(left);
            s.setCharAt(left, s.charAt(right));
            s.setCharAt(right, temp);
            // 左指针右移，右指针左移
            left++;
            right--;
        }
    }

    // 去除 StringBuilder s 中多余的空格
    private void removeExtraSpaces(StringBuilder s) {
        int slow = 0; // 慢指针，用于记录新字符串的位置

        // 快指针 fast 遍历原字符串
        for (int fast = 0; fast < s.length(); fast++) {
            // 如果当前字符不是空格
            if (s.charAt(fast) != ' ') {
                // 如果慢指针不为 0，说明前面已经有字符，需要加一个空格
                if (slow != 0) {
                    s.setCharAt(slow++, ' ');
                }
                // 将连续的非空格字符复制到慢指针位置
                while (fast < s.length() && s.charAt(fast) != ' ') {
                    s.setCharAt(slow++, s.charAt(fast++));
                }
            }
        }

        // 删除末尾多余的空格
        if (slow > 0 && s.charAt(slow - 1) == ' ') {
            s.deleteCharAt(slow - 1);
        }
        // 截取有效部分
        s.setLength(slow);
    }

    public String reverseWords(String s) {
        // 使用 StringBuilder 来修改字符串
        StringBuilder sb = new StringBuilder(s);

        // 首先去除字符串中的多余空格
        removeExtraSpaces(sb);

        // 然后反转整个字符串
        myReverse(sb, 0, sb.length() - 1);

        int start = 0; // 用于标记每个单词的起始位置

        // 遍历字符串，找到每个单词的边界并反转
        for (int end = 0; end <= sb.length(); end++) {
            // 如果遇到空格或到达字符串末尾，说明一个单词结束
            if (end == sb.length() || sb.charAt(end) == ' ') {
                // 反转当前单词
                myReverse(sb, start, end - 1);
                // 更新下一个单词的起始位置
                start = end + 1;
            }
        }

        // 返回处理后的字符串
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
