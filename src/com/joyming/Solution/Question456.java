package com.joyming.Solution;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * 456.132 模式(Medium)
 * 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
 * <p>
 * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * 进阶：很容易想到时间复杂度为 O(n^2) 的解决方案，你可以设计一个时间复杂度为 O(n logn) 或 O(n) 的解决方案吗？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * 解释：序列中不存在 132 模式的子序列。
 * <p>
 * 示例 2：
 * 输入：nums = [3,1,4,2]
 * 输出：true
 * 解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
 * <p>
 * 示例 3：
 * 输入：nums = [-1,3,2,0]
 * 输出：true
 * 解释：序列中有 3 个 132 模式的的子序列：[-1, 3, 2]、[-1, 3, 0] 和 [-1, 2, 0] 。
 * <p>
 * <p>
 * 提示：
 * n == nums.length
 * 1 <= n <= 104
 * -109 <= nums[i] <= 109
 */
public class Question456 {

    /**
     * 三层for循环
     * 时间复杂度：O(n^3)
     */
    public boolean find132pattern2(int[] nums) {
        boolean answer = false;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int medium = nums[j];
                if (left < medium) {
                    for (int m = j + 1; m < nums.length; m++) {
                        int right = nums[m];
                        if (medium > right) {
                            return true;
                        }
                    }
                }
            }
        }
        return answer;
    }

    /**
     * 三层for循环改为双层for循环
     * 对最后一位进行讨论
     * 时间复杂度：O(n^2)
     */
    public boolean find132pattern3(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        for (int i3 = 2; i3 < nums.length; i3++) {
            int i1 = 0;
            for (; i1 < i3; i1++) {
                if (nums[i1] < nums[i3]) {
                    break;
                }
            }

            int i2 = i1 + 1;
            for (; i2 < i3; i2++) {

                if (nums[i3] < nums[i2]) {
                    return true;
                }
            }

        }
        return false;
    }

    /***
     * 枚举所有3的值
     * 时间复杂度：O(n * log(n))
     */
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        //先确定左边最小值
        int leftMin = nums[0];
        TreeMap<Integer,Integer> rightAllMap = new TreeMap<>();
        //列出右边的所有值
        for (int i = 2; i < nums.length; i++) {
            rightAllMap.put(nums[i],rightAllMap.getOrDefault(nums[i],0) + 1);
        }

        //枚举所有的中间的值
        for (int i = 1; i < nums.length - 1; i++) {
            if(leftMin < nums[i]){
                //在右边所有的值中，找到大于或等于左边值的最小值
                Integer right = rightAllMap.ceilingKey(leftMin + 1);
                if(right != null  && right < nums[i]){
                    return true;
                }
            }
            leftMin = Math.min(leftMin,nums[i]);
            rightAllMap.put(nums[i + 1],rightAllMap.get(nums[i + 1]) - 1);
            if(rightAllMap.get(nums[i + 1]) == 0){
                rightAllMap.remove(nums[i + 1]);
            }
        }
        return false;
    }

}
