package com.joyming;

import com.joyming.Solution.Question200;

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
        int[] nums = new int[]{1, 0, 0, 2, 1, 4, 7, 8, 9, 6, 7, 10, 8};
        int n = 1248;
        int k = 6;
        int target = 7;
        System.out.println(test);

        String[] parents = new String[]{"4", "13", "5", "/", "+"};

        char[][] grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        String result = String.valueOf(new Question200().numIslands(grid));

        System.out.println(result);

        long endTime = System.currentTimeMillis();
        System.out.println("\n\n执行时间:" + (endTime - startTime) + "ms");
    }
}
