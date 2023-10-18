package com.joyming.Custom;

/**
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * 示例 2：
 * <p>
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 * <p>
 * 提示：
 * <p>
 * 1 <= haystack.length, needle.length <= 104
 * haystack 和 needle 仅由小写英文字符组成
 * <p>
 * 作者：LeetCode
 * 链接：https://leetcode.cn/leetbook/read/array-and-string/cm5e2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class StrStr {

    public int strStr(String haystack, String needle) {
        int answer = -1;
        if (haystack.length() < needle.length()) {
            return answer;
        }
        int left = 0, right = 0;
        while (left < haystack.length()) {

            int index = left;
            right = 0;
            boolean isMatch = false;
            while (right < needle.length()) {
                if (haystack.length() - left < needle.length()) {
                    break;
                }
                if (haystack.charAt(index) == needle.charAt(right)) {
                    right++;
                    index++;
                    isMatch = true;
                    answer = left;
                } else {
                    isMatch = false;
                    answer = -1;
                    break;
                }
            }

            left++;
            if (isMatch) {
                break;
            }
        }
        return answer;
    }

    /**
     * 利用KMP算法
     */
    public int strStrKMP(String haystack, String needle) {
        int answer = -1;
        if (haystack.length() < needle.length()) {
            return answer;
        }
        //构建next数组
        int[] next = buildNext(needle);

        int m = haystack.length(), i = 0;
        int n = needle.length(), j = 0;
        while (i < m && j < n) {
            if (j < 0 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        if (j == n) {
            answer = i - j;
        }
        return answer;
    }

    private int[] buildNext(String p) {
        int[] next = new int[p.length()];
        int t = -1, j = 0;
        next[0] = -1;
        while (j < p.length() - 1) {
            if (t < 0 || p.charAt(t) == p.charAt(j)) {
                t++;
                j++;
                next[j] = t;
            } else {
                t = next[t];
            }
        }
        return next;
    }

}
