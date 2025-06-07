
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
private:
    // 反转字符串s中从start到end位置的字符
    void myReverse(string& s, int start, int end){
       int left = start;
       int right = end;
       while (left < right){
           swap(s[left], s[right]);
           left++;
           right--;
       }
    }
public:
    string reverseStr(string s, int k) {
        // 每次处理2k个字符
       for (int i = 0; i < s.size(); i += 2 * k) {
           if (i + k < s.size()) { // 剩余字符大于等于k个
               myReverse(s, i, i + k - 1); // 反转当前2k块中的前k个字符
           } else { // 剩余字符小于k个
               myReverse(s, i, s.size() - 1);  // 反转剩余所有字符
           }
       }

       return s;
    }
};
//leetcode submit region end(Prohibit modification and deletion)
