package com.joyming;

import com.joyming.Solution.*;
import com.joyming.data.ListNode;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

//        ListNode listNode = new ListNode(4);
//        listNode.next = new ListNode(2);
//        listNode.next.next = new ListNode(1);
//        listNode.next.next.next = new ListNode(3);
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

        //[[10,16],[2,8],[1,6],[7,12]]
        //{-2147483646,-2147483645}, {2147483646,2147483647}
        // {1,2},{3,4},{5,6},{7,8}
        //[[10,16],[2,8],[1,6],[7,12]]
        //[[3,9],[7,12],[3,8],[6,8],[9,10],[2,9],[0,9],[3,9],[0,6],[2,8]]

//        int[][] test = {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
//[-1,-1]
//[-1,1]
//[-1,1]
//[1,-1]
//        nums1 = [3, 4, 6, 5]
// * nums2 = [9, 1, 2, 5, 8, 3]
        int[][] A = new int[][]{{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        int[] B = new int[]{6,0,4};
        int[] C = new int[]{-1,1};
        int[] D = new int[]{1,-1};

        int[] test = new int[]{3,6,9,1};
        System.out.print(new Question842().splitIntoFibonacci("0123"));

        long endTime = System.currentTimeMillis();
        System.out.println("\n\n执行时间:" + (endTime - startTime) + "ms");
    }
}
