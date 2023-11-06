package com.joyming.Solution;

/**
 * 318. 最大单词长度乘积
 * <p>
 * 给你一个字符串数组 words ，找出并返回 length(words[i]) * length(words[j]) 的最大值，并且这两个单词不含有公共字母。如果不存在这样的两个单词，返回 0 。
 * <p>
 * <p>
 * 示例 1：
 * 输入：words = ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出：16
 * 解释：这两个单词为 "abcw", "xtfn"。
 * <p>
 * 示例 2：
 * 输入：words = ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出：4
 * 解释：这两个单词为 "ab", "cd"。
 * <p>
 * 示例 3：
 * 输入：words = ["a","aa","aaa","aaaa"]
 * 输出：0
 * 解释：不存在这样的两个单词。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= words.length <= 1000
 * 1 <= words[i].length <= 1000
 * words[i] 仅包含小写字母
 */
public class Question318 {

    /**
     * 位运算
     */
    public int maxProduct(String[] words) {
        int n = words.length;
        int answer = 0;
        if (n < 2) {
            return answer;
        }
        int[] buckets = new int[n];

        for (int i = 0; i < n; i++) {
            String word = words[i];
            char[] chars = word.toCharArray();
            for (int j = 0; j < word.length(); j++) {
                buckets[i] |= 1 << chars[j] - 'a';
            }
        }

        for (int i = 0; i < n; i++) {
            int x = buckets[i];
            for (int j = i + 1; j < n; j++) {
                int y = buckets[j];
                if ((x & y) == 0) {
                    answer = Math.max(words[i].length() * words[j].length(), answer);
                }
            }
        }

        return answer;
    }
}
