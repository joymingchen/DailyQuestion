package com.joyming.Solution;

/**
 * 541.反转字符串 II (Easy)
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * <p>
 * <p>
 * 示例 1：
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * <p>
 * 示例 2：
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 * <p>
 * 提示：
 * 1 <= s.length <= 104
 * s 仅由小写英文组成
 * 1 <= k <= 104
 */
public class Question541 {

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int doubleK = 2 * k;
        int left = 0, right = doubleK - 1;
        while (left < right) {
            if (right < chars.length) {
                reverse(chars, left, left + k - 1);
            } else {
                if (left < chars.length) {
                    int lastLength = chars.length - (left + 1);

                    if (lastLength < k) {
                        reverse(chars, left, chars.length - 1);
                    } else {
                        reverse(chars, left, left + k - 1);
                    }
                } else {
                    break;
                }
            }
            left = right + 1;
            right = left + doubleK - 1;
        }
        return String.valueOf(chars);
    }

    public String reverseStr2(String s, int k){
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i += 2 * k) {
            reverse(chars, i, Math.min(i + k, n) - 1);
        }
        return String.valueOf(chars);
    }


    private void reverse(char[] s, int left, int right) {
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

}
