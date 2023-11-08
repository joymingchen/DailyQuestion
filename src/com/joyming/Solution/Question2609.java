package com.joyming.Solution;

/**
 * 2609. 最长平衡子字符串
 * <p>
 * 给你一个仅由 0 和 1 组成的二进制字符串 s 。
 * <p>
 * 如果子字符串中 所有的 0 都在 1 之前 且其中 0 的数量等于 1 的数量，则认为 s 的这个子字符串是平衡子字符串。请注意，空子字符串也视作平衡子字符串。
 * <p>
 * 返回  s 中最长的平衡子字符串长度。
 * <p>
 * 子字符串是字符串中的一个连续字符序列。
 * <p>
 * <p>
 * 示例 1：
 * 输入：s = "01000111"
 * 输出：6
 * 解释：最长的平衡子字符串是 "000111" ，长度为 6 。
 * <p>
 * 示例 2：
 * 输入：s = "00111"
 * 输出：4
 * 解释：最长的平衡子字符串是 "0011" ，长度为  4 。
 * <p>
 * 示例 3：
 * 输入：s = "111"
 * 输出：0
 * 解释：除了空子字符串之外不存在其他平衡子字符串，所以答案为 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 50
 * '0' <= s[i] <= '1'
 */
public class Question2609 {

    /**
     * 中心扩散
     */
    public int findTheLongestBalancedSubstring(String s) {
        int n = s.length();
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int left = i;
            int right = i + 1;

            while (left >= 0 && right < n && s.charAt(left) == '0' && s.charAt(right) == '1') {
                //向外扩散
                left--;
                right++;
            }
            answer = Math.max(answer, right - (left + 1));
        }
        return answer;
    }
}
