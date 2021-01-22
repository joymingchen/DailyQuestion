package com.joyming;

import com.joyming.Solution.*;
import com.joyming.Data.ListNode;
import com.joyming.Data.TreeNode;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

//        ListNode listNode = new ListNode(-1);
//        listNode.next = new ListNode(5);
//        listNode.next.next = new ListNode(3);
//        listNode.next.next.next = new ListNode(4);
//        listNode.next.next.next.next = new ListNode(0);
////
//        ListNode newList = new Question147().insertionSortList(listNode);
//
//        while (newList != null) {
//            System.out.print(newList.val);
//            newList = newList.next;
//
//            if(newList != null){
//                System.out.print(" --> ");
//            }
//        }

        int[][] A = new int[][]{{1, 1, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] B = new int[]{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 20, 5, 5, 5, 5, 5, 5, 5, 10, 5, 20, 20, 5, 5, 5, 5, 5, 10, 5, 5, 5, 20, 5, 5, 5, 10, 5, 5, 10, 5, 20, 5, 5, 20, 5, 10, 5, 5, 20, 5, 5, 5, 5, 5, 5, 10, 20, 5, 20, 20, 10, 5, 20, 20, 5, 10, 5, 5, 5, 5, 5, 5, 20, 20, 20, 20, 5, 5, 10, 5, 20, 5, 5, 5, 5, 10, 10, 5, 5, 5, 20, 5, 5, 5, 5, 5, 5, 20, 5, 20, 10, 10, 20, 5, 5, 5, 5, 20, 20, 5, 5, 5, 5, 20, 5, 20, 20, 5, 5, 10, 5, 5, 5, 20, 5, 5, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 20, 5, 5, 10, 20, 20, 5, 5, 10, 20, 5, 5, 5, 5, 10, 20, 5, 5, 10, 20, 5, 10, 10, 5, 5, 5, 5, 5, 5, 10, 10, 10, 5, 10, 5, 10, 5, 5, 10, 10, 5, 5, 5, 20, 5, 20, 10, 20, 5, 5, 5, 20, 10, 5, 5, 20, 5, 5, 5, 10, 5, 5, 10, 5, 5, 20, 5, 10, 10, 5, 5, 10, 5, 5, 10, 5, 10, 5, 20, 10, 5, 10, 10, 5, 5, 5, 5, 10, 5, 5, 5, 20, 5, 5, 5, 5, 10, 5, 10, 10, 5, 20, 20, 5, 10, 10, 10, 5, 10, 5, 10, 5, 10, 5, 5, 10, 5, 5, 5, 20, 5, 5, 20, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 20, 5, 5, 5, 5, 10, 5, 5, 5, 20, 5, 5, 5, 5, 10, 20, 5, 5, 5, 20, 20, 5, 10, 5, 5, 5, 10, 5, 10, 20, 20, 5, 5, 5, 5, 5, 5, 20, 10, 5, 10, 5, 5, 20, 10, 5, 5, 5, 20, 5, 5, 5, 5, 5, 5, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 10, 5, 10, 5, 10, 20, 10, 10, 5, 5, 20, 10, 20, 5, 5, 5, 10, 5, 5, 5, 10, 5, 20, 20, 20, 10, 20, 5, 5, 5, 5, 20, 5, 20, 5, 10, 5, 5, 5, 5, 5, 5, 20, 5, 10, 5, 5, 5, 20, 5, 5, 5, 10, 10, 5, 5, 5, 5, 5, 20, 20, 20, 5, 5, 5, 5, 20, 5, 20, 5, 20, 20, 10, 10, 5, 5, 5, 20, 10, 20, 10, 20, 5, 20, 5, 5, 5, 10, 10, 5, 5, 5, 5, 10, 10, 5, 5, 5, 5, 20, 5, 5, 5, 5, 5, 20, 10, 20, 20, 5, 20, 10, 5, 5, 20, 5, 5, 10, 5, 5, 5, 5, 10, 5, 5, 5, 20, 5, 10, 5, 10, 10, 20, 5, 20, 5, 20, 10, 5, 5, 5, 20, 5, 10, 10, 5, 5, 10, 5, 10, 5, 5, 20, 20, 5, 5, 5, 5, 5, 5, 5, 5, 20, 5, 10, 5, 10, 20, 20, 5, 5, 20, 5, 10, 5, 20, 5, 20, 20, 5, 5, 5, 20, 20, 20, 5, 5, 5, 5, 20, 10, 5, 5, 10, 10, 10, 5, 10, 5, 10, 5, 20, 5, 5, 5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 20, 20, 10, 10, 5, 5, 20, 5, 5, 5, 5, 20, 20, 20, 20, 5, 5, 20, 20, 5, 20, 5, 5, 5, 10, 20, 10, 5, 20, 5, 5, 5, 5, 10, 10, 5, 10, 5, 5, 10, 5, 5, 20, 10, 20, 5, 5, 5, 10, 5, 5, 10, 10, 5, 20, 5, 5, 20, 5, 5, 20, 10, 10, 5, 5, 10, 5, 5, 20, 5, 10, 5, 20, 20, 10, 10, 20, 5, 5, 5, 20, 5, 5, 20, 20, 10, 20, 10, 10, 5, 20, 10, 5, 10, 5, 10, 5, 5, 20, 5, 20, 20, 5, 5, 5, 5, 20, 10, 5, 5, 5, 5, 5, 20, 5, 5, 20, 10, 5, 5, 5, 5, 5, 5, 10, 5, 10, 5, 20, 20, 20, 20, 5, 5, 20, 5, 5, 5, 20, 5, 20, 5, 5, 5, 10, 5, 20, 5, 5, 5, 5, 20, 5, 20, 20, 5, 5, 5, 5, 10, 5, 20, 20, 5, 20, 5, 10, 5, 5, 5, 5, 20, 5, 5, 5, 20, 20, 5, 5, 5, 20, 10, 20, 5, 5, 10, 5, 5, 10, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 20, 5, 20, 10, 20, 20, 5, 5, 10, 10, 5, 10, 10, 5, 5, 10, 10, 5, 5, 5, 5, 5, 10, 5, 20, 5, 10, 5, 20, 10, 5, 10, 5, 10, 20, 10, 5, 5, 5, 20, 5, 5, 20, 5, 5, 5, 5, 5, 10, 10, 20, 20, 20, 5, 20, 20, 5, 20, 5, 5, 5, 5, 5, 5, 20, 5, 5, 5, 5, 10, 5, 5, 5, 5, 10, 20, 20, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 20, 20, 5, 5, 5, 5, 5, 5, 20, 5, 5, 5, 20, 5, 5, 20, 5, 5, 5, 5, 5, 5, 5, 10, 5, 10, 5, 5, 5, 20, 5, 5, 5, 20, 5, 20, 5, 20, 10, 5, 5, 5, 5, 10, 5, 10, 5, 20, 20, 10, 5, 5, 20, 10, 10, 5, 10, 20, 5, 5, 5, 10, 5, 20, 5, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 5, 20, 5, 5, 10, 10, 5, 5, 10, 5, 10, 10, 20, 10, 20, 5, 5, 5, 10, 10, 5, 5, 20, 5, 20, 5, 5, 5, 5, 10, 5, 20, 5, 5, 5, 20, 5, 5, 10, 10, 5, 5, 5, 20, 5, 5, 10, 5, 5, 5, 5, 20, 5, 10, 5, 5, 10, 5, 10, 10, 5, 10, 10, 5, 20, 20, 5, 5, 20, 5, 5, 5, 5, 5, 20, 10, 10, 5, 10, 5, 20, 20, 5, 5, 5, 5, 5, 10, 5, 20, 10, 20, 5, 20, 5, 20, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 20, 5, 10, 5, 5, 20, 20, 5, 20, 20, 5, 5, 5, 10, 20, 5, 5, 10, 10, 5, 5, 20, 10, 20, 5, 10, 5, 5, 5, 5, 20, 5, 5, 5, 5, 20, 20, 5, 20, 5, 10, 10, 5, 10, 20, 20, 20, 5, 5, 5, 20, 5, 5, 5, 5, 5, 5, 5, 20, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 20, 5, 5, 5, 5, 20, 10, 5, 5, 5, 5, 20, 5, 5, 5, 5, 5, 5, 5, 5, 20, 10, 5, 5, 5, 5, 5, 10, 5, 20, 5, 5, 5, 5, 10, 5, 10, 20, 10, 20, 5, 5, 5, 5, 10, 5, 20, 5, 20, 5, 20, 5, 10, 5, 10, 10, 10, 5, 5, 5, 20, 20, 5, 5, 10, 10, 10, 5, 5, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 10, 5, 5, 5, 5, 5, 5, 5, 20, 10, 10, 20, 10, 5, 5, 5, 5, 5, 5, 20, 5, 5, 20, 5, 10, 5, 20, 5, 10, 5, 5, 20, 5, 5, 5, 10, 5, 5, 5, 10, 5, 5, 20, 20, 5, 5, 10, 20, 10, 20, 5, 10, 20, 5, 5, 10, 5, 20, 20, 5, 5, 5, 5, 5, 5, 5, 10, 10, 10, 5, 20, 20, 5, 5, 20, 20, 10, 20, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 20, 10, 5, 5, 5, 5, 10, 5, 10, 5, 5, 5, 5, 10, 20, 20, 5, 5, 5, 5, 20, 5, 5, 5, 5, 10, 20, 5, 5, 10, 5, 5, 10, 5, 10, 20, 20, 5, 10, 5, 10, 5, 5, 10, 10, 5, 5, 5, 5, 5, 5, 20, 5, 20, 20, 5, 5, 5, 5, 5, 10, 5, 5, 5, 5, 5, 5, 5, 20, 10, 10, 5, 5, 10, 5, 20, 5, 5, 10, 10, 20, 5, 5, 5, 20, 10, 5, 5, 5, 10, 5, 5, 5, 5, 5, 20, 5, 10, 5, 5, 10, 20, 5, 5, 20, 10, 5, 5, 20, 5, 5, 5, 5, 10, 5, 5, 5, 5, 5, 5, 10, 10, 5, 5, 5, 5, 10, 5, 20, 5, 10, 10, 5, 10, 5, 5, 5, 5, 5, 5, 10, 20, 5, 5, 20, 20, 5, 20, 10, 5, 5, 5, 10, 5, 20, 5, 5, 10, 20, 5, 5, 20, 10, 20, 10, 5, 5, 5, 10, 5, 5, 5, 5, 5, 10, 20, 10, 5, 5, 5, 5, 5, 5, 5, 5, 20, 10, 5, 20, 10, 5, 20, 10, 20, 10, 5, 20, 5, 5, 5, 5, 5, 20, 20, 10, 10, 10, 10, 5, 5, 20, 5, 10, 5, 5, 10, 20, 5, 5, 5, 5, 20, 5, 5, 5, 10, 5, 5, 10, 5, 20, 20, 10, 10, 5, 5, 10, 5, 5, 10, 5, 5, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 20, 5, 10, 5, 5, 5, 5, 10, 5, 5, 20, 10, 10, 5, 20, 20, 20, 5, 5, 5, 5, 20, 5, 10, 5, 5, 5, 5, 5, 10, 20, 5, 20, 5, 20, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 10, 5, 20, 5, 5, 20, 5, 5, 5, 5, 5, 20, 10, 5, 10, 10, 5, 20, 10, 5, 20, 20, 5, 5, 20, 5, 5, 10, 5, 5, 10, 5, 5, 10, 10, 5, 5, 20, 10, 5, 20, 5, 10, 5, 5, 5, 5, 5, 5, 20, 5, 5, 5, 20, 5, 10, 5, 10, 20, 10, 10, 5, 5, 10, 5, 20, 10, 5, 5, 5, 5, 5, 10, 5, 5, 5, 5, 5, 10, 20, 20, 5, 5, 5, 20, 5, 5, 5, 5, 10, 5, 20, 5, 5, 5, 20, 10, 5, 5, 5, 5, 10, 5, 5, 5, 10, 5, 5, 5, 5, 20, 5, 5, 5, 10, 20, 20, 20, 5, 20, 5, 10, 5, 10, 20, 5, 5, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 20, 20, 10, 5, 20, 5, 5, 5, 5, 5, 5, 10, 5, 5, 10, 5, 5, 5, 5, 20, 5, 5, 5, 20, 5, 5, 10, 5, 10, 5, 10, 20, 5, 5, 5, 5, 20, 10, 5, 5, 5, 20, 5, 10, 10, 5, 5, 10, 20, 5, 10, 5, 5, 5, 20, 10, 5, 20, 5, 5, 5, 20, 20, 10, 20, 10, 5, 20, 5, 10, 10, 20, 10, 5, 5, 10, 5, 20, 20, 5, 5, 5, 5, 10, 5, 10, 20, 20, 20, 10, 20, 5, 10, 5, 5, 5, 10, 5, 5, 5, 5, 10, 5, 5, 5, 20, 10, 20, 5, 20, 5, 5, 5, 20, 10, 5, 5, 20, 5, 10, 5, 5, 5, 10, 5, 5, 10, 10, 5, 20, 20, 20, 5, 5, 5, 5, 20, 5, 20, 20, 5, 10, 5, 20, 5, 10, 20, 5, 5, 10, 5, 5, 5, 5, 5, 10, 10, 5, 5, 5, 20, 5, 10, 5, 5, 5, 5, 5, 20, 5, 10, 10, 5, 5, 10, 20, 10, 5, 5, 5, 5, 10, 5, 5, 10, 5, 10, 5, 10, 5, 20, 5, 5, 10, 5, 20, 5, 5, 10, 5, 20, 5, 20, 20, 10, 5, 20, 10, 20, 20, 5, 20, 5, 20, 5, 5, 20, 5, 5, 5, 5, 10, 5, 5, 5, 5, 5, 5, 5, 5, 20, 20, 10, 5, 5, 20, 20, 20, 10, 20, 20, 20, 10, 10, 20, 5, 10, 5, 5, 10, 5, 5, 5, 20, 10, 20, 20, 20, 5, 5, 5, 10, 5, 5, 5, 20, 10, 5, 10, 5, 5, 10, 5, 5, 5, 20, 5, 20, 5, 5, 5, 5, 5, 10, 20, 10, 5, 5, 5, 5, 5, 10, 5, 5, 5, 5, 5, 10, 20, 5, 10, 20, 10, 10, 5, 5, 20, 5, 20, 5, 5, 20, 5, 20, 20, 5, 5, 5, 10, 20, 5, 5, 10, 5, 5, 5, 5, 5, 10, 5, 5, 5, 20, 5, 5, 5, 5, 5, 10, 5, 5, 5, 5, 10, 5, 20, 10, 5, 5, 10, 5, 5, 10, 10, 10, 5, 5, 10, 5, 10, 5, 20, 10, 20, 10, 20, 20, 10, 5, 10, 10, 10, 5, 20, 5, 5, 5, 5, 10, 5, 5, 20, 20, 10, 10, 10, 5, 10, 5, 5, 20, 5, 5, 5, 5, 5, 5, 20, 5, 5, 10, 20, 5, 5, 5, 20, 10, 10, 10, 20, 20, 10, 5, 5, 10, 20, 20, 10, 5, 5, 5, 10, 10, 5, 20, 5, 10, 20, 20, 5, 5, 20, 10, 5, 20, 5, 5, 10, 5, 5, 5, 10, 5, 5, 10, 5, 5, 10, 5, 20, 5, 5, 20, 5, 5, 5, 20, 20, 5, 20, 20, 5, 5, 10, 5, 5, 5, 10, 5, 5, 5, 5, 5, 5, 10, 5, 5, 10, 5, 5, 5, 5, 5, 5, 5, 20, 5, 5, 5, 5, 5, 5, 20, 20, 5, 10, 5, 5, 5, 5, 5, 10, 5, 20, 10, 5, 5, 20, 5, 5, 5, 5, 5, 5, 5, 5, 20, 5, 5, 5, 20, 5, 10, 5, 5, 20, 5, 5, 20, 20, 20, 20, 5, 10, 5, 20, 5, 5, 20, 5, 5, 5, 10, 5, 10, 5, 20, 5, 5, 5, 5, 20, 5, 5, 20, 20, 5, 5, 20, 5, 5, 5, 20, 10, 5, 5, 5, 5, 5, 20, 20, 5, 5, 5, 5, 5, 10, 10, 5, 10, 10, 10, 5, 5, 5, 20, 5, 20, 10, 20, 20, 5, 5, 10, 5, 5, 5, 10, 5, 5, 5, 5, 5, 5, 5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 10, 10, 5, 10, 10, 5, 10, 5, 20, 10, 10, 5, 5, 20, 5, 5, 10, 10, 10, 5, 10, 10, 10, 5, 10, 5, 5, 10, 5, 10, 20, 20, 5, 20, 5, 5, 5, 10, 10, 20, 5, 5, 5, 10, 5, 5, 5, 5, 5, 20, 5, 5, 10, 20, 5, 20, 5, 5, 10, 20, 10, 20, 5, 10, 5, 5, 5, 10, 20, 10, 5, 10, 5, 5, 5, 20, 5, 5, 10, 5, 5, 5, 5, 5, 20, 10, 10, 5, 20, 5, 20, 5, 5, 10, 5, 5, 20, 5, 20, 20, 10, 20, 10, 5, 20, 5, 20, 20, 20, 5, 5, 5, 10, 5, 20, 20, 10, 5, 20, 5, 5, 5, 20, 10, 5, 5, 20, 20, 5, 20, 20, 5, 5, 5, 5, 5, 5, 5, 5, 10, 10, 5, 5, 5, 20, 5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 20, 5, 20, 5, 5, 5, 5, 5, 20, 5, 5, 10, 10, 20, 5, 20, 5, 5, 5, 20, 10, 5, 5, 5, 5, 10, 5, 20, 5, 5, 5, 5, 20, 20, 10, 5, 5, 5, 10, 5, 20, 5, 10, 5, 20, 5, 10, 5, 5, 5, 5, 5, 20, 20, 5, 5, 5, 5, 5, 20, 10, 20, 5, 5, 5, 10, 5, 5, 5, 20, 5, 5, 5, 20, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 5, 5, 20, 10, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 10, 5, 10, 5, 10, 5, 5, 10, 5, 5, 10, 10, 20, 5, 20, 5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 20, 5, 5, 5, 5, 5, 20, 5, 10, 5, 5, 10, 5, 5, 5, 5, 5, 5, 20, 5, 5, 5, 20, 5, 5, 5, 20, 10, 5, 5, 10, 5, 10, 5, 20, 5, 10, 5, 5, 20, 5, 10, 5, 5, 5, 10, 5, 5, 5, 5, 5, 20, 5, 5, 5, 20, 5, 10, 5, 20, 5, 5, 5, 10, 5, 10, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 10, 5, 20, 20, 5, 5, 10, 5, 5, 5, 5, 10, 10, 10, 5, 5, 20, 5, 10, 20, 5, 5, 5, 5, 5, 10, 10, 5, 20, 5, 10, 5, 5, 5, 5, 20, 5, 20, 10, 20, 10, 10, 20, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 5, 10, 5, 5, 5, 20, 20, 20, 5, 10, 20, 20, 10, 20, 20, 20, 5, 10, 20, 5, 10, 5, 10, 5, 20, 20, 5, 5, 5, 5, 5, 5, 20, 5, 5, 5, 5, 5, 5, 5, 20, 10, 5, 5, 20, 5, 5, 5, 20, 5, 10, 20, 10, 20, 5, 20, 5, 5, 5, 5, 20, 5, 5, 5, 5, 20, 5, 5, 5, 5, 20, 5, 5, 20, 5, 20, 10, 5, 5, 5, 20, 10, 5, 5, 5, 20, 5, 10, 5, 5, 5, 5, 10, 5, 20, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 10, 5, 5, 5, 10, 10, 5, 5, 10, 20, 20, 20, 20, 5, 10, 5, 5, 5, 5, 5, 5, 5, 5, 10, 10, 5, 5, 20, 5, 20, 5, 10, 20, 5, 10, 20, 5, 20, 5, 10, 20, 5, 20, 5, 20, 20, 5, 10, 5, 20, 5, 5, 5, 20, 10, 5, 5, 5, 5, 5, 5, 5, 5, 10, 10, 20, 5, 5, 5, 5, 5, 5, 5, 10, 20, 10, 10, 10, 20, 5, 5, 10, 20, 5, 20, 20, 10, 5, 5, 20, 5, 20, 5, 20, 10, 5, 10, 5, 5, 5, 5, 5, 10, 5, 5, 10, 5, 5, 20, 5, 20, 5, 5, 5, 5, 20, 5, 5, 5, 5, 5, 5, 5, 10, 5, 10, 20, 5, 20, 5, 10, 10, 5, 5, 10, 5, 20, 20, 5, 5, 5, 10, 20, 5, 5, 5, 5, 10, 5, 5, 5, 5, 20, 5, 10, 10, 5, 5, 20, 5, 10, 5, 20, 10, 10, 5, 10, 20, 5, 5, 10, 5, 5, 10, 5, 5, 5, 5, 10, 5, 5, 5, 10, 5, 10, 20, 20, 5, 10, 5, 20, 5, 10, 5, 5, 20, 5, 5, 20, 5, 5, 20, 5, 5, 10, 20, 5, 5, 5, 20, 20, 20, 5, 20, 10, 5, 5, 5, 5, 5, 5, 10, 5, 20, 5, 10, 5, 20, 5, 20, 5, 20, 5, 10, 5, 20, 20, 10, 5, 5, 10, 20, 5, 5, 20, 10, 5, 5, 5, 5, 5, 5, 5, 5, 20, 10, 10, 10, 10, 5, 5, 5, 5, 5, 10, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 20, 5, 5, 20, 20, 5, 5, 5, 5, 5, 5, 10, 5, 20, 20, 10, 20, 5, 5, 5, 5, 10, 20, 5, 20, 5, 5, 20, 5, 5, 5, 5, 5, 20, 20, 5, 5, 5, 10, 5, 5, 10, 10, 10, 20, 10, 5, 20, 5, 5, 10, 20, 5, 5, 10, 5, 5, 20, 5, 20, 5, 5, 5, 5, 5, 5, 20, 5, 20, 5, 5, 20, 5, 5, 5, 5, 20, 5, 5, 5, 5, 5, 20, 5, 5, 5, 10, 20, 10, 5, 20, 20, 5, 20, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 10, 10, 20, 10, 5, 5, 10, 5, 5, 10, 10, 5, 5, 5, 5, 5, 20, 10, 5, 5, 20, 5, 5, 20, 5, 10, 10, 20, 20, 20, 10, 20, 5, 20, 20, 5, 5, 20, 5, 20, 5, 5, 20, 5, 20, 5, 5, 10, 5, 20, 10, 5, 5, 5, 5, 10, 5, 20, 5, 20, 20, 20, 5, 10, 5, 5, 5, 5, 10, 20, 10, 10, 20, 5, 10, 5, 5, 10, 5, 20, 5, 20, 10, 20, 5, 5, 5, 5, 20, 20, 5, 5, 5, 10, 10, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 20, 5, 5, 5, 20, 5, 10, 20, 5, 20, 5, 5, 5, 10, 5, 5, 5, 5, 5, 5, 5, 10, 5, 10, 20, 5, 5, 5, 5, 5, 5, 10, 5, 10, 5, 10, 5, 5, 5, 10, 10, 20, 5, 5, 10, 20, 5, 20, 5, 20, 10, 5, 5, 5, 20, 5, 10, 5, 5, 5, 5, 5, 20, 20, 10, 5, 5, 10, 5, 5, 5, 10, 5, 10, 10, 5, 5, 5, 10, 5, 10, 5, 5, 5, 5, 5, 10, 5, 10, 10, 10, 10, 5, 5, 5, 5, 5, 20, 10, 5, 5, 5, 10, 5, 5, 20, 5, 5, 10, 5, 5, 10, 10, 10, 5, 10, 20, 5, 5, 20, 5, 20, 5, 5, 20, 5, 5, 20, 20, 5, 5, 20, 10, 5, 5, 5, 5, 5, 5, 5, 10, 5, 20, 5, 10, 5, 5, 5, 5, 5, 5, 5, 10, 5, 20, 10, 5, 20, 5, 5, 5, 5, 5, 5, 20, 5, 10, 5, 5, 10, 20, 20, 5, 5, 20, 5, 5, 20, 5, 10, 20, 20, 5, 5, 5, 5, 5, 5, 20, 20, 5, 10, 5, 5, 5, 5, 5, 5, 5, 5, 20, 10, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 20, 5, 20, 20, 20, 5, 5, 5, 10, 10, 5, 5, 10, 5, 5, 5, 10, 10, 5, 5, 10, 10, 10, 20, 5, 20, 5, 5, 5, 5, 5, 5, 5, 10, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 10, 10, 5, 10, 5, 5, 5, 5, 10, 10, 20, 10, 20, 5, 10, 20, 20, 20, 5, 5, 10, 5, 20, 20, 5, 20, 20, 5, 10, 5, 5, 10, 20, 5, 5, 5, 5, 5, 10, 5, 10, 5, 10, 20, 5, 5, 5, 5, 5, 20, 10, 20, 10, 20, 20, 5, 5, 20, 20, 5, 5, 10, 5, 5, 5, 20, 10, 10, 5, 5, 20, 5, 5, 5, 20, 10, 10, 5, 5, 5, 10, 5, 10, 10, 20, 5, 10, 5, 20, 5, 5, 5, 20, 10, 20, 5, 10, 5, 20, 10, 5, 5, 5, 5, 5, 5, 5, 20, 5, 5, 20, 5, 20, 5, 5, 20, 5, 10, 5, 5, 5, 5, 5, 5, 10, 5, 10, 5, 5, 20, 5, 10, 5, 5, 5, 10, 10, 5, 5, 5, 20, 5, 5, 20, 20, 5, 5, 10, 20, 5, 5, 5, 5, 5, 10, 20, 5, 5, 10, 20, 10, 20, 5, 10, 5, 5, 20, 20, 5, 5, 5, 10, 5, 5, 10, 5, 5, 5, 20, 20, 10, 5, 5, 20, 20, 5, 20, 5, 10, 20, 5, 5, 5, 10, 5, 5, 5, 10, 5, 5, 20, 10, 5, 20, 20, 20, 5, 5, 10, 5, 20, 20, 20, 20, 10, 5, 10, 10, 10, 5, 5, 5, 20, 5, 10, 10, 20, 5, 5, 5, 5, 5, 20, 5, 5, 20, 10, 5, 5, 20, 10, 5, 10, 10, 20, 10, 20, 5, 5, 5, 10, 10, 5, 5, 10, 20, 20, 5, 5, 5, 10, 5, 5, 20, 5, 5, 5, 5, 5, 10, 20, 10, 5, 10, 5, 5, 5, 5, 5, 5, 10, 5, 5, 10, 10, 5, 20, 5, 10, 5, 5, 5, 10, 5, 5, 10, 20, 10, 10, 20, 10, 10, 20, 5, 5, 5, 5, 10, 5, 5, 20, 20, 5, 10, 20, 10, 5, 5, 20, 5, 20, 20, 5, 5, 5, 10, 5, 5, 5, 5, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 10, 5, 5, 5, 20, 5, 5, 5, 10, 20, 5, 5, 5, 5, 10, 5, 10, 20, 5, 10, 5, 5, 5, 20, 5, 20, 10, 5, 5, 5, 5, 20, 5, 5, 5, 10, 5, 5, 5, 5, 10, 20, 5, 5, 5, 10, 20, 10, 10, 5, 5, 20, 20, 20, 10, 20, 20, 10, 10, 5, 5, 5, 10, 5, 20, 20, 5, 5, 20, 20, 5, 5, 20, 5, 20, 5, 5, 5, 5, 10, 5, 10, 5, 5, 10, 5, 20, 5, 5, 10, 10, 5, 10, 5, 5, 5, 5, 5, 10, 5, 5, 10, 10, 5, 5, 5, 5, 5, 20, 5, 5, 5, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 20, 10, 20, 10, 5, 5, 10, 5, 5, 5, 5, 5, 10, 20, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 10, 5, 5, 10, 5, 10, 20, 20, 10, 5, 5, 20, 5, 10, 5, 5, 5, 5, 20, 5, 10, 20, 5, 5, 10, 20, 5, 5, 10, 10, 20, 5, 5, 5, 5, 5, 20, 5, 5, 5, 10, 5, 5, 5, 5, 5, 5, 5, 20, 20, 5, 5, 5, 5, 5, 5, 10, 10, 20, 5, 5, 20, 10, 5, 5, 20, 20, 20, 20, 20, 5, 20, 10, 5, 20, 5, 5, 5, 5, 10, 5, 20, 5, 5, 10, 5, 5, 10, 10, 20, 5, 5, 20, 5, 20, 20, 5, 5, 5, 5, 5, 5, 5, 10, 20, 10, 20, 10, 5, 5, 5, 10, 5, 20, 20, 10, 10, 20, 20, 5, 5, 20, 5, 10, 10, 5, 5, 20, 5, 20, 5, 5, 5, 10, 5, 5, 20, 5, 10, 5, 10, 5, 10, 5, 10, 10, 5, 20, 5, 20, 5, 10, 5, 5, 5, 5, 20, 5, 20, 5, 5, 20, 10, 5, 10, 10, 5, 5, 5, 5, 10, 5, 10, 5, 10, 5, 10, 20, 5, 5, 10, 5, 10, 5, 10, 10, 20, 20, 20, 20, 10, 5, 5, 5, 20, 5, 5, 10, 10, 20, 10, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 5, 5, 5, 20, 10, 10, 10, 10, 20, 10, 5, 5, 5, 5, 10, 20, 5, 5, 5, 5, 20, 5, 5, 5, 10, 5, 5, 10, 5, 10, 10, 5, 5, 5, 5, 20, 20, 20, 5, 20, 5, 5, 10, 10, 20, 5, 5, 5, 5, 20, 5, 20, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 20, 20, 10, 20, 5, 5, 5, 20, 10, 5, 10, 10, 20, 20, 5, 20, 10, 5, 5, 5, 20, 5, 5, 10, 5, 5, 5, 20, 10, 5, 5, 5, 10, 20, 5, 20, 20, 5, 20, 5, 5, 10, 10, 10, 5, 5, 20, 20, 5, 5, 20, 5, 5, 10, 20, 10, 20, 5, 5, 20, 5, 10, 5, 5, 5, 5, 5, 20, 5, 5, 5, 5, 5, 20, 20, 5, 20, 5, 5, 5, 5, 5, 5, 20, 5, 5, 5, 5, 5, 20, 5, 20, 5, 5, 20, 5, 10, 5, 20, 20, 5, 10, 5, 5, 5, 5, 10, 5, 5, 5, 5, 10, 5, 5, 5, 10, 10, 5, 20, 20, 5, 5, 5, 20, 10, 5, 5, 5, 5, 5, 10, 20, 20, 20, 10, 10, 5, 5, 20, 10, 5, 10, 5, 5, 5, 5, 5, 20, 5, 20, 20, 5, 5, 5, 10, 5, 10, 10, 10, 5, 5, 10, 5, 5, 5, 5, 5, 5, 20, 5, 5, 10, 5, 5, 5, 5, 5, 5, 10, 5, 20, 20, 5, 5, 5, 20, 5, 5, 5, 5, 10, 5, 5, 10, 5, 20, 5, 5, 5, 20, 5, 5, 5, 5, 5, 5, 5, 5, 10, 10, 5, 10, 5, 5, 5, 20, 5, 10, 5, 5, 10, 5, 5, 5, 5, 5, 20, 5, 5, 5, 5, 5, 20, 5, 20, 20, 5, 5, 5, 5, 5, 10, 10, 20, 5, 5, 10, 5, 10, 20, 10, 5, 5, 5, 5, 5, 20, 5, 5, 5, 5, 20, 20, 5, 5, 5, 5, 5, 20, 5, 5, 20, 5, 10, 20, 5, 5, 5, 10, 5, 10, 5, 20, 10, 5, 10, 5, 5, 20, 20, 5, 10, 5, 5, 5, 10, 5, 5, 20, 10, 10, 20, 5, 20, 5, 5, 20, 5, 5, 10, 20, 5, 10, 20, 5, 5, 5, 5, 5, 5, 20, 5, 10, 5, 5, 20, 5, 5, 20, 5, 10, 5, 10, 10, 5, 5, 20, 5, 5, 10, 5, 5, 5, 10, 5, 5, 5, 5, 20, 5, 20, 10, 5, 5, 20, 5, 20, 5, 5, 5, 5, 5, 5, 20, 5, 20, 20, 5, 10, 10, 20, 20, 5, 5, 5, 5, 5, 20, 20, 20, 5, 10, 5, 5, 10, 5, 20, 10, 10, 20, 5, 5, 10, 5, 5, 10, 5, 5, 5, 20, 5, 5, 20, 5, 5, 5, 5, 20, 10, 5, 10, 10, 10, 10, 10, 5, 10, 5, 5, 5, 20, 10, 20, 10, 5, 5, 10, 5, 5, 5, 5, 5, 5, 5, 5, 5, 20, 10, 5, 5, 5, 5, 5, 20, 5, 20, 5, 5, 20, 5, 5, 20, 5, 5, 5, 20, 10, 20, 5, 5, 10, 5, 5, 5, 20, 20, 5, 10, 5, 5, 20, 20, 5, 5, 5, 10, 5, 10, 5, 5, 5, 20, 10, 10, 5, 5, 5, 5, 5, 5, 5, 20, 20, 5, 20, 5, 10, 5, 20, 10, 5, 5, 10, 5, 5, 5, 5, 5, 5, 5, 20, 20, 10, 10, 5, 5, 20, 5, 10, 5, 5, 5, 10, 5, 20, 5, 5, 5, 5, 5, 5, 5, 10, 5, 10, 5, 5, 5, 5, 20, 20, 5, 20, 5, 20, 5, 20, 5, 5, 20, 5, 5, 10, 20, 5, 20, 5, 20, 5, 5, 5, 10, 10, 5, 5, 20, 5, 5, 10, 5, 5, 10, 5, 5, 5, 10, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 10, 10, 5, 5, 5, 5, 10, 5, 10, 10, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 5, 5, 10, 5, 5, 5, 10, 5, 5, 5, 10, 5, 20, 5, 20, 10, 5, 20, 5, 5, 5, 5, 5, 5, 5, 5, 10, 20, 5, 10, 5, 5, 20, 10, 5, 5, 5, 10, 10, 10, 5, 5, 5, 5, 5, 5, 20, 10, 20, 20, 5, 5, 20, 5, 5, 5, 5, 20, 5, 10, 5, 10, 5, 5, 20, 5, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 20, 10, 5, 5, 5, 5, 5, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 20, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 10, 10, 5, 10, 5, 5, 20, 5, 5, 10, 5, 5, 10, 20, 10, 5, 20, 5, 5, 5, 20, 20, 5, 10, 5, 5, 5, 5, 10, 10, 10, 20, 5, 10, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 5, 5, 20, 5, 10, 5, 5, 5, 5, 10, 5, 5, 5, 20, 5, 5, 20, 5, 5, 5, 5, 5, 10, 20, 5, 20, 5, 10, 10, 5, 5, 20, 5, 5, 5, 5, 5, 20, 5, 5, 5, 20, 20, 5, 20, 5, 5, 5, 5, 20, 5, 5, 5, 5, 5, 20, 5, 5, 10, 5, 5, 5, 10, 20, 20, 5, 5, 5, 5, 5, 10, 5, 20, 20, 5, 5, 5, 20, 10, 5, 5, 5, 10, 5, 5, 5, 5, 20, 20, 5, 20, 10, 10, 20, 5, 5, 20, 5, 10, 20, 20, 10, 5, 5, 20, 5, 5, 5, 5, 5, 5, 5, 5, 20, 5, 5, 20, 5, 5, 5, 20, 5, 20, 5, 5, 5, 10, 10, 20, 5, 5, 5, 5, 10, 10, 5, 20, 5, 20, 5, 5, 5, 5, 20, 5, 20, 10, 5, 20, 5, 10, 10, 5, 20, 5, 5, 5, 10, 20, 5, 5, 5, 5, 5, 10, 5, 5, 5, 5, 20, 20, 5, 20, 5, 5, 10, 20, 5, 10, 5, 5, 5, 5, 5, 5, 5, 20, 5, 5, 5, 10, 5, 5, 5, 5, 5, 5, 10, 5, 20, 5, 5, 5, 10, 10, 20, 5, 5, 5, 5, 5, 5, 20, 5, 5, 10, 20, 20, 5, 10, 20, 5, 5, 20, 10, 20, 5, 10, 5, 5, 20, 10, 5, 5, 20, 10, 5, 10, 10, 5, 5, 20, 20, 5, 20, 10, 5, 5, 5, 5, 5, 20, 5, 5, 10, 10, 10, 10, 5, 5, 5, 5, 5, 5, 5, 20, 20, 5, 20, 5, 10, 20, 5, 10, 5, 5, 5, 10, 5, 20, 5, 5, 5, 5, 5, 5, 10, 5, 5, 5, 10, 20, 5, 5, 10, 5, 20, 20, 10, 10, 5, 5, 5, 5, 10, 20, 5, 10, 5, 20, 10, 5, 5, 20, 5, 20, 10, 5, 5, 5, 5, 5, 10, 5, 5, 5, 20, 5, 20, 5, 20, 5, 5, 20, 10, 20, 5, 20, 5, 20, 5, 10, 20, 20, 5, 5, 5, 5, 5, 10, 5, 5, 5, 5, 5, 5, 10, 5, 5, 5, 20, 5, 10, 5, 5, 20, 5, 5, 10, 5, 5, 5, 5, 20, 5, 10, 5, 5, 5, 5, 5, 5, 5, 10, 10, 5, 20, 20, 5, 5, 5, 5, 20, 5, 20, 5, 5, 5, 5, 5, 10, 10, 20, 20, 5, 5, 5, 20, 5, 5, 5, 5, 5, 10, 5, 5, 5, 5, 5, 10, 20, 5, 5, 5, 20, 5, 10, 5, 5, 5, 5, 5, 20, 5, 5, 5, 10, 20, 20, 5, 10, 10, 5, 5, 10, 5, 5, 20, 10, 10, 5, 5, 10, 5, 5, 20, 5, 5, 5, 5, 20, 5, 10, 10, 5, 5, 10, 20, 5, 5, 10, 5, 5, 5, 5, 5, 5, 5, 10, 5, 10, 10, 10, 5, 20, 10, 5, 5, 5, 5, 5, 20, 5, 5, 5, 10, 20, 5, 5, 5, 5, 5, 10, 5, 5, 5, 10, 5, 20, 20, 5, 20, 20, 20, 5, 10, 5, 5, 5, 5, 20, 20, 5, 5, 5, 10, 5, 5, 5, 10, 10, 5, 5, 5, 5, 5, 5, 5, 10, 5, 10, 5, 5, 5, 5, 20, 5, 20, 5, 20, 5, 5, 20, 5, 5, 5, 20, 10, 5, 5, 5, 5, 5, 5, 5, 10, 5, 20, 5, 5, 5, 5, 20, 20, 5, 20, 5, 10, 5, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 20, 20, 5, 20, 10, 10, 5, 5, 5, 10, 5, 20, 5, 20, 5, 5, 5, 10, 5, 5, 5, 5, 5, 5, 20, 10, 5, 10, 5, 10, 10, 10, 5, 5, 5, 5, 5, 10, 20, 5, 5, 5, 5, 5, 20, 10, 10, 10, 5, 10, 20, 20, 20, 5, 5, 10, 10, 10, 20, 5, 20, 5, 20, 5, 5, 5, 5, 20, 5, 20, 5, 5, 20, 5, 10, 5, 20, 5, 5, 5, 5, 5, 5, 10, 5, 5, 10, 5, 20, 5, 5, 5, 20, 20, 10, 5, 5, 20, 5, 10, 5, 10, 5, 5, 5, 5, 20, 5, 20, 5, 10, 20, 10, 10, 5, 5, 5, 20, 5, 5, 5, 5, 5, 10, 5, 10, 5, 5, 5, 20, 20, 5, 5, 10, 10, 10, 5, 5, 5, 5, 10, 5, 5, 5, 5, 20, 20, 10, 5, 5, 5, 5, 5, 5, 20, 20, 5, 10, 5, 10, 10, 10, 10, 5, 10, 5, 5, 5, 5, 5, 5, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 10, 5, 5, 5, 5, 5, 20, 20, 10, 20, 10, 5, 5, 5, 20, 5, 5, 5, 20, 10, 5, 10, 5, 20, 5, 10, 5, 5, 5, 5, 5, 5, 20, 5, 5, 10, 5, 5, 5, 5, 5, 5, 5, 10, 20, 10, 5, 5, 5, 5, 5, 10, 5, 5, 5, 5, 5, 5, 5, 5, 5, 20, 10, 10, 5, 20, 5, 5, 5, 10, 5, 5, 10, 20, 10, 5, 20, 5, 20, 5, 5, 20, 10, 5, 20, 10, 5, 5, 5, 5, 10, 20, 5, 20, 20, 5, 5, 20, 10, 5, 5, 5, 10, 5, 10, 20, 5, 5, 5, 5, 5, 10, 10, 10, 10, 5, 10, 20, 5, 5, 20, 10, 10, 10, 20, 20, 20, 5, 20, 10, 5, 5, 10, 5, 5, 10, 5, 5, 5, 10, 5, 10, 5, 20, 20, 20, 5, 10, 10, 5, 5, 10, 5, 5, 5, 10, 20, 5, 10, 10, 10, 10, 20, 20, 5, 5, 20, 5, 5, 5, 5, 10, 5, 10, 5, 10, 5, 10, 10, 20, 5, 10, 5, 10, 20, 5, 5, 5, 10, 5, 10, 5, 5, 10, 5, 5, 5, 5, 10, 5, 20, 5, 5, 5, 5, 10, 10, 5, 20, 5, 5, 5, 10, 5, 10, 20, 5, 5, 20, 10, 5, 5, 5, 5, 5, 20, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 10, 20, 5, 20, 5, 10, 5, 5, 10, 5, 10, 5, 5, 5, 20, 10, 5, 5, 5, 5, 20, 10, 5, 5, 5, 5, 20, 5, 5, 5, 10, 5, 10, 5, 5, 5, 5, 10, 5, 5, 5, 5, 5, 5, 10, 5, 5, 5, 5, 10, 5, 20, 10, 20, 5, 5, 20, 10, 5, 5, 10, 10, 10, 5, 10, 20, 5, 5, 5, 5, 10, 5, 20, 5, 5, 5, 5, 5, 10, 5, 5, 5, 5, 20, 5, 20, 20, 5, 5, 10, 5, 5, 20, 10, 10, 5, 10, 20, 5, 10, 5, 5, 5, 10, 5, 5, 20, 5, 20, 20, 5, 5, 5, 20, 5, 5, 20, 5, 5, 5, 20, 5, 5, 5, 10, 5, 10, 10, 20, 20, 5, 5, 20, 5, 10, 20, 10, 5, 5, 5, 5, 10, 5, 5, 20, 5, 5, 5, 5, 5, 5, 10, 20, 20, 5, 5, 10, 20, 5, 5, 5, 10, 5, 5, 5, 20, 5, 5, 20, 5, 5, 5, 5, 5, 5, 5, 5, 20, 20, 5, 5, 5, 5, 5, 5, 20, 5, 5, 20, 10, 5, 10, 5, 5, 20, 10, 10, 5, 20, 20, 5, 5, 5, 5, 5, 5, 5, 20, 10, 5, 5, 5, 20, 10, 10, 5, 5, 5, 10, 10, 5, 10, 5, 5, 5, 20, 10, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 5, 5, 20, 10, 5, 5, 20, 20, 5, 20, 5, 10, 5, 10, 20, 10, 5, 10, 5, 5, 20, 5, 5, 5, 5, 20, 5, 10, 5, 5, 5, 20, 20, 5, 10, 10, 5, 10, 10, 20, 10, 5, 5, 10, 20, 5, 5, 10, 5, 5, 5, 20, 5, 5, 5, 5, 5, 20, 5, 20, 10, 10, 5, 5, 5, 20, 5, 5, 20, 10, 5, 5, 5, 10, 5, 10, 5, 5, 5, 10, 5, 5, 20, 5, 10, 5, 10, 10, 5, 5, 10, 20, 20, 5, 5, 10, 10, 10, 5, 5, 5, 10, 5, 5, 5, 10, 5, 10, 5, 10, 20, 5, 20, 10, 20, 10, 5, 5, 5, 20, 5, 5, 20, 5, 5, 5, 5, 5, 10, 10, 5, 5, 5, 5, 10, 5, 5, 20, 20, 5, 10, 5, 5, 5, 5, 20, 5, 5, 20, 5, 10, 20, 20, 20, 5, 5, 20, 5, 10, 5, 5, 5, 5, 20, 10, 20, 10, 5, 5, 5, 10, 20, 5, 20, 5, 20, 10, 20, 20, 5, 10, 10, 5, 20, 5, 20, 5, 20, 5, 20, 5, 20, 20, 5, 5, 5, 5, 20, 20, 5, 5, 10, 5, 5, 20, 5, 5, 5, 10, 10, 5, 5, 5, 5, 5, 20, 20, 5, 10, 10, 10, 20, 5, 20, 20, 5, 5, 20, 20, 5, 5, 5, 10, 5, 20, 20, 10, 5, 5, 10, 5, 10, 10, 5, 5, 10, 5, 5, 5, 20, 5, 10, 5, 20, 5, 20, 5, 5, 20, 20, 10, 20, 5, 5, 5, 5, 5, 5, 20, 10, 5, 5, 5, 5, 5, 10, 20, 5, 5, 20, 5, 5, 5, 5, 5, 5, 20, 5, 5, 10, 10, 5, 5, 20, 20, 5, 5, 5, 20, 5, 5, 5, 5, 5, 5, 5, 20, 5, 5, 5, 10, 10, 5, 10, 10, 5, 5, 10, 10, 10, 20, 10, 10, 5, 5, 5, 10, 5, 5, 10, 10, 5, 10, 5, 5, 5, 10, 20, 5, 20, 20, 10, 5, 10, 5, 10, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 10, 20, 5, 5, 20, 5, 5, 10, 20, 20, 20, 5, 5, 5, 5, 10, 10, 5, 5, 5, 5, 5, 20, 20, 5, 20, 5, 5, 20, 5, 5, 5, 5, 5, 5, 5, 20, 5, 10, 20, 5, 5, 10, 5, 5, 5, 20, 20, 5, 10, 5, 10, 10, 5, 5, 10, 5, 5, 20, 20, 20, 20, 5, 5, 5, 10, 20, 10, 10, 10, 5, 10, 5, 5, 20, 5, 10, 5, 10, 5, 5, 20, 5, 5, 20, 5, 20, 5, 20, 20, 5, 20, 5, 5, 20, 5, 5, 5, 20, 5, 10, 5, 5, 20, 5, 20, 5, 20, 20, 20, 5, 5, 20, 5, 5, 10, 10, 5, 5, 5, 5, 10, 10, 5, 20, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 10, 5, 20, 5, 5, 20, 5, 10, 20, 5, 5, 10, 5, 5, 5, 5, 10, 5, 20, 5, 20, 5, 5, 5, 10, 10, 5, 5, 10, 5, 20, 20, 10, 5, 10, 5, 5, 5, 10, 5, 10, 5, 5, 10, 10, 5, 5, 20, 10, 5, 5, 5, 20, 5, 5, 20, 5, 5, 5, 20, 10, 10, 20, 10, 5, 10, 5, 5, 10, 5, 10, 10, 5, 5, 20, 10, 5, 10, 5, 5, 20, 20, 5, 20, 5, 5, 5, 5, 5, 20, 10, 5, 5, 5, 10, 10, 10, 5, 5, 20, 5, 5, 10, 5, 5, 5, 20, 5, 5, 5, 10, 5, 20, 10, 5, 5, 10, 5, 5, 10, 5, 5, 10, 5, 20, 5, 5, 5, 5, 20, 5, 20, 20, 5, 5, 5, 5, 5, 10, 10, 5, 5, 5, 20, 5, 20, 10, 5, 20, 5, 5, 5, 5, 5, 5, 10, 10, 5, 10, 10, 5, 5, 20, 5, 5, 20, 20, 10, 20, 5, 10, 5, 20, 10, 10, 10, 5, 5, 10, 5, 10, 5, 20, 5, 10, 5, 5, 10, 5, 5, 5, 10, 5, 5, 10, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 20, 5, 10, 5, 5, 5, 5, 5, 5, 5, 20, 10, 5, 5, 10, 5, 5, 10, 10, 20, 20, 5, 10, 10, 5, 5, 5, 5, 20, 5, 5, 5, 5, 5, 5, 10, 5, 5, 5, 10, 20, 20, 5, 5, 20, 20, 5, 10, 20, 10, 5, 5, 10, 20, 10, 5, 20, 10, 10, 5, 5, 5, 5, 10, 5, 5, 5, 5, 20, 5, 5, 10, 10, 5, 20, 20, 5, 20, 10, 5, 20, 5, 5, 5, 20, 5, 5, 20, 20, 20, 5, 20, 20, 5, 10, 5, 10, 5, 5, 5, 10, 5, 20, 10, 5, 5, 5, 5, 20, 10, 5, 10, 10, 5, 5, 5, 5, 5, 5, 20, 20, 10, 10, 5, 10, 20, 20, 5, 20, 5, 20, 10, 5, 5, 5, 5, 10, 5, 5, 5, 5, 20, 5, 5, 5, 5, 5, 20, 5, 5, 5, 20, 10, 10, 20, 5, 5, 20, 10, 10, 5, 10, 5, 10, 5, 5, 20, 5, 5, 5, 5, 5, 10, 5, 10, 5, 5, 5, 5, 5, 20, 5, 10, 10, 10, 5, 5, 5, 10, 5, 20, 5, 5, 5, 10, 5, 5, 5, 5, 10, 5, 10, 5, 5, 10, 20, 5, 5, 10, 10, 20, 20, 20, 20, 10, 20, 5, 5, 5, 5, 5, 5, 5, 20, 5, 10, 5, 10, 20, 5, 20, 5, 5, 5, 5, 5, 20, 5, 5, 5, 20, 5, 20, 20, 20, 5, 5, 10, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 20, 10, 5, 10, 10, 5, 5, 20, 20, 10, 5, 10, 10, 20, 10, 5, 5, 10, 10, 5, 10, 5, 5, 5, 10, 5, 5, 10, 10, 10, 5, 20, 5, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 5, 5, 10, 5, 10, 10, 5, 5, 5, 20, 10, 5, 5, 10, 20, 20, 20, 5, 10, 10, 20, 20, 5, 20, 5, 5, 20, 5, 10, 5, 20, 20, 10, 5, 5, 10, 5, 5, 5, 10, 5, 5, 10, 10, 5, 20, 5, 10, 10, 5, 5, 10, 10, 5, 5, 5, 5, 10, 5, 10, 20, 5, 5, 10, 5, 20, 5, 20, 5, 5, 10, 5, 5, 5, 5, 5, 5, 5, 20, 20, 20, 5, 20, 5, 20, 10, 5, 5, 5, 5, 5, 5, 20, 5, 20, 5, 5, 5, 5, 10, 5, 5, 5, 5, 20, 5, 5, 5, 10, 5, 5, 10, 20, 5, 20, 5, 10, 5, 20, 20, 10, 20, 5, 10, 5, 5, 10, 10, 20, 5, 20, 5, 20, 5, 20, 20, 20, 5, 20, 5, 20, 5, 5, 10, 20, 5, 10, 5, 5, 10, 5, 5, 20, 10, 10, 10, 5, 5, 5, 5, 5, 10, 5, 10, 10, 20, 5, 5, 5, 5, 5, 10, 10, 10, 5, 10, 20, 20, 5, 5, 20, 20, 5, 20, 5, 5, 5, 10, 10, 5, 5, 5, 10, 20, 5, 10, 5, 5, 10, 5, 10, 5, 10, 10, 5, 20, 5, 5, 10, 5, 5, 10, 10, 20, 5, 20, 20, 20, 5, 5, 10, 20, 5, 20, 5, 20, 5, 5, 10, 5, 20, 10, 20, 5, 10, 5, 10, 10, 5, 20, 5, 20, 5, 5, 5, 10, 5, 5, 20, 5, 5, 5, 5, 5, 10, 10, 20, 5, 20, 20, 5, 5, 10, 5, 5, 20, 5, 5, 10, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 5, 5, 5, 5, 5, 5, 20, 10, 20, 5, 5, 5, 10, 5, 20, 5, 10, 5, 5, 10, 5, 5, 5, 10, 10, 5, 5, 10, 5, 5, 20, 20, 20, 5, 5, 20, 20, 10, 5, 5, 10, 5, 5, 5, 20, 5, 5, 20, 5, 20, 5, 20, 5, 5, 5, 10, 5, 20, 20, 5, 10, 10, 5, 5, 5, 5, 5, 5, 10, 20, 5, 5, 5, 20, 5, 5, 5, 20, 5, 5, 5, 5, 10, 20, 10, 5, 5, 5, 10, 5, 20, 20, 10, 10, 5, 10, 5, 20, 20, 5, 5, 5, 10, 5, 20, 5, 5, 20, 5, 5, 10, 20, 5, 20, 20, 5, 5, 20, 20, 20, 20, 5, 5, 10, 5, 20, 5, 5, 5, 5, 10, 5, 5, 5, 5, 10, 5, 5, 5, 10, 5, 5, 5, 5, 5, 5, 5, 10, 20, 20, 20, 5, 5, 10, 5, 5, 10, 5, 5, 20, 5, 10, 5, 10, 10, 5, 5, 20, 5, 10, 20, 5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 10, 5, 5, 10, 10, 5, 5, 20, 5, 10, 5, 20, 5, 20, 20, 5, 20, 5, 5, 5, 5, 5, 20, 5, 5, 5, 5, 5, 20, 10, 20, 10, 5, 20, 20, 10, 5, 20, 5, 5, 5, 5, 5, 5, 5, 5, 10, 20, 5, 10, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 10, 5, 5, 10, 10, 5, 5, 5, 5, 5, 5, 5, 5, 5, 20, 20, 20, 5, 5, 20, 20, 10, 5, 10, 5, 10, 5, 5, 5, 10, 5, 5, 20, 5, 20, 5, 10, 10, 5, 5, 5, 10, 5, 5, 5, 5, 5, 5, 5, 20, 5, 20, 5, 5, 5, 20, 5, 20, 5, 5, 5, 5, 5, 20, 5, 5, 20, 5, 10, 5, 5, 20, 5, 5, 5, 5, 5, 10, 10, 10, 5, 5, 5, 10, 10, 5, 20, 5, 10, 5, 5, 5, 5, 20, 20, 20, 5, 5, 5, 20, 20, 10, 5, 5, 5, 10, 5, 5, 5, 5, 5, 20, 5, 5, 20, 5, 10, 20, 5, 10, 5, 10, 10, 10, 10, 5, 10, 5, 5, 5, 5, 5, 5, 20, 5, 5, 5, 20, 5, 5, 20, 5, 5, 5, 20, 5, 5, 5, 5, 5, 10, 10, 5, 5, 5, 5, 5, 20, 10, 10, 5, 10, 10, 20, 10, 5, 20, 10, 10, 5, 5, 20, 5, 5, 5, 5, 20, 5, 5, 5, 5, 10, 20, 5, 20, 20, 5, 20, 5, 10, 10, 5, 5, 10, 20, 5, 5, 5, 5, 20, 20, 5, 5, 5, 5, 10, 5, 5, 10, 5, 5, 5, 5, 5, 10, 5, 5, 10, 5, 10, 10, 10, 10, 5, 20, 5, 5, 5, 10, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 5, 5, 20, 10, 10, 5, 5, 5, 5, 5, 20, 5, 5, 5, 20, 5, 10, 10, 5, 5, 5, 5, 5, 20, 5, 20, 5, 5, 5, 5, 5, 10, 5, 10, 5, 5, 5, 5, 5, 10, 5, 5, 10, 5, 5, 5, 5, 5, 5, 10, 5, 5, 5, 5, 5, 5, 20, 5, 5, 5, 10, 20, 20, 5, 20, 20, 10, 10, 5, 5, 5, 5, 10, 10, 5, 10, 5, 10, 10, 5, 20, 5, 5, 20, 5, 5, 10, 5, 20, 5, 5, 5, 5, 20, 5, 5, 20, 5, 10, 5, 5, 20, 10, 10, 20, 10, 20, 20, 10, 20, 5, 10, 5, 20, 10, 5, 10, 5, 5, 10, 5, 5, 20, 5, 5, 10, 10, 10, 5, 5, 20, 5, 5, 5, 20, 5, 10, 10, 5, 5, 10, 5, 5, 5, 5, 5, 5, 5, 5, 20, 5, 5, 5, 10, 5, 5, 5, 20, 5, 20, 10, 10, 20, 20, 5, 20, 20, 10, 20, 5, 5, 5, 20, 5, 5, 5, 5, 20, 5, 10, 5, 10, 5, 5, 5, 20, 20, 5, 5, 10, 20, 10, 5, 5, 5, 10, 10, 5, 10, 20, 10, 10, 5, 5, 5, 20, 5, 5, 5, 5, 5, 5, 20, 5, 20, 20, 5, 5, 5, 20, 20, 5, 5, 20, 5, 10, 20, 20, 5, 20, 10, 10, 5, 5, 5, 10, 5, 10, 5, 5, 5, 20, 5, 20, 10, 5, 5, 5, 5, 5, 5, 5, 10, 10, 10, 5, 10, 5, 5, 5, 20, 20, 20, 5, 5, 5, 5, 5, 20, 5, 20, 5, 5, 5, 5, 5, 20, 5, 5, 5, 5, 10, 10, 5, 10, 20, 5, 10, 20, 10, 5, 5, 5, 5, 20, 5, 10, 5, 20, 5, 5, 5, 20, 5, 5, 10, 5, 5, 10, 5, 10, 10, 5, 5, 5, 5, 20, 5, 20, 20, 10, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 20, 5, 5, 5, 5, 5, 20, 5, 10, 10, 5, 5, 5, 20, 5, 5, 5, 20, 10, 20, 5, 5, 20, 10, 5, 5, 5, 20, 10, 5, 20, 5, 5, 5, 20, 5, 5, 5, 20, 5, 20, 5, 10, 5, 5, 10, 10, 10, 10, 5, 5, 5, 20, 20, 5, 5, 5, 5, 5, 5, 5, 20, 5, 5, 5, 5, 5, 10, 5, 5, 5, 5, 5, 5, 5, 5, 20, 20, 5, 5, 20, 5, 5, 5, 5, 20, 5, 5, 10, 10, 5, 5, 5, 5, 10, 5, 5, 20, 5, 5, 5, 20, 5, 5, 5, 5, 20, 10, 5, 5, 5, 5, 10, 5, 5, 10, 20, 5, 5, 20, 5, 10, 5, 5, 20, 10, 5, 5, 20, 10, 20, 20, 5, 5, 20, 10, 10, 20, 5, 20, 5, 10, 10, 10, 5, 10, 5, 10, 5, 5, 5, 10, 5, 5, 10, 5, 5, 20, 20, 10, 10, 5, 5, 10, 20, 5, 5, 5, 10, 5, 10, 5, 5, 5, 5, 5, 5, 20, 5, 5, 10, 5, 5, 5, 5, 20, 5, 5, 5, 20, 5, 20, 5, 5, 5, 10, 5, 10, 20, 5, 20, 5, 10, 20, 10, 5, 5, 20, 10, 5, 10, 5, 10, 20, 20, 5, 20, 5, 5, 10, 5, 10, 20, 10, 20, 10, 5, 5, 5, 20, 5, 5, 5, 5, 5, 20, 5, 10, 10, 5, 20, 5, 5, 5, 20, 10, 5, 10, 5, 5, 5, 5, 5, 10, 10, 5, 5, 10, 20, 20, 20, 5, 10, 5, 5, 5, 20, 5, 5, 5, 20, 5, 5, 5, 5, 10, 5, 5, 5, 5, 10, 20, 5, 20, 5, 5, 5, 5, 20, 20, 20, 5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 10, 20, 5, 5, 5, 20, 5, 5, 10, 20, 20, 10, 5, 5, 5, 5, 20, 5, 5, 20, 20, 5, 5, 10, 20, 5, 5, 20, 5, 5, 10, 5, 10, 5, 10, 20, 10, 5, 5, 10, 5, 5, 5, 5, 5, 5, 20, 20, 20, 5, 5, 5, 5, 10, 20, 5, 10, 20, 5, 5, 5, 10, 20, 5, 10, 5, 5, 5, 5, 5, 10, 5, 5, 5, 20, 5, 5, 20, 5, 20, 5, 20, 10, 10, 5, 5, 20, 5, 5, 5, 5, 20, 20, 5, 5, 20, 20, 5, 5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 10, 5, 5, 5, 10, 5, 5, 5, 5, 10, 5, 5, 5, 20, 5, 5, 10, 5, 5, 5, 5, 20, 10, 10, 5, 10, 10, 5, 20, 5, 5, 5, 5, 10, 5, 20, 20, 5, 5, 10, 10, 20, 20, 5, 5, 5, 5, 5, 5, 5, 5, 20, 5, 5, 20, 5, 5, 10, 10, 20, 5, 20, 5, 20, 10, 5, 20, 10, 5, 10, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 5, 5, 20, 10, 10, 5, 10, 10, 5, 10, 5, 5, 5, 10, 10, 5, 5, 20, 10, 10, 10, 5, 5, 20, 5, 5, 20, 5, 5, 5, 20, 5, 5, 5, 10, 10, 5, 5, 5, 20, 20, 20, 5, 20, 5, 20, 5, 10, 5, 5, 5, 20, 5, 20, 10, 20, 5, 10, 5, 5, 20, 5, 5, 20, 10, 5, 5, 5, 5, 10, 10, 5, 5, 20, 20, 5, 10, 20, 5, 10, 5, 20, 5, 5, 10, 10, 5, 5, 5, 20, 5, 5, 5, 5, 10, 20, 5, 10, 5, 20, 5, 5, 5, 10, 5, 5, 5, 5, 20, 20, 5, 5, 10, 20, 5, 5, 5, 20, 5, 5, 10, 5, 10, 20, 10, 20, 10, 20, 5, 5, 20, 5, 5, 5, 5, 20, 10, 5, 5, 5, 5, 5, 5, 5, 5, 20, 5, 20, 5, 20, 10, 5, 10, 10, 20, 10, 20, 5, 10, 10, 20, 5, 5, 5, 5, 5, 5, 5, 20, 20, 5, 20, 20, 20, 5, 5, 5, 5, 10, 5, 5, 5, 5, 20, 5, 5, 20, 10, 5, 5, 5, 5, 5, 5, 20, 5, 5, 5, 10, 10, 5, 20, 10, 20, 10, 20, 5, 5, 5, 20, 5, 5, 5, 20, 10, 20, 5, 5, 5, 20, 5, 5, 5, 5, 5, 20, 5, 5, 10, 5, 5, 5, 5, 5, 20, 20, 5, 5, 5, 5, 5, 5, 5, 5, 20, 10, 5, 5, 20, 5, 5, 20, 20, 20, 5, 10, 10, 5, 5, 5, 5, 10, 20, 10, 10, 5, 5, 5, 5, 5, 20, 10, 5, 20, 10, 5, 10, 5, 5, 20, 5, 5, 5, 10, 5, 5, 5, 20, 5, 20, 5, 5, 5, 5, 5, 5, 5, 5, 10, 10, 5, 10, 10, 5, 5, 5, 20, 5, 5, 10, 5, 5, 5, 20, 20, 20, 20, 5, 5, 5, 5, 10, 5, 20, 5, 5, 20, 20, 5, 5, 20, 10, 10, 5, 5, 5, 20, 5, 5, 5, 5, 5, 10, 5, 20, 20, 5, 5, 5, 10, 20, 5, 20, 5, 20, 5, 5, 5, 5, 5, 5, 5, 20, 20, 20, 5, 5, 20, 20, 10, 5, 5, 5, 5, 5, 5, 5, 5, 20, 5, 20, 10, 20, 5, 5, 5, 5, 5, 5, 10, 5, 5, 10, 5, 5, 5, 5, 5, 20, 5, 5, 5, 5, 5, 10, 5, 5, 10, 10, 5, 10, 10, 5, 5, 20, 20, 5, 5, 5, 5, 5, 10, 5, 20, 10, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 20, 20, 5, 20, 5, 20, 20, 20, 10, 20, 10, 5, 5, 10, 10, 20, 5, 5, 5, 5, 5, 10, 5, 10, 5, 5, 5, 5, 5, 5, 20, 5, 5, 5, 20, 20, 20, 10, 5, 5, 10, 5, 5, 10, 5, 5, 20, 10, 20, 5, 5, 20, 20, 10, 20, 20, 5, 5, 5, 5, 5, 5, 5, 10, 5, 10, 10, 5, 10, 5, 20, 20, 10, 10, 5, 5, 20, 10, 5, 10, 10, 5, 5, 5, 5, 10, 5, 5, 20, 5, 5, 5, 5, 10, 5, 10, 5, 10, 5, 5, 5, 5, 10, 5, 5, 20, 5, 5, 5, 5, 5, 10, 20, 5, 10, 5, 10, 20, 10, 20, 20, 5, 5, 5, 5, 5, 20, 5, 10, 10, 5, 20, 5, 20, 10, 20, 10, 5, 10, 5, 5, 5, 5, 5, 5, 5, 5, 20, 5, 5, 5, 5, 5, 5, 20, 5, 5, 5, 10, 5, 5, 5, 5, 5, 5, 5, 10, 5, 10, 10, 20, 5, 20, 5, 5, 20, 5, 20, 5, 5, 5, 20, 10, 10, 5, 5, 5, 5, 5, 20, 10, 10, 5, 5, 5, 20, 10, 5, 10, 5, 5, 20, 10, 5, 5, 5, 5, 5, 5, 20, 5, 20, 5, 10, 10, 5, 5, 5, 5, 10, 5, 5, 5, 5, 10, 5, 10, 5, 10, 5, 10, 5, 5, 5, 5, 20, 5, 5, 20, 5, 5, 10, 5, 5, 5, 5, 10, 5, 5, 10, 5, 20, 5, 5, 5, 10, 10, 5, 20, 5, 5, 10, 5, 5, 10, 20, 5, 5, 5, 5, 10, 20, 20, 20, 5, 5, 10, 20, 5, 5, 5, 10, 5, 20, 5, 5, 5, 20, 5, 5, 5, 5, 5, 5, 20, 5, 20, 5, 10, 5, 20, 20, 10, 10, 5, 5, 10, 5, 5, 5, 5, 5, 5, 10, 20, 10, 10, 5, 5, 5, 5, 5, 20, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 20, 10, 20, 20, 5, 5, 5, 5, 5, 5, 10, 5, 5, 5, 10, 20, 10, 20, 5, 10, 5, 5, 5, 5, 5, 5, 10, 10, 5, 5, 10, 20, 10, 5, 5, 5, 5, 20, 5, 5, 20, 5, 5, 10, 5, 5, 5, 5, 5, 5, 10, 20, 5, 20, 20, 10, 10, 10, 20, 10, 20, 5, 5, 10, 10, 5, 20, 5, 5, 10, 5, 5, 5, 5, 5, 5, 5, 10, 20, 10, 10, 5, 10, 20, 5, 5, 20, 5, 10, 5, 5, 10, 5, 20, 10, 10, 10, 5, 5, 5, 5, 5, 5, 5, 20, 5, 5, 20, 10, 5, 5, 20, 5, 5, 5, 5, 20, 20, 5, 10, 5, 20, 5, 5, 5, 5, 5, 5, 20, 10, 20, 20, 10, 5, 5, 5, 5, 5, 5, 20, 5, 10, 5, 5, 5, 5, 5, 10, 5, 5, 5, 20, 20, 5, 10, 20, 20, 20, 10, 20, 5, 5, 5, 5, 20, 5, 5, 5, 5, 20, 5, 5, 5, 5, 20, 5, 20, 5, 5, 5, 5, 5, 5, 10, 5, 5, 5, 5, 5, 10, 5, 10, 5, 10, 5, 5, 20, 10, 20, 10, 20, 5, 5, 5, 5, 5, 10, 20, 10, 20, 20, 10, 5, 5, 10, 5, 5, 10};

        int[] C = new int[]{8, 0, 4, 4, 1, 7, 3, 6, 5, 9, 3, 6, 6, 0, 2, 5, 1, 7, 7, 7, 8, 7, 1, 4, 4, 5, 4, 8, 7, 6, 2, 2, 9, 4, 7, 5, 6, 2, 2, 8, 4, 6, 0, 4, 7, 8, 9, 1, 7, 0};
        int[] D = new int[]{6, 9, 8, 1, 1, 5, 7, 3, 1, 3, 3, 4, 9, 2, 8, 0, 6, 9, 3, 3, 7, 8, 3, 4, 2, 4, 7, 4, 5, 7, 7, 2, 5, 6, 3, 6, 7, 0, 3, 5, 3, 2, 8, 1, 6, 6, 1, 0, 8, 4};

        int[] test = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

        TreeNode treeNode = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        String[] x = {"eat", "tea", "tan", "ate", "nat", "bat"};
        char[][] table = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        char[][] table2 = new char[][]{{'A','B'}};
        //[6,7,6,0,4]

        List<List<String>> equations = new ArrayList<>();
        double[] values = new double[2];
        List<List<String>> queries = new ArrayList<>();

        //[[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]]
        int[][] A2 = new int[][]{{1,0,0,1}, {0,1,1,0}, {0,1,1,1}, {1,0,1,1}};
        int[][] A3 = new int[][]{{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        String[][] Str = new String[][]{{"John", "johnsmith@mail.com", "john00@mail.com"},
                {"John", "johnnybravo@mail.com"},
                {"John", "johnsmith@mail.com", "john_newyork@mail.com"}, {"Mary", "mary@mail.com"}};


        List<List<String>> list = new ArrayList<>();
        List<String> arr = new ArrayList<>();
        arr.add("John");
        arr.add("john00@mail.com");
        list.add(arr);

        List<String> arr1 = new ArrayList<>();
        arr1.add("John");
        arr1.add("johnnybravo@mail.com");
        list.add(arr1);

        List<String> arr2 = new ArrayList<>();
        arr2.add("John");
        arr2.add("johnsmith@mail.com");
        arr2.add("john_newyork@mail.com");
        list.add(arr2);

        List<String> arr3 = new ArrayList<>();
        arr3.add("Mary");
        arr3.add("mary@mail.com");
        list.add(arr3);


        int[] B2 = new int[]{-100,-98,-1,2,3,4};
        int[] B3 = new int[]{1,0,1,0,0,0,0,0,0,0,0,1,1,1,0,0,1,0,1,1,1,1,1,1,0,0,0,1,0,1,1,1,1,0,1,1,0,1,0,1,0,0,0,1,0,0,0,0,0,1,0,0,1,1,0,0,1,1,1};
        System.out.print(new Question721().accountsMerge(list));

        long endTime = System.currentTimeMillis();
        System.out.println("\n\n执行时间:" + (endTime - startTime) + "ms");
    }
}
