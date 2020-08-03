package com.joyming.Solution;

import java.util.Stack;

/**
 * 415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * <p>
 * 注意：
 * <p>
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 */
public class Question415 {

    /**
     * 竖式计算
     * 将字符串转换为数组，提高查询效率
     */
    public String addStrings(String num1, String num2) {

        char[] charsNum1 = num1.toCharArray();
        char[] charsNum2 = num2.toCharArray();

        int i = num1.length() - 1;
        int j = num2.length() - 1;
        //进位
        int add = 0;
        StringBuilder answer = new StringBuilder();
        while (i >= 0 || j >= 0 || add != 0) {
            int a1 = i >= 0 ? charsNum1[i] - '0' : 0;
            int a2 = j >= 0 ? charsNum2[j] - '0' : 0;

            int result = a1 + a2 + add;
            add = result / 10;

            answer.append(result % 10);

            i--;
            j--;
        }
        //反转
        answer.reverse();
        return answer.toString();
    }

    /**
     * 竖式计算
     * 利用栈来保存每一位的结果，栈进栈出
     * 效率太低
     */
    public String addStrings2(String num1, String num2) {

        char[] charsNum1 = num1.toCharArray();
        char[] charsNum2 = num2.toCharArray();

        int i = num1.length() - 1;
        int j = num2.length() - 1;
        //进位
        int add = 0;
        StringBuilder answer = new StringBuilder();
        //栈
        Stack<Integer> stack = new Stack<>();
        while (i >= 0 || j >= 0 || add != 0) {
            int a1 = i >= 0 ? charsNum1[i] - '0' : 0;
            int a2 = j >= 0 ? charsNum2[j] - '0' : 0;

            int result = a1 + a2 + add;
            add = result / 10;

            stack.push(result % 10);
//            answer.append(result % 10);

            i--;
            j--;
        }

        while (!stack.isEmpty()){
            answer.append(stack.pop());
        }

        return answer.toString();
    }

}
