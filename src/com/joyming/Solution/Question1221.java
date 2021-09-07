package com.joyming.Solution;

/**
 * 1221.分割平衡字符串 (Easy)
 * 在一个 平衡字符串 中，'L' 和 'R' 字符的数量是相同的。
 * 给你一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
 * 注意：分割得到的每个字符串都必须是平衡字符串。
 * 返回可以通过分割得到的平衡字符串的 最大数量 。
 * <p>
 * <p>
 * 示例 1：
 * 输入：s = "RLRRLLRLRL"
 * 输出：4
 * 解释：s 可以分割为 "RL"、"RRLL"、"RL"、"RL" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
 * <p>
 * 示例 2：
 * 输入：s = "RLLLLRRRLR"
 * 输出：3
 * 解释：s 可以分割为 "RL"、"LLLRRR"、"LR" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
 * <p>
 * 示例 3：
 * 输入：s = "LLLLRRRR"
 * 输出：1
 * 解释：s 只能保持原样 "LLLLRRRR".
 * <p>
 * 示例 4：
 * 输入：s = "RLRRRLLRLL"
 * 输出：2
 * 解释：s 可以分割为 "RL"、"RRRLLRLL" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
 * <p>
 * <p>
 * 提示：
 * 1 <= s.length <= 1000
 * s[i] = 'L' 或 'R'
 * s 是一个 平衡 字符串
 */
public class Question1221 {

    /**
     * 贪心
     */
    public int balancedStringSplit(String s) {
        int ans = 0, d = 0;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == 'L') {
                ++d;
            } else {
                --d;
            }
            if (d == 0) {
                ++ans;
            }
        }
        return ans;
    }

    /**
     * 双循环
     */
    public int balancedStringSplit2(String s) {
        int n = s.length();
        if (n < 2) {
            return 1;
        }
        int answer = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isBalanced(chars, i, j)) {
                    answer++;
                    i = j ;
                    break;
                }
            }
        }
        return answer;
    }

    public boolean isBalanced(char[] chars, int left, int right) {
        int n = right - left + 1;
        int totalL = 0;
        int totalR = 0;
        for (int i = left; i <= right; i++) {
            if (chars[i] == 'L') {
                totalL++;
            }
        }
        totalR = n - totalL;
        return totalL == totalR;
    }
}
