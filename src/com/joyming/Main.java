package com.joyming;

import com.joyming.CodingInterview.Question_01_08;
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

        int[] test = new int[]{5, 3, 4, 5};

        TreeNode treeNode = new TreeNode(10, new TreeNode(5, new TreeNode(3), new TreeNode(7)),
                new TreeNode(15, null, new TreeNode(18)));

        int[][] matrix = {{1,2,3},{1,0,1},{1,1,1}};


        System.out.print(new Question_01_08().setZeroes(matrix));

        long endTime = System.currentTimeMillis();
        System.out.println("\n\n执行时间:" + (endTime - startTime) + "ms");
    }
}
