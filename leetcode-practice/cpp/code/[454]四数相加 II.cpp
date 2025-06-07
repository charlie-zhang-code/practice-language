
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    int fourSumCount(vector<int>& nums1, vector<int>& nums2, vector<int>& nums3, vector<int>& nums4) {
        // 创建哈希表mp，键为nums1和nums2中两数之和，值为该和出现的次数
        unordered_map<int, int> mp;

        // 双重循环遍历nums1和nums2，计算所有两数之和
        for (int i = 0; i < nums1.size(); i++) {
            for (int j = 0; j < nums2.size(); j++) {
                // 将当前两数之和的出现次数加1
                mp[nums1[i] + nums2[j]]++;
            }
        }

        // 创建变量ans，用于记录四数之和为0的个数
        int ans = 0;

        // 双重循环遍历nums3和nums4，计算所有两数之和的相反数
        for (int i = 0; i < nums3.size(); i++) {
            for (int j = 0; j < nums4.size(); j++) {
                // 在哈希表中查找是否存在-(nums3[i]+nums4[j])的和
                // 如果存在，则将该和的出现次数累加到ans中
                ans += mp[-(nums3[i] + nums4[j])];
            }
        }

        // 返回满足条件的元组数量
        return ans;
    }
};
//leetcode submit region end(Prohibit modification and deletion)
