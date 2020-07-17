package com.joyming.Solution;

/**
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * 示例 2：
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
        if (s == null || s.length() < 2) {
            return s;
        }

        int begin = 0;
        int length = 1;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {

                //符合回文
                if (isPalindrome(s, i, j) && j - i + 1 > length) {
                    begin = i;
                    length = j - i + 1;
                }
            }
        }

        return s.substring(begin, begin + length);
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
     * 动态扩散
     * 一定要搞清楚状态转移方程 dp[i][j] = s[i] == s[j] and dp[i + 1][j - 1]
     *
     * 时间复杂度：O(n²)
     * 空间复杂度：O(n²)
     * 二维 dp 问题，一个状态得用二维有序数对表示
     * */
    public String longestPalindrome3(String s) {
        //判断特殊情况
        if (s == null || s.length() <= 1) {
            return s;
        }
        int length = s.length();

        int begin = 0;
        int maxLength = 1;

        boolean[][] table = new boolean[length][length];

        char[] chars = s.toCharArray();

        //初始化，一个字符一定是回文
        for(int i = 0;i < length;i++){
            table[i][i] = true;
        }

        //i 对应left  j对应right i<j
        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {

                if (chars[i] != chars[j]) {
                    //两个字符不相等,一定不是回文
                    table[i][j] = false;
                } else {
                    if (j - i + 1 <= 2) {
                        table[i][j] = true;
                    } else {
                        //参考原来的值
                        table[i][j] = table[i + 1][j - 1];
                    }
                }

                if(table[i][j] && j - i + 1 > maxLength){
                    begin = i;
                    maxLength = j - i + 1;
                }

            }
        }
        return s.substring(begin, begin + maxLength);
    }

    /**
     * 判断子串是否是回文 s[left,right]
     */
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
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

}
