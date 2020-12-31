package com.joyming.Solution;

/**
 * 633. 平方数之和
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 * <p>
 * 示例 1：
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * <p>
 * 示例 2：
 * 输入：c = 3
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：c = 4
 * 输出：true
 * <p>
 * 示例 4：
 * 输入：c = 2
 * 输出：true
 * <p>
 * 示例 5：
 * 输入：c = 1
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * 0 <= c <= 231 - 1
 */
public class Question633 {

    public boolean judgeSquareSum(int c) {
        for (int a = 0; a * a <= c; a++) {
            int b = c - (int) (a * a);
            if (binarySearch(0, b, b)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 双指针
     */
    public boolean judgeSquareSum2(int c) {
        if (c < 0)
            return false;
        int i = 0;//双指针的左指针
        int j = (int) Math.sqrt(c);//双指针的右指针
        while (i <= j) {
            if (i * i == c - j * j)
                return true;
            else if (c - j * j < i * i)
                j--;
            else
                i++;
        }
        return false;
    }

    /**
     * 直接用sqrt函数
     */
    public boolean judgeSquareSum3(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b)
                return true;
        }
        return false;
    }

    /**
     * 二分查找
     */
    private boolean binarySearch(int left, int right, int target) {
        if (left > right) {
            return false;
        }
        int mid = left + (right - left) / 2;
        if (mid * mid == target) {
            return true;
        }
        if (mid * mid > target) {
            return binarySearch(0, mid - 1, target);
        }
        return binarySearch(mid + 1, right, target);
    }
}
