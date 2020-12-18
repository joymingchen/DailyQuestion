package com.joyming.Solution;

import java.util.Arrays;

/**
 * 714. 买卖股票的最佳时机含手续费
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * 返回获得利润的最大值。
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 * <p>
 * 示例 1:
 * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出: 8
 * 解释: 能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * 注意:
 * 0 < prices.length <= 50000.
 * 0 < prices[i] < 50000.
 * 0 <= fee < 50000.
 */
public class Question714 {

    /**
     * 动态规划
     * 分析每一天持有和不持有的所得利润
     * 时间复杂度和空间复杂度都是O(n);
     */
    public int maxProfit(int[] prices, int fee) {
        int length = prices.length;
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[length - 1][0];
    }

    /**
     * 动态规划优化空间算法
     * 第i天的利润都是由第i -1 天得到，优化数组
     * 空间复杂度都是O(1);
     */
    public int maxProfit2(int[] prices, int fee) {
        int length = prices.length;
        int[] dp = new int[2];
        dp[1] = -prices[0];
        for (int i = 1; i < length; i++) {
            int temp = dp[0];
            dp[0] = Math.max(dp[0], dp[1] + prices[i] - fee);
            dp[1] = Math.max(dp[1], temp - prices[i]);
        }
        return dp[0];
    }

    /**
     * 贪心算法
     * 手续费可以加在买入成本上
     * buy 表示当前的买入价格
     */
    public int maxProfit3(int[] prices, int fee) {
        int buy = prices[0] + fee;
        int profit = 0;
        for (int price : prices) {
            if (buy > price + fee) {
                buy = price + fee;
            } else if (buy < price) {
                //当前卖出价格 - 购入成本
                profit += price - buy;
                buy = price;
            }
        }
        return profit;
    }

}
