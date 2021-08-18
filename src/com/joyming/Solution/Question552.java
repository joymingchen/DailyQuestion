package com.joyming.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 552.学生出勤记录 II (Hard)
 * 可以用字符串表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
 * 'A'：Absent，缺勤
 * 'L'：Late，迟到
 * 'P'：Present，到场
 * 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
 * <p>
 * 按 总出勤 计，学生缺勤（'A'）严格 少于两天。
 * 学生 不会 存在 连续 3 天或 连续 3 天以上的迟到（'L'）记录。
 * 给你一个整数 n ，表示出勤记录的长度（次数）。请
 * 你返回记录长度为 n 时，可能获得出勤奖励的记录情况 数量 。
 * 答案可能很大，所以返回对 109 + 7 取余 的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：n = 2
 * 输出：8
 * 解释：
 * 有 8 种长度为 2 的记录将被视为可奖励：
 * "PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
 * 只有"AA"不会被视为可奖励，因为缺勤次数为 2 次（需要少于 2 次）。
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：3
 * <p>
 * 示例 3：
 * 输入：n = 10101
 * 输出：183236316
 * <p>
 * <p>
 * 提示：
 * 1 <= n <= 105
 */
public class Question552 {

    final int MOD = 1000000007;
    int answer = 0;

    /**
     * 动态规划
     * 状态转移方程太重要
     * i: 第几天
     * j: 缺席的次数
     * k: 连续迟到的次数
     */
    public int checkRecord(int n) {
        int[][][] dp = new int[n + 1][2][3];
        dp[0][0][0] = 1;
        for (int i = 1; i <= n; i++) {

            //今天到场
            //j = 0 : 没有缺席过的记录
//            dp[i][0][0] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) % MOD;
            //j = 1 : 有缺席过的记录
//            dp[i][1][0] = (dp[i - 1][1][0] + dp[i - 1][1][1] + dp[i - 1][1][2]) % MOD;
            for (int j = 0; j <= 1; j++) {
                for (int k = 0; k <= 2; k++) {
                    dp[i][j][0] = (dp[i][j][0] + dp[i - 1][j][k]) % MOD;
                }
            }

            //今天缺席
//            dp[i][1][0] = (dp[i][1][0] + dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) % MOD;
            for (int k = 0; k <= 2; k++) {
                dp[i][1][0] = (dp[i][1][0] + dp[i - 1][0][k]) % MOD;
            }

            //今天迟到
            //j = 0 : 没有缺席过的记录
//            dp[i][0][1] = (dp[i][0][1] + dp[i - 1][0][0]) % MOD;
//            dp[i][0][2] = (dp[i][0][2] + dp[i - 1][0][1]) % MOD;
//            //j = 1 : 有缺席过的记录
//            dp[i][1][1] = (dp[i][1][1] + dp[i - 1][1][0]) % MOD;
//            dp[i][1][2] = (dp[i][1][2] + dp[i - 1][1][1]) % MOD;
            for (int j = 0; j <= 1; j++) {
                for (int k = 1; k <= 2; k++) {
                    dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j][k - 1]) % MOD;
                }
            }
        }
        int sum = 0;
        for (int j = 0; j <= 1; j++) {
            for (int k = 0; k <= 2; k++) {
                sum = (sum + dp[n][j][k]) % MOD;
            }
        }
        return sum;
    }

    /**
     * 暴力dfs 超出时间限制
     */
    public int checkRecord2(int n) {
        ThreeNode node = new ThreeNode("");
        dfs(node, 0, n, "");
        return answer % MOD;
    }

    private void dfs(ThreeNode root, int index, int n, String currentStr) {
        String nextStr = currentStr + root.val;
        if (!checkStr(nextStr)) {
            return;
        }
        if (index >= n) {
            answer++;
            return;
        }
        if (root.left == null) {
            root.left = new ThreeNode("A");
        }
        if (root.center == null) {
            root.center = new ThreeNode("L");
        }
        if (root.right == null) {
            root.right = new ThreeNode("P");
        }
        int nextIndex = index + 1;
        dfs(root.left, nextIndex, n, nextStr);
        dfs(root.center, nextIndex, n, nextStr);
        dfs(root.right, nextIndex, n, nextStr);
    }

    public boolean checkStr(String s) {
        return (s.indexOf('A') == s.lastIndexOf('A')) && (!s.contains("LLL"));
    }

    class ThreeNode {

        String val;
        ThreeNode left;
        ThreeNode center;
        ThreeNode right;

        public ThreeNode() {
        }

        public ThreeNode(String val) {
            this.val = val;
        }

        public ThreeNode(String val, ThreeNode left, ThreeNode center, ThreeNode right) {
            this.val = val;
            this.left = left;
            this.center = center;
            this.right = right;
        }
    }
}



