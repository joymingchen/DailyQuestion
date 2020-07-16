package com.joyming.Solution;

/**
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question5 {

    /**
     * 暴力解法
     * 双循环判断所有字符串
     * 超出时间限制，不符合
     * 时间复杂度：O(n³)
     * 空间复杂度：O(1)
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 1) {
            return s;
        }

        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String current = s.substring(i, j);

                //符合回文
                if (isPalindrome(current)) {
                    if (current.length() > answer.length()) {
                        answer = current;
                    }
                }
            }
        }

        return answer;
    }

    /**
     * 中心扩散法 一段字符串有2n+1个中心
     */
    public String longestPalindrome2(String s) {
        //判断特殊情况
        if (s == null || s.length() <= 1) {
            return s;
        }
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {

            //奇数中心点
            int oddLength = expandAroundCenter(s, i, i);
            //偶数中心点
            int evenLength = expandAroundCenter(s, i, i + 1);

            int length = Math.max(oddLength, evenLength);

            if (length > (end - start)) {
                start = i - ((length - 1) / 2);
                end = i + (length / 2);
            }

        }
        return s.substring(start, end + 1);
    }

    /**
     * 中心扩散
     */
    public int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;

        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    /**
     * @param s
     */
    public boolean isPalindrome(String s) {
        int length = s.length();

        for (int i = 0; i < length / 2; i++) {
            if (s.charAt(i) != s.charAt(length - i - 1)) {
                return false;
            }
        }

        return true;
    }

}
