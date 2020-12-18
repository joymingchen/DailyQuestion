package com.joyming.Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 389. 找不同
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 请找出在 t 中被添加的字母。
 * <p>
 * 示例 1：
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * <p>
 * 示例 2：
 * 输入：s = "", t = "y"
 * 输出："y"
 * <p>
 * 示例 3：
 * 输入：s = "a", t = "aa"
 * 输出："a"
 * <p>
 * 示例 4：
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 * <p>
 * 提示：
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s 和 t 只包含小写字母
 */
public class Question389 {

    /**
     * 桶排序
     */
    public char findTheDifference(String s, String t) {
        if (s.equals("")) {
            return t.charAt(0);
        }
        int[] sBuckets = new int[26];
        int[] tBuckets = new int[26];
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for (char tChar : tChars) {
            tBuckets[tChar - 'a']++;
        }
        for (char sChar : sChars) {
            sBuckets[sChar - 'a']++;
        }
        for (int i = 0; i < tBuckets.length; i++) {
            if (tBuckets[i] != sBuckets[i]) {
                return (char) ('a' + i);
            }
        }
        return tChars[s.length()];
    }
}
