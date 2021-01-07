package com.joyming.CodingInterview;

import java.util.HashMap;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * <p>
 * <p>
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * <p>
 * 提示：
 * s.length <= 40000
 */
public class Offer48 {

    /**
     * 首先第一想到双指针
     * 滑动窗口
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int answer = 0;
        //利用map来存储出现的位置
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0, j = 0; j < n; j++) {
            if (hashMap.containsKey(s.charAt(j))) {
                i = Math.max(i, hashMap.get(s.charAt(j)));
            }
            answer = Math.max(j - i + 1, answer);

            hashMap.put(s.charAt(j), j + 1);
        }
        return answer;
    }
}
