package com.joyming.Solution;

import java.util.*;

/**
 * 1631. 最小体力消耗路径
 * 你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，
 * 其中 heights[row][col] 表示格子 (row, col) 的高度。一开始你在最左上角的格子 (0, 0) ，
 * 且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。
 * 你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
 * <p>
 * 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
 * <p>
 * 请你返回从左上角走到右下角的最小 体力消耗值 。
 * <p>
 * 示例 1：
 * 输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
 * 输出：2
 * 解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
 * 这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
 * <p>
 * 示例 2：
 * 输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
 * 输出：1
 * 解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
 * <p>
 * 示例 3：
 * 输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
 * 输出：0
 * 解释：上图所示路径不需要消耗任何体力。
 * <p>
 * <p>
 * 提示：
 * rows == heights.length
 * columns == heights[i].length
 * 1 <= rows, columns <= 100
 * 1 <= heights[i][j] <= 106
 */
public class Question1631 {

    private int[][] directions = {{1, -1, 0, 0}, {0, 0, 1, -1}}; //上下左右四个方向的坐标变化

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] visited = new boolean[n][m];
        List<Integer> resultList = new ArrayList<>();
        dfs(0, 0, heights, visited, 0, resultList);
        Collections.sort(resultList);
        return resultList.size() > 0 ? resultList.get(0) : 0;
    }

    /**
     * 深度优先搜索
     * 超时
     */
    public void dfs(int x, int y, int[][] heights, boolean[][] visited, int way,
                    List<Integer> resultList) {
        int n = heights.length;
        int m = heights[0].length;

        if (x < 0 || y < 0 || x >= n || y >= m) {
            return;
        }

        visited[x][y] = true;

        boolean[][] isVisit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                isVisit[i][j] = visited[i][j];
            }
        }

        for (int i = 0; i < 4; i++) {  //对于当前坐标点(x,y)，再对它的四个方向进行遍历
            int xx = x + directions[0][i];
            int yy = y + directions[1][i];
            if (xx >= 0 && xx < heights.length && yy >= 0 && yy < m
                    && !isVisit[xx][yy]) {
                isVisit[xx][yy] = true;
                int rightDiff = Math.abs(heights[xx][yy] - heights[x][y]);
                int way1 = way;
                way1 = Math.max(way1, rightDiff);

                if (xx == n - 1 && yy == m - 1) {
                    resultList.add(way1);
                }

                dfs(xx, yy, heights, isVisit, way1, resultList);
            }
        }
    }

    /**
     * Dijkstra算法的基本思想是：每次找到离源点（上面例子的源点就是 1 号顶点）最近的一个顶点，
     * 然后以该顶点为中心进行扩展，最终得到源点到其余所有点的最短路径。
     */
    public int dijkstra(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[] visited = new boolean[n * m];
        int[] grid = new int[n * m];
        Arrays.fill(grid, Integer.MAX_VALUE);
        grid[0] = 0;


        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        queue.offer(new int[]{0, 0, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1], d = current[2];
            int id = x * n + y;
            if (visited[id]) {
                continue;
            }
            if (id == m * n - 1) {
                break;
            }

            visited[id] = true;
            //对四个方向进行扫描
            for (int i = 0; i < 4; i++) {
                int xx = x + directions[0][i];
                int yy = y + directions[1][i];

                if (0 <= xx && xx < m && 0 <= yy && yy < n) {
                    int newID = xx * n + yy;
                    int dis = Math.abs(heights[x][y] - heights[xx][yy]);
                    int maxDis = Math.max(dis, d);
                    if (maxDis < grid[newID]) {
                        grid[newID] = maxDis;
                        queue.offer(new int[]{xx, yy, maxDis});
                    }
                }
            }
        }
        return grid[m * n - 1];
    }

    /**
     * 类似kruskal最小生成树
     * 这题并查集思路是按照边权从小到大建图直到坐上右下点联通，
     * 因此都是优先加权重低的边。这道题不是构造一棵树，但kruskal是构造总权重最低的生成树
     * 利用并查集来判断连通性
     *
     */
    public int minimumEffortPath2(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<Edge> edgeList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int id = i * n + j;

                if (i > 0) {
                    edgeList.add(new Edge(id - n, id, Math.abs(heights[i][j] - heights[i - 1][j])));
                }
                if (j > 0) {
                    edgeList.add(new Edge(id - 1, id, Math.abs(heights[i][j] - heights[i][j - 1])));
                }
            }
        }

        edgeList.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.distance - o2.distance;
            }
        });

        UnionFind unionFind = new UnionFind(m * n);
        int answer = 0;
        for (Edge edge : edgeList) {
            unionFind.union(edge.from, edge.to);
            if (unionFind.isConnected(0, m * n - 1)) {
                answer = edge.distance;
                break;
            }
        }
        return answer;
    }

    private class UnionFind {
        int[] parent;
        int count;

        public UnionFind(int n) {
            parent = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int x, int y) {
            x = find(x);
            y = find(y);

            if (x != y) {
                parent[y] = x;
                count--;
            }
        }

        private int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }

    private class Edge {
        int from;
        int to;
        int distance;

        public Edge(int x, int y, int distance) {
            this.from = x;
            this.to = y;
            this.distance = distance;
        }
    }

}
