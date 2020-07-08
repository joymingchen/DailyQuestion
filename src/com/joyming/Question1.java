package com.joyming;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question1 {

    /**
     * 暴力解法，双循环
     * <p>
     * 执行用时：81 ms, 在所有 Java 提交中击败了20.78%的用户
     * 内存消耗：40.1 MB, 在所有 Java 提交中击败了5.06%
     * 的用户
     * 时间复杂度：O(n²)
     * 空间复杂度：O(1)
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 两遍哈希表，利用空间换取时间
     * 将数组存进哈希表中,哈希表增加了空间复杂度，储存了n个元素
     * <p>
     * 执行用时：3 ms, 在所有 Java 提交中击败了75.36%的用户
     * 内存消耗：39.2 MB, 在所有 Java 提交中击败了5.06%的用户
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        //先存进哈希表中
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        //第二遍找出答案
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                //不能是本身
                if (map.get(target - nums[i]) != i) {
                    return new int[]{i, map.get(target - nums[i])};
                }

            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 一遍哈希表，存进哈希表的同时，对元素进行比对
     * <p>
     * 执行用时：2 ms, 在所有 Java 提交中击败了99.59%的用户
     * 内存消耗：39.7 MB, 在所有 Java 提交中击败了5.06%的用户
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        //存进哈希表中
        for (int i = 0; i < nums.length; i++) {
            //先在表中查找
            if (map.containsKey(target - nums[i])) {
                //不能是本身
                if (map.get(target - nums[i]) != i) {
                    return new int[]{map.get(target - nums[i]), i};
                }
            }
            //存起来
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
