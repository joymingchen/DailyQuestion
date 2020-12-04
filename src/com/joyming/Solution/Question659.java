package com.joyming.Solution;

import java.util.*;

/**
 * 659. 分割数组为连续子序列
 * 给你一个按升序排序的整数数组 num（可能包含重复数字），
 * 请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。
 * 如果可以完成上述分割，则返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入: [1,2,3,3,4,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3
 * 3, 4, 5
 * <p>
 * 示例 2：
 * 输入: [1,2,3,3,4,4,5,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 * <p>
 * 示例 3：
 * 输入: [1,2,3,4,4,5]
 * 输出: False
 */
public class Question659 {

    /**
     * 典型贪心算法
     * 先记录数字出现次数
     * 再记录区间结尾次数
     */
    public boolean isPossible(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        HashMap<Integer, Integer> countMap = new HashMap<>();
        HashMap<Integer, Integer> endMap = new HashMap<>();

        for(int num :nums){
            int count = countMap.getOrDefault(num,0) + 1;
            countMap.put(num,count);
        }

        for (int x : nums) {
            int count = countMap.getOrDefault(x, 0);
            if (count > 0) {
                int prevEndCount = endMap.getOrDefault(x - 1, 0);

                if (prevEndCount > 0) {
                    countMap.put(x, count - 1);
                    endMap.put(x - 1, prevEndCount - 1);
                    endMap.put(x, endMap.getOrDefault(x, 0) + 1);
                } else {
                    int count1 = countMap.getOrDefault(x + 1, 0);
                    int count2 = countMap.getOrDefault(x + 2, 0);

                    if (count1 > 0 && count2 > 0) {
                        countMap.put(x, --count);
                        countMap.put(x + 1, --count1);
                        countMap.put(x + 2, --count2);
                        endMap.put(x + 2, endMap.getOrDefault(x + 2, 0) + 1);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
