
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        vector<vector<int>> result; // 存储最终结果的二维数组
        // 排序：使数组有序，便于使用双指针法和去重
        sort(nums.begin(), nums.end());

        // 第一层循环固定第一个数a（时间复杂度O(n)）
        for (int i = 0; i < nums.size(); i++) {
            // 剪枝优化：若a>target且a>0，由于数组已排序，后续b、c、d必然更大，不可能满足条件
            if (nums[i] > 0 && nums[i] > target) {
                break;
            }

            // 去重：跳过连续相同的a值，避免重复四元组（如[2,2,2,2]）
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 第二层循环固定第二个数b（时间复杂度O(n)）
            for (int j = i + 1; j < nums.size(); j++) {
                // 二级剪枝：若a+b>target且a+b>=0，后续组合必然更大
                if (nums[i] + nums[j] > target && nums[i] + nums[j] >= 0) {
                    break;
                }

                // 去重：跳过连续相同的b值
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // 初始化双指针：left指向j+1（c），right指向末尾（d）
                int left = j + 1;
                int right = nums.size() - 1;

                // 双指针遍历（时间复杂度O(n)）
                while (left < right) {
                    // 使用long防止整数溢出（测试用例可能极大）
                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum > target) {
                        right--; // 和过大，右指针左移
                    } else if (sum < target) {
                        left++; // 和过小，左指针右移
                    } else {
                        // 找到一组满足条件的结果，添加到结果数组中
                        result.push_back({nums[i], nums[j], nums[left], nums[right]});

                        // 去重处理：跳过所有相邻重复的c和d
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        // 移动指针继续寻找其他可能组合
                        left++;
                        right--;
                    }
                }
            }
        }

        // 总时间复杂度O(n³)
        return result;
    }
};
//leetcode submit region end(Prohibit modification and deletion)
