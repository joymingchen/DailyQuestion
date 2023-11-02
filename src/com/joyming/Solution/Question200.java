package com.joyming.Solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 200. 岛屿数量
 * <p>
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * <p>
 * 示例 1：
 * 输入：grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * 输出：1
 * <p>
 * 示例 2：
 * 输入：grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 */
public class Question200 {

    public int numIslands(char[][] grid) {
        int answer = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    answer++;
//                    dfs(grid, i, j);
                    bfs(grid, i, j);
                }
            }
        }
        return answer;
    }

    /**
     * dfs (depth first search) 深度优先搜索
     */
    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    /**
     * bfs（breadth first search） 广度优先搜素
     */
    private void bfs(char[][] grid, int x, int y) {
        //先把当前位置置0
        grid[x][y] = '0';
        int m = grid.length;
        int n = grid[0].length;

        //转化坐标  0 * 4  + 1
        int cur = x * n + y;

        Queue<Integer> stack = new LinkedList<>();
        stack.add(cur);

        while (!stack.isEmpty()) {
            int p = stack.poll();

            int i = p / n;
            int j = p % n;

            //上边
            if (i > 0 && grid[i - 1][j] == '1') {
                grid[i - 1][j] = 0;
                stack.add((i - 1) * n + j);
            }

            //下
            if (i < m - 1 && grid[i + 1][j] == '1') {
                grid[i + 1][j] = 0;
                stack.add((i + 1) * n + j);
            }

            //左
            if (j > 0 && grid[i][j - 1] == '1') {
                grid[i][j - 1] = '0';
                stack.add(i * n + j - 1);
            }

            //右
            if (j < n - 1 && grid[i][j + 1] == '1') {
                grid[i][j + 1] = '0';
                stack.add(i * n + j + 1);
            }
        }
    }


}
