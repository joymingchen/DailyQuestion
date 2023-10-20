package com.joyming.Solution;

/**
 * 485. 最大连续 1 的个数
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：nums = [1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 * <p>
 * 示例 2:
 * 输入：nums = [1,0,1,1,0,1]
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1.
 */
public class Question485 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int slow = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                slow = 0;
            } else {
                slow += 1;
            }
            max = Math.max(max,slow);
        }
        return max;
    }
}
