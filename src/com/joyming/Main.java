package com.joyming;

public class Main {

    public static void main(String[] args) {
        Question2.ListNode listNode = new Question2.ListNode(2);
        listNode.next = new Question2.ListNode(4);
        listNode.next.next = new Question2.ListNode(3);

        Question2.ListNode listNode2 = new Question2.ListNode(5);
        listNode2.next = new Question2.ListNode(6);
        listNode2.next.next = new Question2.ListNode(4);

        Question2.ListNode newList = new Question2().addTwoNumbersReverse(listNode,listNode2);

        while (newList != null) {
            System.out.print(newList.val);

            newList = newList.next;
        }
    }
}
