package com.joyming.Solution;

import java.util.PriorityQueue;
import java.util.Queue;


/**
 * 2530. 执行 K 次操作后的最大分数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。你的 起始分数 为 0 。
 * <p>
 * 在一步 操作 中：
 * 选出一个满足 0 <= i < nums.length 的下标 i ，
 * 将你的 分数 增加 nums[i] ，并且
 * 将 nums[i] 替换为 ceil(nums[i] / 3) 。
 * 返回在 恰好 执行 k 次操作后，你可能获得的最大分数。
 * <p>
 * 向上取整函数 ceil(val) 的结果是大于或等于 val 的最小整数。
 * <p>
 * <p>
 * 示例 1：
 * 输入：nums = [10,10,10,10,10], k = 5
 * 输出：50
 * 解释：对数组中每个元素执行一次操作。最后分数是 10 + 10 + 10 + 10 + 10 = 50 。
 * 示例 2：
 * <p>
 * * 输入：nums = [1,10,3,3,3], k = 3
 * 输出：17
 * 解释：可以执行下述操作：
 * 第 1 步操作：选中 i = 1 ，nums 变为 [1,4,3,3,3] 。分数增加 10 。
 * 第 2 步操作：选中 i = 1 ，nums 变为 [1,2,3,3,3] 。分数增加 4 。
 * 第 3 步操作：选中 i = 2 ，nums 变为 [1,1,1,3,3] 。分数增加 3 。
 * 最后分数是 10 + 4 + 3 = 17 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length, k <= 105
 * 1 <= nums[i] <= 109
 */
public class Question2530 {

    /**
     * 顺序队列
     *
     */
    public long maxKelements(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>((i, j) -> j - i);
        for (int num : nums) queue.offer(num);
        long answer = 0;
        for (int i = 0; i < k; i++) {
            answer += queue.peek();
            queue.offer((queue.poll() + 2) / 3);
        }
        return answer;
    }

    /**
     * 大于或等于 val 的最小整数。
     *
     * @param val
     * @return
     */
    private int ceil(int val) {
        return (val + 2) / 3;
    }
}
