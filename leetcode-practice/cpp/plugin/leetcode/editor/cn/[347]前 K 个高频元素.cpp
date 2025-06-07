
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
private:
    // 自定义比较类，用于优先队列的排序规则
    class Comparison {
    public:
        // 重载函数调用运算符，定义pair的比较规则
        // 按pair的second值（即频率）进行升序排列
        bool operator()(pair<int, int> &a, pair<int, int> &b) {
            return a.second > b.second;  // 注意：使用>实现最小堆
        }
    };

public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        // 第一步：统计每个数字出现的频率
        unordered_map<int, int> map;  // key:数字, value:出现次数
        for (int num : nums) {
            map[num]++;  // 统计频率
        }

        // 第二步：使用优先队列（最小堆）找出前k高频元素
        // 优先队列模板参数：存储类型、底层容器、比较类
        priority_queue<pair<int, int>, vector<pair<int, int>>, Comparison> pq;

        // 遍历频率统计map
        for (auto it = map.begin(); it != map.end(); it++) {
            pq.push(*it);  // 将当前数字及其频率加入优先队列
            // 保持队列大小为k，当超过k时弹出频率最小的元素
            if (pq.size() > k) {
                pq.pop();
            }
        }

        // 第三步：收集结果
        vector<int> res;
        while (!pq.empty()) {
            // 从队列中取出元素，其first是数字，second是频率
            res.push_back(pq.top().first);
            pq.pop();
        }

        return res;
    }
};
//leetcode submit region end(Prohibit modification and deletion)
