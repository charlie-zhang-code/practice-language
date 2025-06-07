
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
    ListNode* swapPairs(ListNode* head) {
        ListNode* dummy = new ListNode(-1); // 创建一个虚拟节点，指向头结点
        dummy->next = head;
        ListNode* current = dummy; // 当前节点

        // 第一个节点和第二个节点是否为空，为空的话，交换过后会出现链表断链，而第三个嗯节点可以为空，为空就说明交换完了，到了尾部
        while (current->next != nullptr && current->next->next != nullptr) {
            // 第一个节点
            ListNode* tempNext = current->next;
            // 第三个节点
            ListNode* tempNextNextNext = current->next->next->next;

            // 虚拟节点指向第一个节点的下一个节点（第二个节点）
            current->next = current->next->next;
            // 现在的第一个节点（原本的第二个节点）指向现在的第二个节点（原本的第一个节点）
            current->next->next = tempNext;
            // 现在的第二个节点（原本的第一个节点）指向第三个节点
            current->next->next->next = tempNextNextNext;

            // 跳过交换的两个节点，往后移动，开始新的交换
            current = current->next->next;
        }

        ListNode* result = dummy->next; // 返回结果
        delete dummy; // 释放虚拟节点
        return result;
    }
};
//leetcode submit region end(Prohibit modification and deletion)
