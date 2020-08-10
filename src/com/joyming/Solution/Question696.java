package com.joyming.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 696. 计数二进制子串
 * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
 * <p>
 * 重复出现的子串要计算它们出现的次数。
 * <p>
 * 示例 1 :
 * <p>
 * 输入: "00110011"
 * 输出: 6
 * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
 * <p>
 * 请注意，一些重复出现的子串要计算它们出现的次数。
 * <p>
 * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
 * 示例 2 :
 * <p>
 * 输入: "10101"
 * 输出: 4
 * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
 * 注意：
 * <p>
 * s.length 在1到50,000之间。
 * s 只包含“0”或“1”字符。
 */
public class Question696 {

    /**
     * 我们可以将字符串 ss 按照 00 和 11 的连续段分组，存在counts数组中，例如 s = 00111011，
     * 可以得到这样的 counts数组：counts={2,3,1,2}
     * <p>
     * 这里 counts 数组中两个相邻的数一定代表的是两种不同的字符。
     * <p>
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    public int countBinarySubstrings(String s) {
        List<Integer> integerList = new ArrayList<>();
        int p = 0;
        int n = s.length();

        while (p < n) {
            char last = s.charAt(p);
            int count = 0;
            while (p < n && last == s.charAt(p)) {
                ++p;
                ++count;
            }
            integerList.add(count);
        }

        int answer = 0;
        for (int i = 1; i < integerList.size(); i++) {
            answer += Math.min(integerList.get(i - 1), integerList.get(i));
        }
        return answer;
    }

    /**
     * 空间优化
     * 对于某一个位置 i，其实我们只关心 i−1 位置的 counts 值是多少，
     * 所以可以用一个last变量来维护当前位置的前一个位置，这样可以省去一个 counts数组的空间。
     * <p>
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    public int countBinarySubstrings2(String s) {
        int answer = 0;
        int p = 0;
        int n = s.length();
        int last = 0;
        while (p < n) {
            char lastChar = s.charAt(p);
            int current = 0;
            while (p < n && lastChar == s.charAt(p)) {
                ++p;
                ++current;
            }

            answer += Math.min(last, current);
            last = current;
        }

        return answer;
    }

}
