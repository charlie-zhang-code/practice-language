
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
private:
    // 自定义队列类，用于维护当前窗口中的最大值
    class MyQueue {
    public:
        deque<int> q;  // 使用双端队列存储可能成为窗口最大值的元素

        // 弹出元素：只有当要弹出的元素是当前最大值时才真正弹出
        void pop(int val) {
            if (!q.empty() && q.front() == val) {
                q.pop_front();
            }
        }

        // 压入元素：维护队列单调递减，移除所有小于当前值的元素
        void push(int val) {
            while (!q.empty() && q.back() < val) {
                q.pop_back();
            }
            q.push_back(val);
        }

        // 获取当前窗口的最大值（即队列首部元素）
        int front() {
            return q.front();
        }
    };

public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        MyQueue q;  // 创建自定义队列实例

        vector<int> res;  // 存储结果的向量

        // 初始化第一个窗口
        for (int i = 0; i < k; i++) {
            q.push(nums[i]);  // 将前k个元素加入队列
        }
        res.push_back(q.front());  // 记录第一个窗口的最大值

        // 滑动窗口处理剩余元素
        for (int i = k; i < nums.size(); i++) {
            q.pop(nums[i - k]);  // 移除离开窗口的元素
            q.push(nums[i]);      // 添加新进入窗口的元素
            res.push_back(q.front());  // 记录当前窗口的最大值
        }

        return res;  // 返回所有窗口的最大值集合
    }
};
//leetcode submit region end(Prohibit modification and deletion)
