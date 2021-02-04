package com.joyming.Solution;

import java.util.Arrays;

/**
 * 643. 子数组最大平均数 I
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 */
public class Question643 {

    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int left = 0, right = k - 1;
        double answer = -10000;
        int[] current = new int[k];
        for (int i = 0; i < k; i++) {
            current[i] = nums[i];
        }
        double sum = Arrays.stream(current).sum();
        while (right < n) {
            if (left != 0) {
                sum = sum + nums[right];
            }
            answer = Math.max(answer, sum / k);
            sum = sum - nums[left];
            left++;
            right++;
        }
        return answer;
    }

}
