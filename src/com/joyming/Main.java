package com.joyming;

import com.joyming.Solution.Question2530;

public class Main {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();


//        String[] test = {"flower","flow","fl"};
        String test = "a good  example";
        String haystack = "mississippi", needle = "issipi";
//        int[] nums = new int[]{881784984,829998714,730002802,56524562,120336848,548306998,801116106,828640251,519131180,819176153,476262254,15904939,540793851,53572296,259044378,491129827,561147559,205793082,967833729};
        int[] nums = new int[]{1, 10, 3, 3, 3};
//        int n = 16;
        int n = 3;
        System.out.println(test);
//        System.out.println(Arrays.toString(test));
        String result = String.valueOf(new Question2530().maxKelements(nums, n));
        System.out.println(result);

        long endTime = System.currentTimeMillis();
        System.out.println("\n\n执行时间:" + (endTime - startTime) + "ms");
    }
}
