package com.joyming.Solution;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 2258. 逃离火灾
 * <p>
 * 给你一个下标从 0 开始大小为 m x n 的二维整数数组 grid ，它表示一个网格图。每个格子为下面 3 个值之一：
 * <p>
 * 0 表示草地。
 * 1 表示着火的格子。
 * 2 表示一座墙，你跟火都不能通过这个格子。
 * 一开始你在最左上角的格子 (0, 0) ，你想要到达最右下角的安全屋格子 (m - 1, n - 1) 。每一分钟，你可以移动到 相邻 的草地格子。每次你移动 之后 ，着火的格子会扩散到所有不是墙的 相邻 格子。
 * <p>
 * 请你返回你在初始位置可以停留的 最多 分钟数，且停留完这段时间后你还能安全到达安全屋。如果无法实现，请你返回 -1 。如果不管你在初始位置停留多久，你 总是 能到达安全屋，请你返回 109 。
 * <p>
 * 注意，如果你到达安全屋后，火马上到了安全屋，这视为你能够安全到达安全屋。
 * <p>
 * 如果两个格子有共同边，那么它们为 相邻 格子。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：grid = [[0,2,0,0,0,0,0],[0,0,0,2,2,1,0],[0,2,0,0,1,2,0],[0,0,2,2,2,0,2],[0,0,0,0,0,0,0]]
 * 输出：3
 * 解释：上图展示了你在初始位置停留 3 分钟后的情形。
 * 你仍然可以安全到达安全屋。
 * 停留超过 3 分钟会让你无法安全到达安全屋。
 * <p>
 * 示例 2：
 * 输入：grid = [[0,0,0,0],[0,1,2,0],[0,2,0,0]]
 * 输出：-1
 * 解释：上图展示了你马上开始朝安全屋移动的情形。
 * 火会蔓延到你可以移动的所有格子，所以无法安全到达安全屋。
 * 所以返回 -1 。
 * <p>
 * 示例 3：
 * 输入：grid = [[0,0,0],[2,2,0],[1,2,0]]
 * 输出：1000000000
 * 解释：上图展示了初始网格图。
 * 注意，由于火被墙围了起来，所以无论如何你都能安全到达安全屋。
 * 所以返回 109 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 2 <= m, n <= 300
 * 4 <= m * n <= 2 * 104
 * grid[i][j] 是 0 ，1 或者 2 。
 * grid[0][0] == grid[m - 1][n - 1] == 0
 */
public class Question2258 {

    int m, n;

    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};


    int[][] g;
    int[][] fireGrid;
    int[][] peopleGrid;

    boolean isSave = false;

    /**
     * 二分 + bfs
     */
    public int maximumMinutes(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        g = grid;

        fireGrid = new int[m][n];
        peopleGrid = new int[m][n];

        //立马出发 是否能够到达终点
        if (!check(0)) return -1;

        //可以在 0 ~ t 秒后逃跑 ， t的取值范围在 0 ~ （m + n）内
        //利用二分法进行查找
        int left = 0, right = m * n;

        //假设t秒后，能否逃出
        while (left < right) {
            int t = (left + right + 1) / 2;
            if (check(t)) {
                //t秒之后可以逃出
                left = t;
            } else {
                right = t - 1;
            }
        }
        return right == m * n ? (int) 1e9:right;
    }

    /**
     * t秒之后是否可以逃出
     */
    private boolean check(int t) {
        isSave = false;

        Deque<int[]> fireStack = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                peopleGrid[i][j] = fireGrid[i][j] = 0;
                if (g[i][j] == 1) {
                    //火焰
                    fireGrid[i][j] = 1;
                    fireStack.addLast(new int[]{i, j});
                }
            }
        }

        //火苗 蔓延 t秒以后
        for (int i = 0; i < t; i++) {
            bfsFire(fireStack, true, 0);
        }

        //火已经烧到起点
        if (fireGrid[0][0] == 1) {
            return false;
        }

        //开始执行人的逃跑路线
        Deque<int[]> peopleStack = new ArrayDeque<>();
        peopleGrid[0][0] = 1;
        peopleStack.addLast(new int[]{0, 0});
        while (!peopleStack.isEmpty()) {
            //先火后人
            bfsFire(fireStack, true, 1);
            bfsFire(peopleStack, false, 1);
            if (isSave) return true;
        }
        return false;
    }


    private void bfsFire(Deque<int[]> stack, boolean isFire, int offset) {

        int size = stack.size();
        while (size-- > 0) {
            int[] cur = stack.pollFirst();
            int x = cur[0];
            int y = cur[1];

            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;//超出边界
                if (g[nx][ny] == 2) continue;//遇到墙

                if (isFire) {
                    if (fireGrid[nx][ny] != 0) continue;
                    fireGrid[nx][ny] = fireGrid[x][y] + offset;
                } else {
                    if (nx == m - 1 && ny == n - 1) {
                        if (fireGrid[nx][ny] == 0 || fireGrid[nx][ny] == peopleGrid[x][y] + offset) {
                            // 火尚未到达终点 或 同时到达终点
                            isSave = true;
                        }
                    }
                    if (fireGrid[nx][ny] != 0 || peopleGrid[nx][ny] != 0) continue;
                    peopleGrid[nx][ny] = peopleGrid[x][y] + offset;
                }

                stack.addLast(new int[]{nx, ny});
            }
        }
    }

}
