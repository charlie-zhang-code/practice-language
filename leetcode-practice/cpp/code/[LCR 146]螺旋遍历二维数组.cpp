
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    vector<int> spiralArray(vector<vector<int>>& array) {
        if (array.size() == 0 || array[0].size() == 0) {
            return {};
        }

        int rows = array.size(); // 行数
        int cols = array[0].size(); // 列数

        vector<int> result; // 存放结果

        int left = 0, right = cols - 1;
        int top = 0, bottom = rows - 1;

        while (left <= right && top <= bottom) {
            // 从左到右遍历
            for (int i = left; i <= right; i++) {
                result.push_back(array[top][i]);
            }
            top++;

            // 从上到下遍历
            for (int i = top; i <= bottom; i++) {
                result.push_back(array[i][right]);
            }
            right--;

            // 判断是否越界
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.push_back(array[bottom][i]);
                }
                bottom--;
            }

            // 判断是否越界
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.push_back(array[i][left]);
                }
                left++;
            }
        }

        return result;
    }
};
//leetcode submit region end(Prohibit modification and deletion)
