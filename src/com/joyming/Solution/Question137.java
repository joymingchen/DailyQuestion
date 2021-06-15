package com.joyming.Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 137.只出现一次的数字 II (Medium)
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * <p>
 * <p>
 * 示例 1：
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * <p>
 * 示例 2：
 * 输入：nums = [0,1,0,1,0,1,99]
 * 输出：99
 * <p>
 * <p>
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
 */
public class Question137 {

    /**
     * 双层循环
     * O(n²)
     */
    public int singleNumber(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            boolean isHave = false;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (nums[i] == nums[j]) {
                    isHave = true;
                    break;
                }
            }
            if (!isHave) {
                return nums[i];
            }
        }
        return nums[n - 1];
    }

    /**
     * 用map来记录
     * O(n)
     */
    public int singleNumber2(int[] nums) {
        int n = nums.length;
        int[][] table = new int[2][n];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Integer integer :
                map.keySet()) {
            if (map.get(integer) == 1){
                return integer;
            }
        }
        return nums[0];
    }
}
