package com.joyming.Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 260. 只出现一次的数字 III
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 * <p>
 * 你必须设计并实现线性时间复杂度的算法且仅使用常量额外空间来解决此问题。
 * <p>
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,1,3,2,5]
 * 输出：[3,5]
 * 解释：[5, 3] 也是有效的答案。
 * <p>
 * 示例 2：
 * 输入：nums = [-1,0]
 * 输出：[-1,0]
 * <p>
 * 示例 3：
 * 输入：nums = [0,1]
 * 输出：[1,0]
 * <p>
 * 提示：
 * 2 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * 除两个只出现一次的整数外，nums 中的其他数字都出现两次
 */
public class Question260 {

    /**
     * 哈希表
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> counter = new HashMap<Integer, Integer>();
        for (int num : nums) {
            counter.merge(num, 1, Integer::sum);
        }

        int[] answer = new int[2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if (entry.getValue() == 1) {
                answer[index++] = entry.getKey();
            }
        }
        return answer;
    }
}
