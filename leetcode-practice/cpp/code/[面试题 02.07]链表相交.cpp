
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
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        // 初始化两个指针分别指向链表A和链表B的头节点
        ListNode *currentA = headA; // 用于遍历链表A
        ListNode *currentB = headB; // 用于遍历链表B

        int lenA = 0; // 记录链表A的长度
        int lenB = 0; // 记录链表B的长度

        // 遍历链表A，计算其长度
        while (currentA != nullptr) {
            lenA++;
            currentA = currentA->next;
        }
        // 遍历链表B，计算其长度
        while (currentB != nullptr) {
            lenB++;
            currentB = currentB->next;
        }

        // 重置指针currentA和currentB到各自链表的头部
        currentA = headA;
        currentB = headB;

        // 如果链表A比链表B长，交换两个指针和长度，确保链表B是较长的那个
        // 为什么需要交换
        // 目标：让两个链表的遍历指针能够同时到达链表末尾（若无交点）或同时到达交点（若有交点）
        // 如果链表A比链表B长，直接让指针从头部开始遍历时，链表A的指针会先到达末尾，无法对齐剩余部分
        // 交换指针和长度，统一处理逻辑，只需关注链表B较长的情况
        if (lenA > lenB) {
            swap(currentA, currentB);
            swap(lenA, lenB);
        }

        // 计算两个链表的长度差
        int diff = lenB - lenA;

        // 让较长的链表B的指针先移动diff步，使得两个指针之后的长度相同
        while (diff--) {
            currentB = currentB->next;
        }

        // 同时遍历两个链表，寻找相交节点
        while (currentB != nullptr) {
            // 如果两个指针指向同一个节点，说明找到了相交节点
            if (currentB == currentA) {
                return currentB;
            }
            // 否则，继续移动指针
            currentA = currentA->next;
            currentB = currentB->next;
        }

        // 遍历结束仍未找到相交节点，返回nullptr
        return nullptr;
    }
};
//leetcode submit region end(Prohibit modification and deletion)
