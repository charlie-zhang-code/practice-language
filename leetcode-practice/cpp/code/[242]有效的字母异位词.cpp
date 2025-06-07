
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    bool isAnagram(string s, string t) {
        // 创建一个26长度的数组，分别记录s和t中每个字母出现的次数
        int count[26] = {0};

        // 遍历s和t，分别对每个字母出现的次数进行加减操作
        for (int i = 0; i < s.size(); i++) {
            // 对s中每个字母出现的次数进行加1操作
            count[s[i] - 'a']++;
        }
        for (int i = 0; i < t.size(); i++) {
            // 对t中每个字母出现的次数进行减1操作，不出意外，增操作和减操作抵消了，所以最终数组中的每个元素都为0
            count[t[i] - 'a']--;
        }

        // 判断数组中的每个元素是否都为0，如果都为0，则说明s和t是字母异位词
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }

        // 如果循环结束，count中的每个元素都为0，则说明s和t是字母异位词
        return true;
    }
};
//leetcode submit region end(Prohibit modification and deletion)
