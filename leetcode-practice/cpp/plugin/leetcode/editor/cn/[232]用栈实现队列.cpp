
//leetcode submit region begin(Prohibit modification and deletion)
class MyQueue {
private:
    stack<int> stackIn;
    stack<int> stackOut;

public:
    MyQueue() {
        
    }
    
    void push(int x) {
        stackIn.push(x);
    }
    
    int pop() {
        // 输出栈为空，则将输入栈的元素依次弹出并压入输出栈
        if (stackOut.empty()) {
            while (!stackIn.empty()) {
                stackOut.push(stackIn.top());
                stackIn.pop();
            }
        }

        int top = stackOut.top();
        stackOut.pop();
        return top;
    }
    
    int peek() {
        int pop = this->pop();
        stackOut.push(pop);
        return pop;
    }
    
    bool empty() {
        return stackIn.empty() && stackOut.empty();
    }
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */
//leetcode submit region end(Prohibit modification and deletion)
