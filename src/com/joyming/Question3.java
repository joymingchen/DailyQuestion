package com.joyming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Question3 {

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度 (longest-substring-without-repeating-characters)
     * <p>
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * <p>
     * 利用滑动窗口降低时间复杂度
     * 双循环变单循环
     * 解决数组/字符串的子串的极值问题
     * <p>
     * 时间复杂度 O(n)
     *
     * @param s
     * @return
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
     *
     * @param s
     * @return
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
