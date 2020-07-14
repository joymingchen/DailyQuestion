package com.joyming.Solution;

import com.joyming.data.ListNode;

/**
 * 剑指offer第24题
 * 反转一个单链表。
 * <p>
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class Question206 {

    /**
     * 递归算法
     * recursion
     * 递归可能会造成栈溢出
     */
    public ListNode reverseList(ListNode head) {
        //首先找到终止条件
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = reverseList(head.next);
        //反转结点
        head.next.next = head;
        //断开下一个结点
        head.next = null;
        return cur;
    }

    /**
     * 迭代算法，双指针
     * 时间复杂度：O(n)
     */
    public ListNode reverseList2(ListNode head) {

        //定义两个指针
        ListNode pre = null;
        ListNode cur = head;
        //记录下一个位置
        ListNode tmp = null;

        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;

            //向后移动
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
