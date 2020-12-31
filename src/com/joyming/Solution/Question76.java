package com.joyming.Solution;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * <p>
 * 示例 1：
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * <p>
 * 示例 2：
 * 输入：s = "a", t = "a"
 * 输出："a"
 * <p>
 * <p>
 * 提示：
 * 1 <= s.length, t.length <= 105
 * s 和 t 由英文字母组成
 */
public class Question76 {

    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }
        if (s.equals(t)) {
            return t;
        }
        String answer = "";
        int left = 0, right = -1;
        int n = s.length();

        //目标子串的字母个数
        HashMap<Character,Integer> targetCount = new HashMap<>();
        for (int i= 0;i<t.length();i++) {
            char c = t.charAt(i);
            targetCount.put(c, targetCount.getOrDefault(c, 0) + 1);
        }
        //截取子串的字母个数
        HashMap<Character,Integer> childCount = new HashMap<>();

        while (right < n) {
            right++;
            //记录截取子串的字母个数
            if(right < n && targetCount.containsKey(s.charAt(right))){
                int num = childCount.getOrDefault(s.charAt(right), 0);
                childCount.put(s.charAt(right), ++num);
            }

            while (check(targetCount,childCount) && left <= right){
                //2、截取的子串
                String str = s.substring(left, right + 1);
                if (answer.equals("")) {
                    answer = str;
                }
                if (str.length() < answer.length()) {
                    answer = str;
                }

                if (targetCount.containsKey(s.charAt(left))) {
                    childCount.put(s.charAt(left), childCount.getOrDefault(s.charAt(left), 0) - 1);
                }
                ++left;
            }
        }
        return answer;
    }

    public boolean check(HashMap<Character,Integer> targetCount,HashMap<Character,Integer> childCount){
        Iterator iter = targetCount.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (childCount.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }
}
