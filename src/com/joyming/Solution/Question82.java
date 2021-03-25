package com.joyming.Solution;

import com.joyming.Data.ListNode;

/**
 * 82.删除排序链表中的重复元素 II (Medium)
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 返回同样按升序排列的结果链表。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * <p>
 * <p>
 * 示例 2：
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 * <p>
 * 提示：
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 */
public class Question82 {

    /**
     * 画图解题是最直观的
     * 链表的题通常需要注意两点：
     * <p>
     * 1、舍得用变量，千万别想着节省变量，否则容易被逻辑绕晕
     * 2、head 有可能需要改动时，先增加一个 假head，返回的时候直接取 假head.next，这样就不需要为修改 head 增加一大堆逻辑了。因为首节点可能会被删掉，所以需要哑节点的创建
     * 空节点的判断，防止运行错误
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            if (current.next.val == current.next.next.val) {
                int x = current.next.val;
                while (current.next != null && current.next.val == x) {
                    current.next = current.next.next;
                }
            } else {
                current = current.next;
            }
        }
        return dummy.next;
    }

    /**
     * 递归的方法
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode answer = new ListNode(-1);
        answer.next = head;
        ListNode previous = answer;
        ListNode current = head;
        ListNode next = current.next;

        while (next != null) {
            if (current.val == next.val) {
                ListNode newList = removeDuplication(next);
                previous.next = newList;
                current = previous.next;
                if (newList != null) {
                    next = current.next;
                } else {
                    next = null;
                }
            } else {
                previous = current;
                current = current.next;
                next = current.next;
            }
        }
        return answer.next;
    }

    private ListNode removeDuplication(ListNode head) {
        ListNode next = head.next;
        if (next == null) {
            return null;
        }
        if (head.val != next.val) {
            head = next;
        } else {
            head = removeDuplication(next);
        }
        return head;
    }


}
