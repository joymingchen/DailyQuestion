package com.joyming.Solution;

import java.util.Arrays;

/**
 * 204. 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 * <p>
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：n = 1
 * 输出：0
 */
public class Question204 {

    /**
     * 暴力法一定会超过时间限制
     * 时间复杂度：O(n√n)。单个数检查的时间复杂度为 O(n√n)，一共要检查 O(n)个数，因此总时间复杂度为O(n√n)
     * 空间复杂度：O(1)
     */
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        int total = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                total++;
            }
        }
        return total;
    }

    /**
     * 判断是否是质数
     * 通过枚举[2，√X]是否被整除
     */
    public boolean isPrime(int x) {
        for (int i = 2; i * i <= x; ++i) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 埃氏筛
     * 时间复杂度：O(nloglogn)
     * 空间复杂度：O(n)
     */
    public int countPrimes2(int n) {
        int[] primeInts = new int[n];
        Arrays.fill(primeInts, 1);
        int total = 0;
        for (int i = 2; i < n; i++) {
            if (primeInts[i] == 1) {
                total += 1;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        primeInts[j] = 0;
                    }
                }
            }
        }
        return total;
    }
}
