package com.joyming.Solution;

import com.joyming.Data.ListNode;

/**
 * 147. 对链表进行插入排序
 * 对链表进行插入排序。
 * <p>
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 * <p>
 * 插入排序算法：
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 * <p>
 * 示例 1：
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * <p>
 * 示例 2：
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class Question147 {

    /**
     * 链表的插入排序
     * 时间复杂度：O(n^2)，其中 nn 是链表的长度。
     * 空间复杂度：O(1)
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        //方便插入头节点
        dummyHead.next = head;
        //当前节点，从第二个节点开始
        ListNode currentNode = head.next;
        //链表的上一个节点
        ListNode lastIndex = head;
        while (currentNode != null) {
            if (lastIndex.val <= currentNode.val) {
                lastIndex = lastIndex.next;
            } else {
                //找到需要插入的位置
                ListNode pre = dummyHead;
                while (pre.next.val < currentNode.val) {
                    pre = pre.next;
                }
                //画图更直观，三步操作完成插入过程
                lastIndex.next = currentNode.next;
                currentNode.next = pre.next;
                pre.next = currentNode;
            }
            currentNode = lastIndex.next;
        }
        return dummyHead.next;
    }
}
