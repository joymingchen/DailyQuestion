package com.joyming.Solution;

import java.util.Arrays;

/**
 * 1155. 掷骰子等于目标和的方法数
 * 这里有 n 个一样的骰子，每个骰子上都有 k 个面，分别标号为 1 到 k 。
 * <p>
 * 给定三个整数 n ,  k 和 target ，返回可能的方式(从总共 kn 种方式中)滚动骰子的数量，使正面朝上的数字之和等于 target 。
 * <p>
 * 答案可能很大，你需要对 109 + 7 取模 。
 * <p>
 * <p>
 * 示例 1：
 * 输入：n = 1, k = 6, target = 3
 * 输出：1
 * 解释：你扔一个有 6 个面的骰子。
 * 得到 3 的和只有一种方法。
 * <p>
 * 示例 2：
 * 输入：n = 2, k = 6, target = 7
 * 输出：6
 * 解释：你扔两个骰子，每个骰子有 6 个面。
 * 得到 7 的和有 6 种方法：1+6 2+5 3+4 4+3 5+2 6+1。
 * <p>
 * 示例 3：
 * 输入：n = 30, k = 30, target = 500
 * 输出：222616187
 * 解释：返回的结果必须是对 109 + 7 取模。
 * <p>
 * <p>
 * 提示：
 * 1 <= n, k <= 30
 * 1 <= target <= 1000
 */
public class Question1155 {

    private static final int MOD = 1_000_000_007;

    /**
     * 分解问题：
     * 定义 dfs(i,j) 表示用 i 个骰子掷出数字之和恰好等于 j 的方案数
     * <p>
     * 掷出骰子点数为 1的问题分解为：剩下 i - 1 个骰子掷出总数为 j - 1 的问题
     * 掷出骰子点数为 2的问题分解为：剩下 i - 1 个骰子掷出总数为 j - 2 的问题
     * 。。。
     * 掷出骰子点数为 k的问题分解为：剩下 i - 1 个骰子掷出总数为 j - k 的问题
     */
    public int numRollsToTarget(int n, int k, int target) {
        if (target > n * k || target < n) {
            return 0;
        }
        //记忆化搜索
        int[][] memo = new int[n + 1][target + 1];
        for (int[] item :
                memo) {
            Arrays.fill(item, -1); // -1 表示没有计算过
        }
        return dfs(n, target - n, memo, k);

    }

    private int dfs(int i, int j, int[][] memo, int k) {
        if (i == 0) {
            return j == 0 ? 1 : 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int res = 0;
        for (int x = 0; x < k && x <= j; x++) {
            res = (res + dfs(i - 1, j - x, memo, k)) % MOD;
        }
        return memo[i][j] = res;
    }


}
