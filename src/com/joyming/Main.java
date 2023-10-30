package com.joyming;

import com.joyming.Solution.Question275;
import com.joyming.Solution.Question279;
import com.joyming.Solution.Question283;
import com.joyming.Solution.Question752;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        long startTime = System.currentTimeMillis();


//        String[] test = {"flower","flow","fl"};
        String test = "a good  example";
        String haystack = "mississippi", needle = "issip";
//        String haystack = "aabaaabaaac", needle = "aabaaac";
//        String haystack = "ACTGPACTGKACTGPACY", needle = "ACTGPACY";
//        int[] nums = new int[]{881784984,829998714,730002802,56524562,120336848,548306998,801116106,828640251,519131180,819176153,476262254,15904939,540793851,53572296,259044378,491129827,561147559,205793082,967833729};
        int[] nums = new int[]{0,1,3,5,6};
        int n = 1248;
        int k = 6;
        int target = 7;
        System.out.println(test);
//        System.out.println(Arrays.toString(test));

        char[][] grid = new char[][]{{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};

        int h = 5, w = 4;
        int[] horizontalCuts = new int[]{1, 3};
        int[] verticalCuts = new int[]{1};
        String result = String.valueOf(new Question275().hIndex2(nums));

        System.out.println(result);

        long endTime = System.currentTimeMillis();
        System.out.println("\n\n执行时间:" + (endTime - startTime) + "ms");
    }
}
