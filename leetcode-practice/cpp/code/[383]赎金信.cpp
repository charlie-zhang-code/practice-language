
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        int record[26] = {0};

        // 如果ransomNote的长度大于magazine的长度，肯定无法构造ransomNote
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        // 统计magazine中每个字母出现的次数
        for (int i = 0; i < magazine.length(); i++) {
            record[magazine[i] - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            // 如果减少后小于0，说明ransomNote中某个字母在magazine中不存在，返回false
            if (--record[ransomNote[i] - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
};
//leetcode submit region end(Prohibit modification and deletion)
