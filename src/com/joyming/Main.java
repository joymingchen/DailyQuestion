package com.joyming;

import com.joyming.Solution.Question151;

public class Main {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();


//        String[] test = {"flower","flow","fl"};
        String test = "a good  example";
        System.out.println(test);
//        System.out.println(Arrays.toString(test));
        String result = new Question151().reverseWords(test);
        System.out.println(result);

        long endTime = System.currentTimeMillis();
        System.out.println("\n\n执行时间:" + (endTime - startTime) + "ms");
    }
}
