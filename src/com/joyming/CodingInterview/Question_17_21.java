package com.joyming.CodingInterview;

/**
 * 面试题 17.21. 直方图的水量
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class Question_17_21 {

    /**
     * 动态规划
     * 因此可以正向遍历数组 height 得到数组 leftMax 的每个元素值，反向遍历数组 height 得到数组 rightMax 的每个元素值。
     *
     * 在得到数组 leftMax 和 rightMax 的每个元素值之后，对于 0≤i<n，下标 i 处能接的水的量等于
     * min(leftMax[i],rightMax[i])−height[i]。遍历每个下标位置即可得到能接的水的总量。
     *
     */
    public int trap(int[] height) {
        int n = height.length;
        int water = 0;
        if(n <=2){
            return water;
        }

        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n ; i++) {
            leftMax[i] = Math.max(leftMax[i - 1],height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n -1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[ i + 1],height[i]);
        }

        for (int i = 0; i < n; i++) {
            water += Math.min(rightMax[i] ,leftMax[i]) - height[i];
        }
        return water;
    }

    /**
     * 双指针
     */
    public int trap2(int[] height) {
        int n = height.length;
        int water = 0;
        if(n <=2){
            return water;
        }

        return water;
    }
}
