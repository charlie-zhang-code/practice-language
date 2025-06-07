
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        vector<vector<int>> result(n, vector<int>(n, 0)); // 定义二维数组 n*n

        // 开始位置
        int XRay = 0, YRay = 0; // y轴

        int loopCount = n / 2, middle = n / 2; // 中间位置

        int xTemp = 0, yTemp = 0; // 临时记录y轴

        int num = 1; // 计数器
        int offset = 1; // 控制每一圈（即每一层螺旋）中每条边遍历的长度

        // 循环次数
        while (loopCount--) {
            xTemp = XRay, yTemp = YRay; // 为什么会有这个临时变量呢，因为每次循环完之后，x轴和y轴都会发生变化，所以每次循环完之后，x轴和y轴都会恢复到初始位置

            // 循环每一层螺旋的每一条边
            // 左往右
            // 这里要注意，x是横坐标，y是纵坐标，左往右是固定x的变化，变化的是y轴
            for (yTemp; yTemp < n - offset; yTemp++) {
                result[xTemp][yTemp] = num++;
            }

            // 上往下，这里要注意，x是横坐标，y是纵坐标，上往下是固定y的变化，变化的是x轴
            for (xTemp; xTemp < n - offset; xTemp++) {
                 result[xTemp][yTemp] = num++;
            }

            // 右往左，右往左是固定x的变化，变化的是y轴
            for (yTemp; yTemp > YRay; yTemp--) {
                 result[xTemp][yTemp]= num++;
            }

            // 下往上，下往上是固定y的变化，变化的是x轴
            for (xTemp; xTemp > XRay; xTemp--) {
                result[xTemp][yTemp] = num++;
            }

            XRay++, YRay++, offset++;
        }

        // 奇数时，中间位置赋值
        if (n % 2 != 0) {
            result[middle][middle] = num;
        }

        return result;
    }
};
//leetcode submit region end(Prohibit modification and deletion)
