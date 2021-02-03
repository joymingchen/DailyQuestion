package com.joyming.Solution;

/**
 * 424. 替换后的最长重复字符
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，
 * 总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 * <p>
 * 注意：字符串长度 和 k 不会超过 104。
 * <p>
 * <p>
 * 示例 1：
 * 输入：s = "ABAB", k = 2
 * 输出：4
 * 解释：用两个'A'替换为两个'B',反之亦然。
 * <p>
 * 示例 2：
 * 输入：s = "AABABBA", k = 1
 * 输出：4
 * 解释：
 * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 * 子串 "BBBB" 有最长重复字母, 答案为 4。
 */
public class Question424 {

    /**
     * 桶排序
     * 滑动窗口
     */
    public int characterReplacement(String s, int k) {
        int n = s.length();
        if(n < 2){
            return n;
        }
        int answer = 0;
        int[] bucket = new int[26];
        int left = 0, right = 0;
        int maxCount = 0;
        while (right < n) {
            int c = ++bucket[s.charAt(right) - 'A'];
            maxCount = Math.max(maxCount, c);
            right++;

            if (right - left > maxCount + k) {
                bucket[s.charAt(left) - 'A'] --;
                left++;
            }
            answer = Math.max(answer,right - left);
        }
        return answer;
    }
}
