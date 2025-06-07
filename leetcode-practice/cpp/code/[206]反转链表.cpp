
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
    ListNode* reverseList(ListNode* head) {
        ListNode* temp = nullptr; // 暂存当前节点的下一个节点
        ListNode* current = head; // 当前节点
        ListNode* prev = nullptr; // 上一个节点

        // 循环遍历链表，将当前节点的下一个节点指向上一个节点，并更新上一个节点和当前节点
        while (current != nullptr) {
            temp = current->next; // 暂存当前节点的下一个节点
            current->next = prev; // 将当前节点的下一个节点指向上一个节点
            prev = current; // 更新上一个节点
            current = temp; // 更新当前节点
        }

        return prev;
    }
};
//leetcode submit region end(Prohibit modification and deletion)
