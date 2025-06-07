//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> result; // 存储最终结果的二维数组
        // 排序：使数组有序，便于使用双指针法和去重（时间复杂度O(nlogn)）
        sort(nums.begin(), nums.end());

        // 遍历数组
        // a + b + c = 0
        // a = nums[i]，b = nums[left]，c = nums[right]
        // 外层循环固定第一个数a（时间复杂度O(n)）
        for (int i = 0; i < nums.size(); i++) {
            // 排序后，如果当前元素大于0（第一个），则后面不可能有满足条件的三元组
            // 剪枝优化：若a>0，由于数组已排序，后续b、c必然>0，不可能满足a+b+c=0
            if (nums[i] > 0) {
                return result;
            }

            // 去重：跳过连续相同的a值，避免重复三元组（如[-1,-1,0,1]）
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 初始化双指针：left指向i+1（b），right指向末尾（c）
            int left = i + 1;
            int right = nums.size() - 1;

            // 双指针遍历（时间复杂度O(n)）
            while (left < right) {
                 // 如果当前元素加上左右指针指向的元素之和大于0，则right向左移动
                 if (nums[i] + nums[left] + nums[right] > 0) {
                     right--;  // 和过大，右指针左移
                 }
                 // 如果当前元素加上左右指针指向的元素之和小于0，则left向右移动
                 else if (nums[i] + nums[left] + nums[right] < 0) {
                     left++; // 和过小，左指针右移
                 }
                 // 如果当前元素加上左右指针指向的元素之和等于0，则将结果添加到结果中
                 else {
                     // 找到有效三元组
                     result.push_back({nums[i], nums[left], nums[right]});

                     // 对左右指针指向的元素进行去重，跳过所有相邻重复的b和c
                     while (left < right && nums[left] == nums[left + 1]) {
                         left++;
                     }
                     while (left < right && nums[right] == nums[right - 1]) {
                         right--;
                     }

                     // 找到了一个满足条件的三元组，则继续寻找下一个满足条件的三元组，移动指针继续寻找其他可能组合
                     left++;
                     right--;
                 }
            }
        }

        // 总时间复杂度O(n²)
        return result;
    }
};
//leetcode submit region end(Prohibit modification and deletion)
