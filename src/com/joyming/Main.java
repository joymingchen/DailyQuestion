package com.joyming;

import com.joyming.Solution.*;
import com.joyming.Data.TreeNode;

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

        TreeNode treeNode2 = new TreeNode(2, new TreeNode(2), new TreeNode(5, new TreeNode(5), new TreeNode(7)));

        int[][] matrix = {{1, 2, 3}, {1, 0, 1}, {1, 1, 1}};

        //[2147483647,2147483647,2147483647]
        TreeNode treeNode3 = new TreeNode(2147483647,
                new TreeNode(2147483647, new TreeNode(2147483647), null), null);

        //[[0,1,100],[1,2,100],[0,2,500]]
        int[][] flights = new int[3][3];
        flights[0] = new int[]{0, 1, 100};
        flights[1] = new int[]{1, 2, 100};
        flights[2] = new int[]{0, 2, 500};


        Question211 wordDictionary = new Question211();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
//        wordDictionary.search("pad"); // return False
//        wordDictionary.search("bad"); // return True
//        wordDictionary.search(".ad"); // return True
//        wordDictionary.search("b.."); // return True

        System.out.print(wordDictionary.search("pad") + "\n");
        System.out.print(wordDictionary.search("bad") + "\n");
        System.out.print(wordDictionary.search("b..") + "\n");
        System.out.print(wordDictionary.search("b..") + "\n");

        long endTime = System.currentTimeMillis();
        System.out.println("\n\n执行时间:" + (endTime - startTime) + "ms");
    }
}
