package com.joyming.Solution;

import java.util.Arrays;

/**
 * 1465. 切割后面积最大的蛋糕
 * <p>
 * 矩形蛋糕的高度为 h 且宽度为 w，给你两个整数数组 horizontalCuts 和 verticalCuts，其中：
 * <p>
 * horizontalCuts[i] 是从矩形蛋糕顶部到第  i 个水平切口的距离
 * verticalCuts[j] 是从矩形蛋糕的左侧到第 j 个竖直切口的距离
 * 请你按数组 horizontalCuts 和 verticalCuts 中提供的水平和竖直位置切割后，请你找出 面积最大 的那份蛋糕，并返回其 面积 。由于答案可能是一个很大的数字，因此需要将结果 对 109 + 7 取余 后返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：h = 5, w = 4, horizontalCuts = [1,2,4], verticalCuts = [1,3]
 * 输出：4
 * 解释：上图所示的矩阵蛋糕中，红色线表示水平和竖直方向上的切口。切割蛋糕后，绿色的那份蛋糕面积最大。
 * <p>
 * 示例 2：
 * 输入：h = 5, w = 4, horizontalCuts = [3,1], verticalCuts = [1]
 * 输出：6
 * 解释：上图所示的矩阵蛋糕中，红色线表示水平和竖直方向上的切口。切割蛋糕后，绿色和黄色的两份蛋糕面积最大。
 * <p>
 * 示例 3：
 * 输入：h = 5, w = 4, horizontalCuts = [3], verticalCuts = [3]
 * 输出：9
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= h, w <= 109
 * 1 <= horizontalCuts.length <= min(h - 1, 105)
 * 1 <= verticalCuts.length <= min(w - 1, 105)
 * 1 <= horizontalCuts[i] < h
 * 1 <= verticalCuts[i] < w
 * 题目数据保证 horizontalCuts 中的所有元素各不相同
 * 题目数据保证 verticalCuts 中的所有元素各不相同
 */
public class Question1465 {


    /**
     * 贪心
     */
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long answer = ((long) getMaxLine(horizontalCuts, h) * getMaxLine(verticalCuts, w)) % 1000000007;
        return (int) answer;
    }

    private int getMaxLine(int[] verticalCuts, int lineLength) {
        int previous = 0;
        int max = 0;
        for (int i : verticalCuts) {
            max = Math.max(max, i - previous);
            previous = i;
        }
        return Math.max(max, lineLength - previous);
    }

    /**
     * dfs 深度优先搜索
     * 但是会超出内存限制
     */
    public int maxArea2(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int[][] map = new int[h][w];
        for (int i = 0; i < h; i++) {
            Arrays.fill(map[i], 0);
        }

        int max = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                dfs(map, i, j, findPassLine(horizontalCuts, i, h), findPassLine(verticalCuts, j, w), 0);
                max = Math.max(max, map[i][j]);
            }
        }

        return max;
    }

    private void dfs(int[][] map, int i, int j, int[] horizontal, int[] vertical, int sum) {
        if (i < 0 || i >= map.length || j < 0 || j >= map[0].length || isPassLine(horizontal, i) || isPassLine(vertical, j)) {
            return;
        }


        if (map[i][j] != 0) {
            return;
        }

        sum++;
        if (map[i][j] == 0) {
            map[i][j] = sum;
        }


        dfs(map, i + 1, j, horizontal, vertical, sum);
        dfs(map, i - 1, j, horizontal, vertical, sum);
        dfs(map, i, j + 1, horizontal, vertical, sum);
        dfs(map, i, j - 1, horizontal, vertical, sum);
    }

    private boolean isPassLine(int[] ints, int i) {
        int left = ints[0];
        int right = ints[1];
        return left > i || i >= right;
    }


    private int[] findPassLine(int[] horizontalCuts, int point, int length) {
        int left = 0;
        int right = length;
        for (int j = 0; j < horizontalCuts.length; j++) {
            if (horizontalCuts[j] > point) {
                right = Math.min(right, horizontalCuts[j]);
            } else {
                left = Math.max(left, horizontalCuts[j]);
            }
        }
        return new int[]{left, right};
    }

}
