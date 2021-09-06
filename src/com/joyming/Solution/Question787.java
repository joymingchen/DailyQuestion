package com.joyming.Solution;

import java.util.*;

/**
 * 787.K 站中转内最便宜的航班(Medium)
 * 有 n 个城市通过一些航班连接。给你一个数组 flights ，
 * 其中 flights[i] = [fromi, toi, pricei] ，
 * 表示该航班都从城市 fromi 开始，以价格 pricei 抵达 toi。
 * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，
 * 你的任务是找到出一条最多经过 k 站中转的路线，
 * 使得从 src 到 dst 的 价格最便宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。
 * <p>
 * <p>
 * 示例 1：
 * 输入:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * 输出: 200
 * 解释:
 * 城市航班图如下
 * 从城市 0 到城市 2 在 1 站中转以内的最便宜价格是 200，如图中红色所示。
 * <p>
 * <p>
 * 示例 2：
 * 输入:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 0
 * 输出: 500
 * 解释:
 * 城市航班图如下
 * 从城市 0 到城市 2 在 0 站中转以内的最便宜价格是 500，如图中蓝色所示。
 * <p>
 * <p>
 * 提示：
 * 1 <= n <= 100
 * 0 <= flights.length <= (n * (n - 1) / 2)
 * flights[i].length == 3
 * 0 <= fromi, toi < n
 * fromi != toi
 * 1 <= pricei <= 104
 * 航班没有重复，且不存在自环
 * 0 <= src, dst, k < n
 * src != dst
 */
public class Question787 {

    /**
     * Breadth First Search
     * 广度优先搜索
     * 超出时间限制
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //1、首先构建图
        //构建图 u->v w
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] f : flights) {
            graph.putIfAbsent(f[0], new ArrayList<>());
            graph.get(f[0]).add(new int[]{f[1], f[2]});
        }

        //2、创建队列
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0});
        int answer = Integer.MAX_VALUE;//最短路径花费
        int level = 0;//层级
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int currNext = current[0], currCost = current[1];

                //找到目的地
                if (currNext == dst) {
                    answer = Math.min(currCost, answer);
                }

                if (graph.containsKey(currNext)) {
                    for (int[] next : graph.get(currNext)) {
                        if (next[1] + currCost > answer) {
                            continue;
                        }
                        queue.offer(new int[]{next[0], next[1] + currCost});
                    }
                }

            }

            //先比较level 与K 再执行++ 的，bfs的层数，类似水波纹的一圈一圈的，一层表示经过一个站
            if (level++ > k) {
                break;
            }
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public int findCheapestPrice2(int N, int[][] flights, int src, int dst, int K) {
        //构建图 u->v w
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] f : flights) {
            graph.putIfAbsent(f[0], new ArrayList<>());
            graph.get(f[0]).add(new int[]{f[1], f[2]});
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0});//0 表示当前点，1表示的是到达当前点的距离dist
        int ans = Integer.MAX_VALUE;
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int u = curr[0], dist = curr[1];
                if (u == dst) ans = Math.min(ans, dist);//找到目的地站
                if (graph.containsKey(u)) {
                    for (int[] next : graph.get(u)) {
                        if (dist + next[1] > ans) continue;//松弛
                        q.offer(new int[]{next[0], dist + next[1]});
                    }
                }
            }
            //先比较level 与K 再执行++ 的，bfs的层数，类似水波纹的一圈一圈的，一层表示经过一个站
            if (level++ > K) break;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
