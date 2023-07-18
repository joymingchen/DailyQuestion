package com.joyming.Solution;

import java.util.Arrays;

/**
 * 14. 最长公共前缀
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * <p>
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 * <p>
 * All given inputs are in lowercase letters a-z.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question14 {
    /**
     * 取出第一个字符进行对比
     * 跟所有的字符比对，双循环
     * 执行用时：3 ms, 在所有 Java 提交中击败了22.28%的用户
     * 内存消耗：39.5 MB, 在所有 Java 提交中击败了5.00%的用户
     * 时间复杂度： O(n²)
     * 空间复杂度： O(1)
     */
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder answer = new StringBuilder();
        int length = strs.length;
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            return strs[0];
        }

        char[] chars = strs[0].toCharArray();

        //遍历数组
        //i : 第几个字符
        for (int i = 0; i < chars.length; i++) {
            //比较第一行字母没有匹配，后续也不用继续了
            if (i >= 1 && answer.toString().equals("")) {
                break;
            }

            //公共前缀
            String ggqz = String.valueOf(chars[i]);

            //匹配成功次数
            int successNum = 0;

            //遍历字符串
            //j: 第几组字符串
            for (int j = 0; j < length; j++) {
                if (i >= strs[j].length()) {
                    break;
                }

                //对比的字符
                String commonChar = strs[j].substring(i, i + 1);
                if (commonChar.equals(ggqz)) {
                    //对比成功
                    ++successNum;
                    if (successNum == length) {
                        answer.append(ggqz);
                    }
                    continue;
                }
                //对比不一样
                break;
            }
        }
        return answer.toString();
    }

    /**
     * 水平扫描 利用indexOf函数进行比较，对字符串裁剪
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38 MB, 在所有 Java 提交中击败了5.84%的用户
     * 时间复杂度： O(nm)
     * 空间复杂度： O(1)
     */
    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];

        for (String str : strs) {
            while (str.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }


    /**
     * 先排序然后首尾进行比较，找出公共部分就是答案
     * 执行用时：1 ms, 在所有 Java 提交中击败了82.17%的用户
     * 内存消耗：37.6 MB, 在所有 Java 提交中击败了35.00%的用户
     * 时间复杂度： O(nmLog(n))
     * 空间复杂度： O(1)
     */
    public static String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        //利用sort排序,升序
        Arrays.sort(strs);

        //取出首尾两个字符串
        String prefix = strs[0];
        String prefix2 = strs[strs.length - 1];

        //对比两个字符串，找出公共部分
        while (prefix2.indexOf(prefix) != 0) {
            prefix = prefix.substring(0, prefix.length() - 1);
        }

        return prefix;
    }


    public static String longestCommonPrefix4(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            prefix = compareWithTwoStr2(prefix, strs[i]);
        }

        return prefix;
    }

    public static String compareWithTwoStr(String a, String b) {
        if (a.length() == 0 || b.length() == 0) {
            return "";
        }
        StringBuilder prefix = new StringBuilder();
        int left = 0;
        int right = Math.min(a.length(), b.length());

        char[] as = a.toCharArray();
        char[] bs = b.toCharArray();
        int last = 0;
        while (left < right) {
            if (as[left] == bs[left] && (last == left || last + 1 == left)) {
                prefix.append(as[left]);
                last = left;
            }
            left++;
        }
        return prefix.toString();
    }

    public static String compareWithTwoStr2(String a, String b) {
        if (a.length() == 0 || b.length() == 0) {
            return "";
        }
        int left = 0;
        int right = Math.min(a.length(), b.length());

        char[] as = a.toCharArray();
        char[] bs = b.toCharArray();
        while (left < right && as[left] == bs[left]) {
            left++;
        }
        return a.substring(0, left);
    }

}
