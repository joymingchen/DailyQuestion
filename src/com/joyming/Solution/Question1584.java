package com.joyming.Solution;

import java.util.*;

/**
 * 1584. 连接所有点的最小费用
 * 给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。
 * <p>
 * 连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。
 * <p>
 * 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。
 * <p>
 * <p>
 * 示例 1：
 * 输入：points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * 输出：20
 * 解释：
 * <p>
 * 我们可以按照上图所示连接所有点得到最小总费用，总费用为 20 。
 * 注意到任意两个点之间只有唯一一条路径互相到达。
 * 示例 2：
 * <p>
 * 输入：points = [[3,12],[-2,5],[-4,1]]
 * 输出：18
 * 示例 3：
 * <p>
 * 输入：points = [[0,0],[1,1],[1,0],[-1,1]]
 * 输出：4
 * 示例 4：
 * <p>
 * 输入：points = [[-1000000,-1000000],[1000000,1000000]]
 * 输出：4000000
 * 示例 5：
 * <p>
 * 输入：points = [[0,0]]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= points.length <= 1000
 * -106 <= xi, yi <= 106
 * 所有点 (xi, yi) 两两不同。
 */
public class Question1584 {

    /**
     * 并查集
     * 1.最小生成树 Kruskal算法
     * 2.并查集的作用是连通节点并判断当前加入的边是否会构成环路
     * <p>
     * 1.将所有边从小到大进行排序
     * 2.依次从最小的边开始添加
     * 2.1、添加当前边不能导致环
     * 2.2、添加了k-1条边时退出循环（k个结点的最小生成树有k-1条边）
     */
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int answer = 0;
        if (n <= 1) {
            return answer;
        }

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dis = manhattanDistance(points[i], points[j]);
                edges.add(new Edge(i, j, dis));
            }
        }
        //根据距离进行排序
        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.length - o2.length;
            }
        });

        UnionFind unionFind = new UnionFind(n);
        int num = 0;
        for (Edge edge : edges) {
            if (unionFind.union(edge.a, edge.b)) {
                answer += edge.length;
                num++;
            }
            if (num == n - 1) {
                break;
            }
        }
        return answer;
    }

    public int manhattanDistance(int[] point1, int[] point2) {
        return Math.abs(point2[0] - point1[0]) + Math.abs(point2[1] - point1[1]);
    }

    class UnionFind {
        /**
         * parent[i]表示第i个元素所指向的父节点
         */
        int[] parent;

        /**
         * size[i]表示第i个元素的子元素的数量
         */
        int[] size;

        /**
         * 按秩合并
         * rank[i]表示以i为根的集合所表示的树的层数
         */
        int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        /**
         * 合并
         */
        public boolean union(int a, int b) {
            int rootX = find(a);
            int rootY = find(b);
            //不能形成环
            if (rootX == rootY) {
                return false;
            }

            //层数少的指向层数多的
            if(rank[rootX] < rank[rootY]){
                parent[rootX] = rootY;
            }else if(rank[rootX] > rank[rootY]){
                parent[rootY] = rootX;
            }else {
                parent[rootY] = rootX;
                rank[rootX] += 1;
            }

//            // 根据两个元素所在树的元素个数不同判断合并方向
//            // 将元素个数少的集合合并到元素个数多的集合上
//            if(size[rootX] < size[rootY]){
//                parent[rootX] = rootY;
//                size[rootY] += size[rootX];
//            }else if(size[rootX] > size[rootY]){
//                parent[rootY] = rootX;
//                size[rootX] += size[rootY];
//            }else {
//                parent[rootY] = rootX;
//                size[rootX] += 1;
//            }

            return true;
        }

        /**
         * 寻找根结点
         * 路径压缩
         */
        private int find(int x) {
            if(parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }

    class Edge {
        int a;
        int b;
        int length;

        public Edge(int a, int b, int length) {
            this.a = a;
            this.b = b;
            this.length = length;
        }
    }

}
