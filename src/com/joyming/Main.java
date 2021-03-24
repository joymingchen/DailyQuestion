package com.joyming;

import com.joyming.Data.NestedInteger;
import com.joyming.Solution.*;
import com.joyming.Data.ListNode;
import com.joyming.Data.TreeNode;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

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
        int[][] A3 = new int[][]{{0,1,1},{1,2,1},{0,2,1},{2,3,4},{3,4,2},{3,5,2},{4,5,2}};

        int[][] A4 = new int[][]{{0,1,1},{0,3,1},{0,2,1},{1,2,1},{1,3,1},{2,3,1}};
        int[][] A6 = new int[][]{{5,4},{6,4},{6,7},{2,3}};
        int[][] A7 = new int[][]{{2,100},{3,200},{4,300},{5,250},{5,400},{5,500},{6,370},{6,360},{7,380}};

        String[] words1 = new String[]{"apple","pleas","please"};
        String[] puzzles1 = new String[]{"aelwxyz","aelpxyz","aelpsxy","saelpxy","xaelpsy"};

        List<NestedInteger> nestedList =new ArrayList<>();

        NestedInteger nestedInteger = new NestedInteger() {
            @Override
            public boolean isInteger() {
                return true;
            }

            @Override
            public Integer getInteger() {
                return 2;
            }

            @Override
            public List<NestedInteger> getList() {
                return new ArrayList<>();
            }
        };

        nestedList.add(new NestedInteger() {
            @Override
            public boolean isInteger() {
                return true;
            }

            @Override
            public Integer getInteger() {
                return 5;
            }

            @Override
            public List<NestedInteger> getList() {
                return null;
            }
        });
        nestedList.add(new NestedInteger() {
            @Override
            public boolean isInteger() {
                return false;
            }

            @Override
            public Integer getInteger() {
                return 3;
            }

            @Override
            public List<NestedInteger> getList() {
                List<NestedInteger> nestedIntegerList = new ArrayList<>();
                nestedIntegerList.add(nestedInteger);
                nestedIntegerList.add(nestedInteger);
                return nestedIntegerList;
            }
        });
        Question341.NestedIterator i = new Question341.NestedIterator(nestedList);
        while (i.hasNext()){
            Integer num = i.next();

            System.out.print("\n" + num);

        }




//        System.out.print(new Question354().maxEnvelopes(A7));

        long endTime = System.currentTimeMillis();
        System.out.println("\n\n执行时间:" + (endTime - startTime) + "ms");
    }
}
