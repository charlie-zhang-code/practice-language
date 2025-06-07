
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* removeElements(ListNode* head, int val) {
        // 虚拟头结点
        ListNode* dummy = new ListNode(-1);
        // 虚拟头结点的next指向head
        dummy->next = head;
        // 当前结点指向虚拟头结点
        ListNode* current = dummy;

        // 如果当前结点的next存在才会遍历
        while (current->next) {
            // 如果当前结点的next的值等于val
            if (current->next->val == val) {
               // 临时结点指向当前结点的next
               ListNode* temp = current->next;
               // 当前结点的next指向当前结点的next的下一个结点
               current->next = current->next->next;
               // 释放临时结点的内存
               delete temp;
            } else {
                // 如果当前结点的next的值不等于val
                // 当前结点向后移动一位
                current = current->next;
            }
        }

        // 重新指向头结点
        head = dummy->next;
        // 释放虚拟头结点的内存
        delete dummy;
        return head;
    }
};
//leetcode submit region end(Prohibit modification and deletion)
