package com.joyming.Solution;

import java.util.Arrays;

/**
 * 1833.雪糕的最大数量(Medium)
 * 夏日炎炎，小男孩 Tony 想买一些雪糕消消暑。
 * <p>
 * 商店中新到 n 支雪糕，用长度为 n 的数组 costs 表示雪糕的定价，其中 costs[i] 表示第 i 支雪糕的现金价格。
 * Tony 一共有 coins 现金可以用于消费，他想要买尽可能多的雪糕。
 * 给你价格数组 costs 和现金量 coins ，请你计算并返回 Tony 用 coins 现金能够买到的雪糕的 最大数量 。
 * <p>
 * 注意：Tony 可以按任意顺序购买雪糕。
 * <p>
 * <p>
 * 示例 1：
 * 输入：costs = [1,3,2,4,1], coins = 7
 * 输出：4
 * 解释：Tony 可以买下标为 0、1、2、4 的雪糕，总价为 1 + 3 + 2 + 1 = 7
 * <p>
 * 示例 2：
 * 输入：costs = [10,6,8,7,7,8], coins = 5
 * 输出：0
 * 解释：Tony 没有足够的钱买任何一支雪糕。
 * <p>
 * 示例 3：
 * 输入：costs = [1,6,3,1,2,5], coins = 20
 * 输出：6
 * 解释：Tony 可以买下所有的雪糕，总价为 1 + 6 + 3 + 1 + 2 + 5 = 18 。
 * <p>
 * <p>
 * 提示：
 * costs.length == n
 * 1 <= n <= 10^5
 * 1 <= costs[i] <= 10^5
 * 1 <= coins <= 10^8
 */
public class Question1833 {

    /**
     * 排序 + 贪心算法
     */
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int sum = 0;
        int num = 0;
        for (int cost : costs) {
            sum += cost;
            if (sum > coins) {
                break;
            }
            num++;
        }
        return num;
    }

    /**
     * 因为数组长度是有限的
     * costs.length == n
     * 1 <= n <= 10^5
     * 计数排序
     */
    public int maxIceCream2(int[] costs, int coins) {
        //防止溢出
        int[] index = new int[100001];
        for (int j : costs) {
            index[j]++;
        }

        int num = 0;
        for (int i = 1; i <= 100000; i++) {
            if (coins >= i) {
                int curCount = Math.min(index[i], coins / i);
                num += curCount;
                coins -= (i * curCount);
            } else {
                break;
            }
        }
        return num;
    }
}
