package com.joyming.Solution;

import java.util.*;

/**
 * 1489. 找到最小生成树里的关键边和伪关键边
 * 给你一个 n 个点的带权无向连通图，节点编号为 0 到 n-1 ，同时还有一个数组 edges ，
 * 其中 edges[i] = [fromi, toi, weighti] 表示在 fromi 和 toi 节点之间有一条带权无向边。
 * 最小生成树 (MST) 是给定图中边的一个子集，它连接了所有节点且没有环，而且这些边的权值和最小。
 * <p>
 * 请你找到给定图中最小生成树的所有关键边和伪关键边。如果从图中删去某条边，会导致最小生成树的权值和增加，
 * 那么我们就说它是一条关键边。伪关键边则是可能会出现在某些最小生成树中但不会出现在所有最小生成树中的边。
 * <p>
 * 请注意，你可以分别以任意顺序返回关键边的下标和伪关键边的下标。
 * <p>
 * <p>
 * 示例 1：
 * 输入：n = 5, edges = [[0,1,1],[1,2,1],[2,3,2],[0,3,2],[0,4,3],[3,4,3],[1,4,6]]
 * 输出：[[0,1],[2,3,4,5]]
 * 解释：上图描述了给定图。
 * 下图是所有的最小生成树。
 * <p>
 * 注意到第 0 条边和第 1 条边出现在了所有最小生成树中，所以它们是关键边，我们将这两个下标作为输出的第一个列表。
 * 边 2，3，4 和 5 是所有 MST 的剩余边，所以它们是伪关键边。我们将它们作为输出的第二个列表。
 * <p>
 * 示例 2 ：
 * 输入：n = 4, edges = [[0,1,1],[1,2,1],[2,3,1],[0,3,1]]
 * 输出：[[],[0,1,2,3]]
 * 解释：可以观察到 4 条边都有相同的权值，任选它们中的 3 条可以形成一棵 MST 。所以 4 条边都是伪关键边。
 * <p>
 * <p>
 * 提示：
 * 2 <= n <= 100
 * 1 <= edges.length <= min(200, n * (n - 1) / 2)
 * edges[i].length == 3
 * 0 <= fromi < toi < n
 * 1 <= weighti <= 1000
 * 所有 (fromi, toi) 数对都是互不相同的。
 */
public class Question1489 {

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        //所有边的个数
        int edgeTotalSize = edges.length;
        int[][] newEdges = new int[edgeTotalSize][4];
        for (int i = 0; i < edgeTotalSize; ++i) {
            for (int j = 0; j < 3; ++j) {
                newEdges[i][j] = edges[i][j];
            }
            newEdges[i][3] = i;
        }
        Arrays.sort(newEdges, new Comparator<int[]>() {
            public int compare(int[] u, int[] v) {
                return u[2] - v[2];
            }
        });

        //根据并查集来合并
        UnionFind unionFind = new UnionFind(n);
        //最小权重和
        int minWeight = 0;
        for (int i = 0; i< edgeTotalSize; i++) {
            if (unionFind.union(newEdges[i][0], newEdges[i][1])) {
                minWeight += newEdges[i][2];
            }
        }

        List<List<Integer>> answer = new ArrayList<>();
        answer.add(0, new ArrayList<>());
        answer.add(1, new ArrayList<>());

        for (int i = 0; i < edgeTotalSize; i++) {

            //关键边：如果最小生成树中删去某条边，会导致最小生成树的权值和增加，那么我们就说它是一条关键边。
            // 也就是说，如果设原图最小生成树的权值为 value，那么去掉这条边后：
            // 要么整个图不连通，不存在最小生成树；
            // 要么整个图联通，对应的最小生成树的权值为 v，其严格大于 value。

            UnionFind unionFindSet = new UnionFind(n);
            int value = 0;
            for (int j = 0; j < edgeTotalSize; j++) {
                if (i != j && unionFindSet.union(newEdges[j][0], newEdges[j][1])) {
                    //没有形成环
                    value += newEdges[j][2];
                }
            }

            if (unionFindSet.getCount() != 1 ||
                    (value > minWeight && unionFindSet.getCount() == 1) ) {
                //这条边是关键边
                answer.get(0).add(newEdges[i][3]);
                continue;
            }

            //伪关键边：可能会出现在某些最小生成树中但不会出现在所有最小生成树中的边。
            // 也就是说，我们可以在计算最小生成树的过程中，最先考虑这条边，
            // 即最先将这条边的两个端点在并查集中合并。
            // 设最终得到的最小生成树权值为 v，如果 v=value，那么这条边就是伪关键边。

            UnionFind unionFindSetFake = new UnionFind(n);
            unionFindSetFake.union(newEdges[i][0], newEdges[i][1]);
            int value2 = newEdges[i][2];
            for (int j = 0; j < edgeTotalSize; j++) {
                if (i != j && unionFindSetFake.union(newEdges[j][0], newEdges[j][1])) {
                    //没有形成环
                    value2 += newEdges[j][2];
                }
            }
            if (value2 == minWeight) {
                //这条边是伪关键边
                answer.get(1).add(newEdges[i][3]);
            }
        }
        return answer;
    }

    private class UnionFind {

        int[] parent;

        int count;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public boolean union(int x, int y) {
            x = find(x);
            y = find(y);
            if (x == y) {
                return false;
            }
            parent[y] = x;
            --count;
            return true;
        }

        private int find(int x) {
            return parent[x] == x ? x : (parent[x] = find(parent[x]));
        }

        public int getCount() {
            return count;
        }
    }

}



