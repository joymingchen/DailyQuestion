package com.joyming;

import com.joyming.Solution.Question151;
import com.joyming.Solution.Question260;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();


//        String[] test = {"flower","flow","fl"};
        String test = "a good  example";
        int[] nums = new int[]{1,2,1,3,2,5};
        System.out.println(test);
//        System.out.println(Arrays.toString(test));
        String result = Arrays.toString(new Question260().singleNumber(nums));
        System.out.println(result);

        long endTime = System.currentTimeMillis();
        System.out.println("\n\n执行时间:" + (endTime - startTime) + "ms");
    }
}
