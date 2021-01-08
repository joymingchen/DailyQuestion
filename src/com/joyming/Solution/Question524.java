package com.joyming.Solution;

import java.util.List;

/**
 * 524. 通过删除字母匹配到字典里最长单词
 * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，
 * 该字符串可以通过删除给定字符串的某些字符来得到。
 * 如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
 * <p>
 * 示例 1:
 * 输入:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * 输出:
 * "apple"
 * <p>
 * 示例 2:
 * 输入:
 * s = "abpcplea", d = ["a","b","c"]
 * 输出:
 * "a"
 * <p>
 * 说明:
 * 所有输入的字符串只包含小写字母。
 * 字典的大小不会超过 1000。
 * 所有输入的字符串长度不会超过 1000。
 */
public class Question524 {

    /**
     * 注意字典序最小
     */
    public String findLongestWord(String s, List<String> d) {
        String answer = "";
        int n = s.length();
        int dSize = d.size();
        for (int i = 0; i < dSize; i++) {
            String item = d.get(i);
            int m = 0;
            int itemLength = item.length();
            for (int j = 0; j < n; j++) {
                if (m < itemLength) {
                    if (s.charAt(j) == item.charAt(m)) {
                        m++;
                    }
                    if (m == itemLength) {
                        if (itemLength > answer.length() ||
                                //字典序比较
                                (itemLength == answer.length() && item.compareTo(answer) < 0)) {
                            answer = item;
                        }
                    }
                }
            }
        }
        return answer;
    }

    /**
     * 双指针
     * Two-Pointer
     */
    public String findLongestWordTP(String s, List<String> d) {
        String answer = "";
        int n = s.length();
        int dSize = d.size();
        for (int i = 0; i < dSize; i++) {
            String item = d.get(i);
            int itemLength = item.length();

            int left = 0,right = 0;
            while (left < n && right < itemLength){
                if(s.charAt(left) == item.charAt(right)){
                    right++;
                }
                left++;
            }
            if(right == itemLength){
                if(itemLength > answer.length() ||
                        //字典序比较
                        (itemLength == answer.length() && item.compareTo(answer) < 0)){
                    answer = item;
                }
            }
        }
        return answer;
    }
}
