package com.joyming.Solution;

/**
 * 31. 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class Question31 {

    /**
     * 注意到下一个排列总是比当前排列要大，除非该排列已经是最大的排列。我们希望找到一种方法，
     * 能够找到一个大于当前序列的新序列，且变大的幅度尽可能小。具体地：
     *
     * 我们需要将一个左边的「较小数」与一个右边的「较大数」交换，以能够让当前排列变大，从而得到下一个排列。
     *
     * 同时我们要让这个「较小数」尽量靠右，而「较大数」尽可能小。
     * 当交换完成后，「较大数」右边的数需要按照升序重新排列。
     * 这样可以在保证新排列大于原来排列的情况下，使变大的幅度尽可能小。
     *
     * 以排列 [4,5,2,6,3,1][4,5,2,6,3,1] 为例：
     *
     * 我们能找到的符合条件的一对「较小数」与「较大数」的组合为 22 与 33，满足「较小数」尽量靠右，而「较大数」尽可能小。
     *
     * 当我们完成交换后排列变为 [4,5,3,6,2,1][4,5,3,6,2,1]，
     * 此时我们可以重排「较小数」右边的序列，序列变为 [4,5,3,1,2,6][4,5,3,1,2,6]。
     *
     */
    public void nextPermutation(int[] nums) {
        if(nums.length < 2){
            return;
        }
        int i = nums.length - 2;
        while (i >= 0 && nums[i] < nums[i + 1]) {
            i--;
        }

        if(i >= 0){
            int j = nums.length - 1;
            while (j>=0 && nums[i] < nums[j]){
                j -- ;
            }
            swap(nums,i,j);
        }
        //升序
        reverse(nums, i + 1);
    }

    /**
     * 根据下标交换位置
     * @param nums
     * @param i
     * @param j
     */
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 降序改升序
     * @param nums
     * @param start
     */
    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
