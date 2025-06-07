
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        ListNode* fast = head;
        ListNode* slow = head;

        while (fast != nullptr && fast->next != nullptr) {
            slow = slow->next; // 慢指针每次走一步
            fast = fast->next->next; // 快指针每次走两步

            if (slow == fast) { // 快慢指针相遇
                // 初始化两个新指针：index1从相遇点出发，index2从链表头出发
               ListNode* index1 = fast;
               ListNode* index2 = head;

                // 两指针每次移动一步，直到相遇
                // 根相遇点即为环的入口
                while (index1 != index2) {
                    index1 = index1->next;
                    index2 = index2->next;
                }

                // 返回环的入口节点
                return index1;
            }
        }

        // 如果循环结束仍未相遇，说明链表无环，返回nullptr
        return nullptr;
    }
};
//leetcode submit region end(Prohibit modification and deletion)
