package com.joyming.Solution;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class Question283 {

    /**
     * 向后交换,暴力法
     * 时间复杂度：O(n²)
     * 空间复杂度：1
     */
    public int[] moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == 0) {
                    //和后面的一个元素交换
                    if (j + 1 >= nums.length) {
                        continue;
                    }
                    swap(nums, j, j + 1);
                }
            }
        }
        return nums;
    }

    /**
     * 双指针
     */
    public int[] moveZeroes2(int[] nums) {
        //左指针为0的位置i
        for (int i = 0, j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                //交换
                swap(nums, i, j);
                i++;
            }
        }
        return nums;
    }

    /**
     * 不为0就覆盖最前面，后面再全补0
     */
    public int[] moveZeroes3(int[] nums) {
        int nowIndex = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[nowIndex++] = nums[j];
            }
        }

        for (; nowIndex < nums.length; nowIndex++) {
            nums[nowIndex] = 0;
        }
        return nums;
    }

    /**
     * 交换
     */
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    /**
     * 快慢指针
     */
    public void moveZeroes4(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return;
        }
        for (int i = 0, j = 0; j < n; j++) {
            if (nums[j] != 0) {
                swap(nums, i, j);
                i++;
            }
        }
    }

}
