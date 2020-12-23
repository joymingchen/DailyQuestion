package com.joyming.Solution;


import java.util.*;

/**
 * 767. 重构字符串
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 * <p>
 * 示例 1:
 * 输入: S = "aab"
 * 输出: "aba"
 * <p>
 * 示例 2:
 * 输入: S = "aaab"
 * 输出: ""
 * <p>
 * 注意:
 * S 只包含小写字母并且长度在[1, 500]区间内。
 */
public class Question767 {

    /**
     * 对所有字母进行统计
     * 基于计数的贪心算法
     */
    public String reorganizeString(String S) {
        if (S.length() < 2) {
            return S;
        }
        int length = S.length();
        char[] chars = S.toCharArray();
        int[] buckets = new int[26];
        int maxCount = 0;
        for (int i = 0; i < length; i++) {
            buckets[chars[i] - 'a']++;
            if (buckets[chars[i] - 'a'] > maxCount) {
                maxCount = buckets[chars[i] - 'a'];
            }
        }
        if (maxCount > (length + 1) / 2) {
            return "";
        }
        char[] answer = new char[length];
        int even = 0, odd = 1;
        int half = length / 2;
        for (int i = 0; i < 26; i++) {
            char c = (char) (i + 'a');
            //将字母放完，先放奇数位置
            while (buckets[i] > 0 && buckets[i] <= half && odd < length) {
                answer[odd] = c;
                buckets[i]--;
                odd += 2;
            }
            while (buckets[i] > 0) {
                answer[even] = c;
                buckets[i]--;
                even += 2;
            }
        }
        return new String(answer);
    }

    /**
     * 基于最大堆的贪心算法
     */
    public String reorganizeString2(String S) {
        if (S.length() < 2) {
            return S;
        }
        int length = S.length();
        char[] chars = S.toCharArray();
        int[] buckets = new int[26];
        int maxCount = 0;
        for (int i = 0; i < length; i++) {
            buckets[chars[i] - 'a']++;
            if (buckets[chars[i] - 'a'] > maxCount) {
                maxCount = buckets[chars[i] - 'a'];
            }
        }
        if (maxCount > (length + 1) / 2) {
            return "";
        }
        PriorityQueue<Character> queue = new PriorityQueue<Character>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return buckets[o2 - 'a'] - buckets[o1 - 'a'];
            }
        });
        for(int i = 0;i< 26;i++){
            if(buckets[i] > 0){
                queue.offer((char) ('a' + i));
            }
        }
        String answer = "";
        while (queue.size() > 1){
            char letter1 = queue.poll();
            char letter2 = queue.poll();
            answer += letter1;
            answer += letter2;
            buckets[letter1 - 'a']--;
            buckets[letter2 - 'a']--;
            if(buckets[letter1 - 'a'] > 0){
                queue.offer(letter1);
            }
            if(buckets[letter2 - 'a'] > 0){
                queue.offer(letter2);
            }
        }
        if(queue.size() > 0){
            answer+= queue.poll();
        }
        return answer;
    }
}
