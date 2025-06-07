
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
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode* dummy = new ListNode(0);
        dummy->next = head;

        ListNode* slow = dummy;
        ListNode* fast = dummy;

        // 快指针先走 n 步
        while (n-- && fast != nullptr) {
            fast = fast->next;
        }
        // fast 指向第 n + 1 个节点，让slow处于被删除节点的前一个节点
        fast = fast->next;

        // 快慢指针同时走，当fast为空时，slow处于倒数第 n 个节点的前一个节点
        while (fast != nullptr) {
            fast = fast->next;
            slow = slow->next;
        }

        // 删除倒数第 n 个节点
        ListNode* temp = slow->next;
        slow->next = slow->next->next;
        delete temp;

        ListNode* result = dummy->next;
        delete dummy;
        return result;
    }
};
//leetcode submit region end(Prohibit modification and deletion)
