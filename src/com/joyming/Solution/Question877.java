package com.joyming.Solution;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 877.石子游戏(Medium)
 * 亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。
 * <p>
 * 游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
 * <p>
 * 亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。
 * <p>
 * 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
 * <p>
 * 假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例：
 * 输入：[5,3,4,5]
 * 输出：true
 * 解释：
 * 亚历克斯先开始，只能拿前 5 颗或后 5 颗石子 。
 * 假设他取了前 5 颗，这一行就变成了 [3,4,5] 。
 * 如果李拿走前 3 颗，那么剩下的是 [4,5]，亚历克斯拿走后 5 颗赢得 10 分。
 * 如果李拿走后 5 颗，那么剩下的是 [3,4]，亚历克斯拿走后 4 颗赢得 9 分。
 * 这表明，取前 5 颗石子对亚历克斯来说是一个胜利的举动，所以我们返回 true 。
 * <p>
 * <p>
 * 提示：
 * 2 <= piles.length <= 500
 * piles.length 是偶数。
 * 1 <= piles[i] <= 500
 * sum(piles) 是奇数。
 */
public class Question877 {

    /**
     * 先手必赢
     */
    public boolean stoneGame(int[] piles) {
        int alex = 0, lee = 0;
        int left = 0, right = piles.length - 1;
        while (left < right) {
            if (piles[left] >= piles[right]) {
                alex += piles[left];
                lee += piles[right];
            } else {
                alex += piles[right];
                lee += piles[left];
            }
            left++;
            right--;
        }
        return alex > lee;
    }

    /**
     * 动态规划
     * 动态转移方程为
     * 当 i == j 时
     * dp[i][j] = p[i]
     * 当 i < j 时
     * dp[i][j] = Max(p[i] - dp[i+1][j],p[j] - dp[i][j-1])
     */
    public boolean stoneGame2(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == j) {
                    dp[i][j] = piles[i];
                }
                if (i > j) {
                    dp[i][j] = 0;
                }
                if (i < j) {
                    dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1] > 0;
    }
}
