
//leetcode submit region begin(Prohibit modification and deletion)
class MyLinkedList {
public:
    // 节点结构
    struct Node {
        int val;
        Node *next;
        Node(int x) : val(x), next(nullptr) {}
    };

    MyLinkedList() {
        dummy = new Node(-1);
        size = 0;
    }
    
    int get(int index) {
        // 判断下标是否越界
        if (index > size - 1 || index < 0) {
            return -1;
        }

        // 遍历到指定位置
        Node *current = dummy->next;
        while (index--) {
            current = current->next;
        }

        return current->val;
    }
    
    void addAtHead(int val) {
        Node *node = new Node(val);

        node->next = dummy->next;
        dummy->next = node;
        size++;
    }
    
    void addAtTail(int val) {
        Node *node = new Node(val);

        Node *current = dummy;
        while (current->next != nullptr) {
            current = current->next;
        }
        current->next = node;
        size++;
    }
    
    void addAtIndex(int index, int val) {
        // 判断下标是否越界
        if (index > size) {
            return;
        }
        // 下标为负数，则添加到头部
        if (index < 0) {
            index = 0;
        }

        // 遍历到指定位置
        Node *current = dummy;
        while (index--) {
            current = current->next;
        }

        // 添加节点
        Node *node = new Node(val);
        node->next = current->next;
        current->next = node;
        size++;
    }
    
    void deleteAtIndex(int index) {
        // 判断下标是否越界
        if (index >= size || index < 0) {
            return;
        }

        // 遍历到指定位置
        Node *current = dummy;
        while (index--) {
            current = current->next;
        }

        Node *delNode = current->next;
        current->next = delNode->next;
        delete delNode;
        // 释放节点，因为delete后地址并非 nullptr
        delNode = nullptr;
        size--;
    }

private:
    int size; // 链表长度
    Node *dummy; // 虚拟头结点
};

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList* obj = new MyLinkedList();
 * int param_1 = obj->get(index);
 * obj->addAtHead(val);
 * obj->addAtTail(val);
 * obj->addAtIndex(index,val);
 * obj->deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)
