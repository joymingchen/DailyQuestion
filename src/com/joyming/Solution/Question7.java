package com.joyming.Solution;

/**
 * 7. 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 */
public class Question7 {
    /**
     * 整数反转
     */
    public int reverse(int x) {
        String num = String.valueOf(x);
        char[] nums = num.toCharArray();

        int left = 0;
        int right = nums.length - 1;

        if (nums[0] == '-') {
            left = 1;
        }

        while (left < right) {
            char temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }

//        double answer = Double.parseDouble(String.valueOf(nums).trim());
//        if (answer > Integer.MAX_VALUE || answer < Integer.MIN_VALUE) {
//            return 0;
//        }
//        int answerInt = (int) answer;
//        return answerInt;
        try {
            return Integer.parseInt(String.valueOf(nums));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public int reverse2(int x) {
        boolean isOdd = false;
        String num = String.valueOf(x);
        if (x < 0) {
            isOdd = true;
            num = num.substring(1);
        }

        String nums = new StringBuilder(num).reverse().toString();
        double answer = Double.parseDouble((isOdd ? "-" : "") + nums);
        if (answer > Integer.MAX_VALUE || answer < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) answer;
    }

}
