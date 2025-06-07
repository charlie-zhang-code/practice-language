
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
private:
    int getSum(int n) {
        // 初始化总和变量，用于存储各位数字平方的和
        int totalSum = 0;
        // 非零数字，计算各位数字平方的和
        while (n) {
            // 取n的个位数：通过模10运算得到当前最低位的数字
            int d = n % 10;
            // 累加平方和：将当前数字的平方加到总和中
            totalSum += d * d;
            // 移除已处理的位数：通过整除10去掉最低位（相当于右移一位）
            n /= 10;
        }
        // 返回总和
        return totalSum;
    }
public:
    bool isHappy(int n) {
        // 哈希集合，记录已出现的数字以检测循环
        unordered_set<int> seen;

        // 无限循环，通过内部条件退出
        while(true) {
            // 计算当前数字的各位平方和
            int sum = getSum(n);

            // 终止条件1：平方和为1，是快乐数
            // 当平方和计算结果为1时，说明该数满足快乐数定义（最终收敛到1）
            // 根据快乐数定义，若某次计算后结果为1，后续计算会一直保持1（因为1^2=1），此时确认是快乐数
            if (sum == 1) {
                return true;
            }

            // 终止条件2：平方和已存在于集合中，检测到循环
            // 测当前平方和sum是否已在集合seen中存在。若存在，说明进入无限循环，返回false
            // seen.find(sum)返回一个迭代器（iterator），指向集合中等于sum的元素，如果没有找到，返回seen.end()，如果找到，返回一个迭代器指向该元素
            if (seen.find(sum) != seen.end()) {
                return false;
            }

            // 将当前平方和加入集合，标记为已访问
            seen.insert(sum);

            // 更新n为本次计算的平方和，继续下一轮判断
            n = sum;
        }
    }
};
//leetcode submit region end(Prohibit modification and deletion)
