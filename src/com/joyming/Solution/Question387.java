package com.joyming.Solution;

import java.util.HashMap;

/**
 * 387. 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 示例：
 * s = "leetcode"
 * 返回 0
 * <p>
 * s = "loveleetcode"
 * 返回 2
 * <p>
 * 提示：你可以假定该字符串只包含小写字母。
 */
public class Question387 {

    /**
     * 哈希表计数
     */
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char nowChar = s.charAt(i);
            int num = hashMap.getOrDefault(nowChar, 0);
            hashMap.put(nowChar, ++num);
        }
        for (int i = 0; i < n; i++) {
            char nowChar = s.charAt(i);
            int num = hashMap.getOrDefault(nowChar, 0);
            if (num == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 桶排序计数
     */
    public int firstUniqChar2(String s) {
        int[] buckets = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            buckets[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            if (buckets[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
