
//leetcode submit region begin(Prohibit modification and deletion)
class MyStack {
private:
    queue<int> q1;
    queue<int> q2;
public:
    MyStack() {
        
    }
    
    void push(int x) {
        q1.push(x); // 将元素x加入到队列q1中
    }
    
    int pop() { // 从栈顶移除并返回元素。
        int size = q1.size(); // 获取当前q1中的元素数量。
        size--; // 因为需要留下最后一个元素作为"栈顶"来返回，所以先减去1。

        while (size--) { // 将q1中的前n-1个元素移到q2中。
            q2.push(q1.front()); // 取出q1的第一个元素并将其放入q2。
            q1.pop(); // 移除q1的第一个元素。
        }

        int res = q1.front(); // 此时q1只剩下一个元素，即为栈顶元素。
        q1.pop(); // 移除栈顶元素。
        while (!q2.empty()) { // 将q2中的所有元素重新放回q1中。
            q1.push(q2.front()); // 将q2的第一个元素放入q1。
            q2.pop(); // 移除q2的第一个元素。
        }

        return res; // 返回之前保存的栈顶元素。
    }

    int top() { // 返回栈顶元素但不移除它。
        int size = q1.size(); // 获取当前q1中的元素数量。
        size--; // 减1，因为要将除了最后一个元素之外的所有元素移动到q2。
        while (size--) { // 类似于pop操作，将q1中的前n-1个元素移到q2中。
            q2.push(q1.front());
            q1.pop();
        }

        int res = q1.front(); // 获取q1剩下的那个元素（即栈顶元素）。
        q2.push(q1.front()); // 将这个元素也加到q2中，以便保留栈顶元素。
        q1.pop(); // 移除q1中的这个元素。

        q1 = q2; // 将q2赋值给q1，以保持元素顺序不变。
        while (!q2.empty()) { // 清空q2。
            q2.pop();
        }

        return res; // 返回栈顶元素。
    }

    bool empty() { // 判断栈是否为空。
        return q1.empty(); // 如果q1为空，则栈为空。
    }
};

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack* obj = new MyStack();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->top();
 * bool param_4 = obj->empty();
 */
//leetcode submit region end(Prohibit modification and deletion)
