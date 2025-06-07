
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        // 如果矩阵为空，则返回空数组
        if (matrix.size() == 0 || matrix[0].size() == 0) {
            return {};
        }

        // 获取矩阵的行数和列数
        int rows = matrix.size();
        int columns = matrix[0].size();

        // 定义结果数组
        vector<int> result;

        // 定义每一层的起始和结束位置
        int left = 0, right = columns - 1;
        int top = 0, bottom = rows - 1;

        // 按层模拟遍历
        while (left <= right && top <= bottom) {
            // 从左到右遍历上边
            for (int i = left; i <= right; i++) {
                result.push_back(matrix[top][i]);
            }
            top++; // 上边遍历完毕，上边界下移

            // 从上到下遍历右边
            for (int i = top; i <= bottom; i++) {
                result.push_back(matrix[i][right]);
            }
            right--; // 右边遍历完毕，右边界左移

            // 从右到左遍历下边
            if (top <= bottom) { // 如果遍历的层数在bottom之下，才遍历下边，受到bottom--;限制
                for (int i = right; i >= left; i--) {
                    result.push_back(matrix[bottom][i]);
                }
                bottom--; // 下边遍历完毕，下边界上移
            }

            // 从下到上遍历左边
            if (left <= right) { // 如果遍历的列数在right之下，才遍历左边，受到left++;限制
                for (int i = bottom; i >= top; i--) {
                    result.push_back(matrix[i][left]);
                }
                left++; // 左边遍历完毕，左边界右移
            }
        }

        return result;
    }
};
//leetcode submit region end(Prohibit modification and deletion)
