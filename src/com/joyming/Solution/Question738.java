package com.joyming.Solution;

/**
 * 738. 单调递增的数字
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 * <p>
 * 示例 1:
 * 输入: N = 10
 * 输出: 9
 * <p>
 * 示例 2:
 * 输入: N = 1234
 * 输出: 1234
 * <p>
 * 示例 3:
 * 输入: N = 332
 * 输出: 299
 * 说明: N 是在 [0, 10^9] 范围内的一个整数。
 */
public class Question738 {

    /**
     * 暴力法
     * 指定超时
     */
    public int monotoneIncreasingDigits(int N) {
        int answer = N;
        for (; answer >= 0; answer--) {
            char[] item = String.valueOf(answer).toCharArray();

            boolean isAllIncrease = true;
            int previous = 0;
            for (char x : item) {
                if ((int) x >= previous) {
                    previous = x;
                } else {
                    isAllIncrease = false;
                }
            }

            if (isAllIncrease) {
                return answer;
            }
        }
        return answer;
    }

    /**
     * 贪心算法
     * 如果高位比低位低，那高位减1，低位变9
     */
    public int monotoneIncreasingDigits2(int N) {
        if (N < 10) {
            return N;
        }
        char[] chars = String.valueOf(N).toCharArray();

        int index = -1;
        //从后往前遍历
        for (int i = chars.length - 1; i - 1 >= 0; i--) {
            if(chars[i - 1] > chars[i]){
                chars[i - 1] -= 1;
                chars[i] = '9';
                index = i;
            }
        }

        if(index >= 0){
            for(int i = index;i<chars.length;i++){
                if(chars[i] != '9'){
                    chars[i] = '9';
                }
            }
        }
        return Integer.parseInt(String.valueOf(chars));
    }
}
