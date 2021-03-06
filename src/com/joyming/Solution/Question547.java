package com.joyming.Solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 547. 省份数量
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，
 * 且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 * <p>
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * <p>
 * 给你一个 n x n 的矩阵 isConnected ，
 * 其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，
 * 而 isConnected[i][j] = 0 表示二者不直接相连。
 * <p>
 * 返回矩阵中 省份 的数量。
 * <p>
 * <p>
 * 示例 1：
 * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * 输出：2
 * <p>
 * <p>
 * 示例 2：
 * 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] 为 1 或 0
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 */
public class Question547 {

    /**
     * 利用并查集
     * 要注意合并
     */
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind unionFind = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    //合并
                    unionFind.union(i, j);
                }
            }
        }

        int circle = 0;
        for (int i = 0; i < n; i++) {
            if (unionFind.isInCircle(i)) {
                circle++;
            }
        }
        return circle;
    }

    /**
     * 并查集
     */
    class UnionFind {

        /**
         * 根结点的id
         */
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int x, int y) {
            parent[find(x)] = find(y);
        }

        /**
         * 查找根结点的id
         */
        private int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean isInCircle(int x) {
            return parent[x] == x;
        }
    }

    /**
     * 深度优先搜索
     * Depth First Search
     */
    public int findCircleNumDFS(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] isVisited = new boolean[n];
        int circle = 0;
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                circle++;
                dfs(isConnected, isVisited, i, n);
            }
        }
        return circle;
    }

    private void dfs(int[][] isConnected, boolean[] isVisited, int i, int n) {
        for (int j = 0; j < n; j++) {
            if (isConnected[i][j] == 1 && !isVisited[j]) {
                isVisited[j] = true;
                dfs(isConnected, isVisited, j, n);
            }
        }
    }

    /**
     * 广度优先搜索
     * Breadth First Search
     */
    public int findCircleNumBFS(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] isVisited = new boolean[n];
        int circle = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                circle++;
                queue.offer(i);
                isVisited[i] = true;

                while (!queue.isEmpty()) {
                    int v = queue.poll();
                    for (int w = 0; w < n; w++) {
                        if (!isVisited[w] && isConnected[v][w] == 1) {
                            isVisited[w] = true;
                            queue.offer(w);
                        }
                    }
                }
            }
        }
        return circle;
    }
}
