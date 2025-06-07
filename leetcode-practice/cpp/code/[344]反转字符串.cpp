
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    void reverseString(vector<char>& s) {
        int left = 0, right = s.size() - 1;
        while (left < s.size() / 2) { // 也可以用 left < right
            swap(s[left], s[right]);
            left++;
            right--;
        }
    }
};
//leetcode submit region end(Prohibit modification and deletion)
