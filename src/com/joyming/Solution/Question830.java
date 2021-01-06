package com.joyming.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 830. 较大分组的位置
 * 在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
 * <p>
 * 例如，在字符串 s = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 * <p>
 * 分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。
 * 上例中的 "xxxx" 分组用区间表示为 [3,6] 。
 * <p>
 * 我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
 * <p>
 * 找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
 * <p>
 * <p>
 * 示例 1：
 * 输入：s = "abbxxxxzzy"
 * 输出：[[3,6]]
 * 解释："xxxx" 是一个起始于 3 且终止于 6 的较大分组。
 * <p>
 * 示例 2：
 * 输入：s = "abc"
 * 输出：[]
 * 解释："a","b" 和 "c" 均不是符合要求的较大分组。
 * <p>
 * 示例 3：
 * 输入：s = "abcdddeeeeaabbbcd"
 * 输出：[[3,5],[6,9],[12,14]]
 * 解释：较大分组为 "ddd", "eeee" 和 "bbb"
 * <p>
 * 示例 4：
 * 输入：s = "aba"
 * 输出：[]
 * <p>
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅含小写英文字母
 */
public class Question830 {

    /**
     * 双指针
     */
    public List<List<Integer>> largeGroupPositions(String s) {
        int n = s.length();
        List<List<Integer>> answer = new ArrayList<>();
        int left = 0, right = left + 1;
        int num = 1;
        while (right < n) {
            if (s.charAt(left) == s.charAt(right)) {
                num++;
                if (num >= 3) {
                    if (!answer.isEmpty() && answer.get(answer.size() - 1).contains(left)) {
                        //更新右区间
                        answer.get(answer.size() - 1).set(1, right);
                    } else {
                        answer.add(Arrays.asList(left, right));
                    }
                }
                right++;
            } else {
                left = right;
                right = left + 1;
                num = 1;
            }
        }
        return answer;
    }
}
