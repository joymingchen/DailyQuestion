package com.joyming.Solution;

import java.util.HashMap;

/**
 * 697.数组的度(Easy)
 * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 * <p>
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * <p>
 * <p>
 * 示例 1：
 * 输入：[1, 2, 2, 3, 1]
 * 输出：2
 * 解释：
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * <p>
 * 示例 2：
 * 输入：[1,2,2,3,1,4,2]
 * 输出：6
 * <p>
 * <p>
 * 提示：
 * nums.length 在1到 50,000 区间范围内。
 * nums[i] 是一个在 0 到 49,999 范围内的整数。
 */
public class Question697 {

    /**
     * 两次遍历 + 哈希表
     */
    public int findShortestSubArray(int[] nums) {
        int n = nums.length;
        int du = getDu(nums);

        HashMap<Integer, Integer> map = new HashMap();
        int left = 0, right = 0;
        int answer = n;
        while (right < n) {

            int num = map.getOrDefault(nums[right], 0);
            map.put(nums[right], ++num);

            while (map.get(nums[right]) == du) {
                answer = Math.min(answer, right - left + 1);

                int num2 = map.getOrDefault(nums[left], 0);
                map.put(nums[left], --num2);
                left++;
            }
            right++;
        }
        return answer;
    }

    public int getDu(int[] nums) {
        int du = 0;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < n; i++) {
            int num = map.getOrDefault(nums[i], 0);
            map.put(nums[i], num + 1);
            du = Math.max(du, num + 1);
        }
        return du;
    }

    /**
     * 一次遍历
     * 记录数字第一次出现的位置和出现的次数
     * pair[0] 第一次出现的位置
     * pair[1] 出现的次数
     */
    public int findShortestSubArray2(int[] nums) {
        int n = nums.length;
        int maxCount = 0;
        HashMap<Integer, int[]> map = new HashMap();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int[] pair = map.get(nums[i]);

            if (pair == null) {
                pair = new int[]{i, 1};
            } else {
                pair[1]++;
            }
            map.put(nums[i], pair);
            if (pair[1] > maxCount) {
                maxCount = pair[1];
                answer = i - pair[0] + 1;
            } else if (pair[1] == maxCount) {
                answer = Math.min(answer, i - pair[0] + 1);
            }
        }
        return answer;
    }

}
