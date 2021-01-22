package com.joyming.Solution;

import java.util.Stack;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 */
public class Question20 {
    public boolean isValid(String s) {
        if (s == null || s.equals("")) {
            return false;
        }
        int n = s.length();
        if (n % 2 != 0) {
            return false;
        }

        Stack<String> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            String item = String.valueOf(chars[i]);
            if(item.equals("(") || item.equals("[")||item.equals("{")){
                stack.push(item);
            }else {
                if(!stack.isEmpty()){
                    if(!isMatch(stack.pop(),item)){
                        return false;
                    }
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isMatch(String left, String right) {
        switch (left) {
            case "(":
                if (right.equals(")")) {
                    return true;
                }
                break;
            case "[":
                if (right.equals("]")) {
                    return true;
                }
                break;
            case "{":
                if (right.equals("}")) {
                    return true;
                }
                break;
        }
        return false;
    }

}
