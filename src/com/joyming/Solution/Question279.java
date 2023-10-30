package com.joyming.Solution;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 279. 完全平方数
 * <p>
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * <p>
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 * <p>
 * 示例 2：
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 * <p>
 * 提示：
 * 1 <= n <= 10^4
 */
public class Question279 {

    /**
     * bfs
     */
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);

        int level = 0;

        //记录
        Set<Integer> visited = new HashSet<>();
        visited.add(n);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int cur = queue.poll();

                if (isPerfectNumber(cur)) {
                    return level + 1;
                }

                for (int j = cur - 1; j > 0; j--) {
                    int left = j;
                    int right = cur - j;


                    if (isPerfectNumber(left)) {
                        if (isPerfectNumber(right)) {
                            level += 2;
                            return level;
                        }
                        queue.offer(right);
                    }

                }
            }

            level++;
        }
        return level;
    }

    private boolean isPerfectNumber(int n) {
        return Math.sqrt(n) % 1 == 0;
    }

    /**
     * 动态规划
     * 公式为：dp[60]=min(dp[60],dp[11]+1,)
     * dp[i] = min(dp[i],dp[i - j * j] + 1)
     */
    public int numSquares2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
