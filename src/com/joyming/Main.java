package com.joyming;

import com.joyming.Solution.Question206;
import com.joyming.Solution.Question415;
import com.joyming.Solution.Question5;
import com.joyming.data.ListNode;

public class Main {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

//        ListNode listNode = new ListNode(1);
//        listNode.next = new ListNode(2);
//        listNode.next.next = new ListNode(3);
//        listNode.next.next.next = new ListNode(4);
//        listNode.next.next.next.next = new ListNode(5);
//
//        ListNode newList = new Question206().reverseList2(listNode);

//        while (newList != null) {
//            System.out.print(newList.val);
//            newList = newList.next;
//
//            if(newList != null){
//                System.out.print(" --> ");
//            }
//        }


        System.out.print(new Question415().addStrings("1","9"));

        long endTime = System.currentTimeMillis();
        System.out.println("\n\n执行时间:" + (endTime - startTime) + "ms");
    }
}
