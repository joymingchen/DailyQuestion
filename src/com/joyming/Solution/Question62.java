package com.joyming.Solution;

import java.util.Arrays;

/**
 * 62. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 * <p>
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 * <p>
 * 示例 1:
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * <p>
 * 示例 2:
 * 输入: m = 7, n = 3
 * 输出: 28
 * <p>
 * 提示：
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 10 ^ 9
 */
public class Question62 {

    public int uniquePaths(int m, int n) {
        int answer = 0;
        answer = findWay(0, 0, m, n, answer);
        return answer;
    }

    /**
     * DPS
     * 回溯算法走出所有的路径
     */
    private int findWay(int x, int y, int m, int n, int answer) {
        if (x == m - 1 && y == n - 1) {
            return ++answer;
        }
        if (x == m - 1) {
            return findWay(x, y + 1, m, n, answer);
        }
        if (y == n - 1) {
            return findWay(x + 1, y, m, n, answer);
        }
        if (x < m && y < n) {
            for (int i = 0; i < 2; i++) {
                if (i == 0) {
                    //向左走
                    answer = findWay(x + 1, y, m, n, answer);
                } else {
                    //向下走
                    answer = findWay(x, y + 1, m, n, answer);
                }
            }
        }
        return answer;
    }

    /**
     * 动态规划算法
     * 列出动态规划方程
     * df[i,j] = df[i-1,j]+df[i,j-1]
     */
    public int uniquePaths2(int m, int n) {
        int[][] matrix = new int[m][n];
        //第一行第一列全为1
        Arrays.fill(matrix[0], 1);
        for (int i = 0; i < m; i++) {
            matrix[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
            }
        }
        return matrix[m - 1][n - 1];
    }
}
