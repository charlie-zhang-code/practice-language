
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        // 创建一个哈希表mp，键为数组元素值，值为对应的索引
        unordered_map<int, int> mp;

        // 遍历数组nums
        for (int i = 0; i < nums.size(); i++) {
            // 检查哈希表中是否存在键为(target - nums[i])的元素
            if (mp.count(target - nums[i])) {
                // 如果存在，返回当前找到的两个数的索引
                // mp[target - nums[i]]是之前存储的索引，i是当前索引
                return {mp[target - nums[i]], i};
            }

            // 将当前元素的值作为键，索引作为值存入哈希表
            mp[nums[i]] = i;
        }

        // 如果没有找到符合条件的两个数，返回空数组
        return {};
    }
};
//leetcode submit region end(Prohibit modification and deletion)
