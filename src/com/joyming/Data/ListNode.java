package com.joyming.Data;

/**
 * 链表
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        this.val = x;
    }

    public ListNode(int x,ListNode next) {
        val = x;
        this.next = next;
    }
}