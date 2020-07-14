package com.joyming.Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question3 {

    /**
     * <p>
     * 利用滑动窗口降低时间复杂度
     * 双循环变单循环
     * 解决数组/字符串的子串的极值问题
     * <p>
     * 时间复杂度 O(n)
     */
    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int answer = 0;
        //用于存储窗口右侧
        HashMap<Character, Integer> map = new HashMap<>();

        //窗口左边i 右边j , 右边一直右移
        for (int i = 0, j = 0; j < length; j++) {
            //如果包含，则左边指针右移
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }

            //保存最大长度
            answer = Math.max(answer, j - i + 1);

            //将每个字符和下标保存
            map.put(s.charAt(j), j + 1);
        }

        return answer;
    }

    /**
     * 暴力算法
     * brute force attack
     * 把所有的子串列举出来，进行对比，记录下最长的
     */
    public static int lengthOfLongestSubstringUseBruteForceAttack(String s) {
        int length = s.length();
        int answer = 0;

        //储存字符串中所有的字符
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                //排列出所有组合

                //检查字符串中是否有重复
                if (list.contains(s.charAt(j))) {
                    break;
                } else {
                    list.add(s.charAt(j));
                }
            }

            //没有重复，记录下最大长度
            answer = Math.max(list.size(), answer);

            list.clear();
        }
        return answer;
    }
}
