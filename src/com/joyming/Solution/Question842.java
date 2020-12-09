package com.joyming.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 842. 将数组拆分成斐波那契序列
 * 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
 * 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
 * 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
 * F.length >= 3；
 * 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
 * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
 * 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
 * <p>
 * 示例 1：
 * 输入："123456579"
 * 输出：[123,456,579]
 * <p>
 * 示例 2：
 * 输入: "11235813"
 * 输出: [1,1,2,3,5,8,13]
 * <p>
 * 示例 3：
 * 输入: "112358130"
 * 输出: []
 * 解释: 这项任务无法完成。
 * <p>
 * 示例 4：
 * 输入："0123"
 * 输出：[]
 * 解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
 * 示例 5：
 * <p>
 * 输入: "1101111"
 * 输出: [110, 1, 111]
 * 解释: 输出 [11,0,11,11] 也同样被接受。
 * <p>
 * 提示：
 * 1 <= S.length <= 200
 * 字符串 S 中只含有数字。
 */
public class Question842 {

    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> list = new ArrayList<>();
        backTrack(S.toCharArray(), list, 0);
        return list;
    }

    /**
     * 回溯
     */
    private boolean backTrack(char[] toCharArray, List<Integer> list, int index) {
        //终止条件(递归必须要有终止条件)
        if (index == toCharArray.length && list.size() >= 3) {
            return true;
        }

        for (int i = index; i < toCharArray.length; i++) {
            if (toCharArray[index] == '0' && i > index) {
                break;
            }

            long num = subDigit(toCharArray, index, i + 1);
            if (num > Integer.MAX_VALUE) {
                break;
            }

            int size = list.size();
            if (size >= 2 && num > list.get(size - 1) + list.get(size - 2)) {
                break;
            }
            if (size < 2 || num == list.get(size - 1) + list.get(size - 2)) {
                list.add((int) num);
                if (backTrack(toCharArray, list, i + 1)) {
                    return true;
                }
                list.remove(list.size() - 1);
            }
        }

        return false;
    }

    private long subDigit(char[] chars, int start, int end) {
        int res = 0;
        for (int i = start; i < end; i++) {
            res = res * 10 + chars[i] - '0';
        }
        return res;
    }


}
