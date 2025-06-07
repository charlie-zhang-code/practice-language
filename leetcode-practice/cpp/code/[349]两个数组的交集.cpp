
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
          // 创建一个空的哈希表，用于存储结果
        unordered_set<int> result;
        // 创建一个哈希表，用于存储nums1中的元素，但是不会存储重复的元素
        unordered_set<int> hashSet(nums1.begin(), nums1.end()); // 将nums1中的元素添加到哈希表中

       // 遍历nums2中的每个元素
        for (int num : nums2) {
            // 如果nums2中的元素在哈希表中存在，则将其添加到结果中
            if (hashSet.count(num) > 0) {
                result.insert(num);
            }
        }

        return vector<int>(result.begin(), result.end());
    }
};
//leetcode submit region end(Prohibit modification and deletion)
