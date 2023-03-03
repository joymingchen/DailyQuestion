package com.joyming.Solution;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 217. 存在重复元素
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 * <p>
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3,1]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：nums = [1,1,1,3,3,4,3,2,4,2]
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
public class Question217 {

    ///超出时间限制
    public boolean containsDuplicate2(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            int left = nums[i];
            for (int j = 1 + i; j < length; j++) {
                int right = nums[j];
                if (left == right) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsDuplicate(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return false;
        }
        HashMap<Integer, Integer> buckets = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int index = nums[i];

            int value = buckets.getOrDefault(index, 0);
            if (value == 0) {
                buckets.put(index, 1);
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate3(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }


}
