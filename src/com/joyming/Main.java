package com.joyming;

import com.joyming.Solution.*;
import com.joyming.Data.TreeNode;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();


//        String[] test = {"flower","flow","fl"};
        String test = "babad";
        System.out.println(test);
//        System.out.println(Arrays.toString(test));
        String result = new Question5().longestPalindrome4(test);
        System.out.println(result);

        long endTime = System.currentTimeMillis();
        System.out.println("\n\n执行时间:" + (endTime - startTime) + "ms");
    }
}
