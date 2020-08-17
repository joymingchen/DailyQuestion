package com.joyming.Solution;

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

        if (s.equals("")) {
            return true;
        }
        if (s.length() % 2 != 0) {
            return false;
        }

        String left = "({[";

        char[] chars = s.toCharArray();


        if (s.length() == 2 || s.length() == 4 || s.length() == 6) {
            //非对称结构
            if (s.contains("()") && s.contains("[]") && s.contains("{}")) {
                return true;
            } else if (s.contains("()") && s.contains("[]")) {
                return true;
            } else if (s.contains("()") && s.contains("{}")) {
                return true;
            } else if (s.contains("[]") && s.contains("{}")) {
                return true;
            }

            //对称结构
            for (int i = 0; i < (s.length() / 2); i++) {
                if (!left.contains(String.valueOf(chars[i]))) {
                    return false;
                }
                switch (chars[i]) {
                    case '(':
                        if (chars[s.length() - i - 1] == ')') {
                            continue;
                        } else {
                            return false;
                        }
                    case '[':
                        if (chars[s.length() - i - 1] == ']') {
                            continue;
                        } else {
                            return false;
                        }
                    case '{':
                        if (chars[s.length() - i - 1] == '}') {
                            continue;
                        } else {
                            return false;
                        }
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
