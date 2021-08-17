package com.joyming.Solution;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 224.基本计算器(Hard)
 * 实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：s = "1 + 1"
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * <p>
 * 示例 3：
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 * <p>
 * <p>
 * 提示：
 * 1 <= s.length <= 3 * 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 */
public class Question224 {

    public int calculate(String s) {

        Stack<Character> stack = new Stack<>();

        StringBuilder sb = new StringBuilder(s);

        int lastIndex = 0;
        for (int i = 0; i < sb.length(); i++) {
            char current = sb.charAt(i);
            if (current == '(') {
                lastIndex = i;
            } else if (current == ')') {
                String caStr = sb.substring(lastIndex, i + 1);
                int num = total(caStr);
                sb.replace(lastIndex, i + 1, num + "");
            }
        }
        return total(sb.toString());
    }

    public int total(String s) {
        int num = 0;
        String lastChar = "";

        Deque<String> numStack = new ArrayDeque<>();
        Deque<Character> symbolStack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if (current != '(' && current != ')') {
                if (current == '+' || current == '-') {
                    if(!lastChar.equals("")){
                        numStack.push(lastChar);
                    }

                    symbolStack.push(current);
                    lastChar = "";
                } else if (current == ' ') {

                } else {
                    //数字
                    lastChar += current;
                }
            }
        }
        numStack.push(lastChar);

        boolean isNegative = false;
        if (numStack.size() == symbolStack.size()) {
            //判断正负
            isNegative = true;
        }
        int total = 0;
        while (numStack.size() >= 2) {

            int numA = Integer.parseInt(numStack.pollLast());

            int numB = Integer.parseInt(numStack.pollLast());

            char symbol = symbolStack.pollLast();

            if (!symbolStack.isEmpty() && symbolStack.peekLast() == '-' && symbolStack.size() == 1) {
                numB = -1 * numB;
                symbolStack.pollLast();
            }

            if(symbol == '+'){
                total = numA + numB;
            }else {
                total = numA - numB;
            }
            numStack.push(String.valueOf(total));
        }

        num = Integer.parseInt(numStack.pop());

        return num;
    }

}
