package com.joyming.Solution;

/**
 * 922. 按奇偶排序数组 II
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * <p>
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * <p>
 * 你可以返回任何满足上述条件的数组作为答案。
 * <p>
 * 示例：
 * <p>
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 */
public class Question922 {

    /**
     * 两遍遍历
     */
    public int[] sortArrayByParityII(int[] A) {
        int[] results = new int[A.length];
        //先放偶数
        for (int i = 0, j = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                //偶数
                results[j] = A[i];
                j += 2;
                A[i] = -1;
            }
        }
        //再放奇数
        for (int i = 0, j = 1; i < A.length; i++) {
            if (A[i] == -1) {
                continue;
            }
            if (A[i] % 2 != 0) {
                //奇数
                results[j] = A[i];
                j += 2;
            }
        }
        return results;
    }

    /**
     * 双指针
     * 直接在数组中进行交换
     */
    public int[] sortArrayByParityII2(int[] A) {
        for (int i = 0, j = 1; i < A.length; i += 2) {
            if (A[i] % 2 != 0) {
                //偶数下标不是偶数，不符合条件
                while (A[j] % 2 != 0) {
                    //寻找奇数下标也不是奇数的，因为一半偶数一半奇数，所以一定存在
                    j += 2;
                }
                swap(A, i, j);
            }
        }
        return A;
    }

    public void swap(int[] arrays, int i, int j) {
        int temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = temp;
    }
}
