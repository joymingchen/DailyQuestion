package com.joyming.Solution;

import java.util.Arrays;

/**
 * 628. 三个数的最大乘积
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: 6
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: 24
 * 注意:
 * <p>
 * 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 */
public class Question628 {

    /**
     * 贪心算法
     * 先排序，找出最大的三个数
     * 判断有负数的情况
     * 时间复杂度：O(NlogN)
     * 空间复杂度：O(NlogN)
     */
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[n - 1] * nums[n - 2] * nums[n - 3], nums[0] * nums[1] * nums[n - 1]);
    }

    /**
     * 线性扫描
     * 一遍遍历，找出最大的三个数
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     */
    public int maximumProduct2(int[] nums) {
        int n = nums.length;
        int maxNum1 = Integer.MIN_VALUE, maxNum2 = Integer.MIN_VALUE, maxNum3 = Integer.MIN_VALUE;
        int minNum1 = Integer.MAX_VALUE, minNum2 = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            //最小的两个数
            int x = nums[i];
            if (x <= minNum1) {
                minNum2 = minNum1;
                minNum1 = x;
            } else if (x <= minNum2) {
                minNum2 = x;
            }

            if (x >= maxNum1) {
                maxNum3 = maxNum2;
                maxNum2 = maxNum1;
                maxNum1 = x;
            } else if (x >= maxNum2) {
                maxNum3 = maxNum2;
                maxNum2 = x;
            } else if (x >= maxNum3) {
                maxNum3 = x;
            }
        }
        return Math.max(maxNum1 * maxNum2 * maxNum3, minNum1 * minNum2 * maxNum3);
    }

    /**
     * 暴力破解
     * 时间复杂度：O(n^3)
     * 空间复杂度：O(1)
     */
    public int maximumProduct3(int[] nums) {
        int n = nums.length;
        int answer = nums[n - 3] * nums[n - 2] * nums[n - 1];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    answer = Math.max(answer, nums[i] * nums[j] * nums[k]);
                }
            }
        }
        return answer;
    }
}
