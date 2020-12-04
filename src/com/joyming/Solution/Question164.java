package com.joyming.Solution;

import java.util.Arrays;

/**
 * 164. 最大间距
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 * 如果数组元素个数小于 2，则返回 0。
 * <p>
 * 示例 1:
 * 输入: [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 * <p>
 * 示例 2:
 * 输入: [10]
 * 输出: 0
 * 解释: 数组元素个数小于 2，因此返回 0。
 * 说明:
 * 你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
 * 请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
 */
public class Question164 {

    /**
     * 关键在于直接用sort排序，有点年轻人不讲码德
     * 时间复杂度是nlogN，不符合要求
     */
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int answer = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int gap = nums[i + 1] - nums[i];
            if (gap > answer) {
                answer = gap;
            }
        }
        return answer;
    }

    /**
     * 桶排序 时间复杂度O(n)
     */
    public int maximumGap2(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        //初始化桶
        int N = nums.length;
        int minVal = Arrays.stream(nums).min().getAsInt();
        int maxVal = Arrays.stream(nums).max().getAsInt();
        int d = Math.max(1,(maxVal - minVal) / (N - 1));
        int bucketSize =  (maxVal - minVal) / d + 1;
        int[][] buckets = new int[bucketSize][2];
        for (int i = 0; i < bucketSize; ++i) {
            // 存储 (桶内最小值，桶内最大值) 对， (-1, -1) 表示该桶是空的
            Arrays.fill(buckets[i], -1);
        }

        for (int i = 0; i < N; i++) {
            int indexVal = (nums[i] - minVal) / d;
            if (buckets[indexVal][0] == -1) {
                buckets[indexVal][0] = buckets[indexVal][1] = nums[i];
            } else {
                buckets[indexVal][0] = Math.min(nums[i], buckets[indexVal][0]);
                buckets[indexVal][1] = Math.max(nums[i], buckets[indexVal][1]);
            }
        }

        int answer = 0;
        int lastNum = 0;
        for (int i = 0; i < bucketSize; i++) {
            if (buckets[i][0] == -1) {
                continue;
            }

            int gap = buckets[i][0] - buckets[lastNum][1];
            if (gap > answer) {
                answer = gap;
            }
            lastNum = i;
        }
        return answer;
    }
}
