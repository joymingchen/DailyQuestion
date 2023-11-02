package com.joyming.Solution;

import com.joyming.Data.Node;

import java.util.*;

/**
 * 133. 克隆图
 * <p>
 * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 * <p>
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 * <p>
 * class Node {
 * public int val;
 * public List<Node> neighbors;
 * }
 * <p>
 * 测试用例格式：
 * <p>
 * 简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1（val = 1），第二个节点值为 2（val = 2），以此类推。该图在测试用例中使用邻接列表表示。
 * <p>
 * 邻接列表 是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。
 * <p>
 * 给定节点将始终是图中的第一个节点（值为 1）。你必须将 给定节点的拷贝 作为对克隆图的引用返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：adjList = [[2,4],[1,3],[2,4],[1,3]]
 * 输出：[[2,4],[1,3],[2,4],[1,3]]
 * 解释：
 * 图中有 4 个节点。
 * 节点 1 的值是 1，它有两个邻居：节点 2 和 4 。
 * 节点 2 的值是 2，它有两个邻居：节点 1 和 3 。
 * 节点 3 的值是 3，它有两个邻居：节点 2 和 4 。
 * 节点 4 的值是 4，它有两个邻居：节点 1 和 3 。
 * <p>
 * 示例 2：
 * 输入：adjList = [[]]
 * 输出：[[]]
 * 解释：输入包含一个空列表。该图仅仅只有一个值为 1 的节点，它没有任何邻居。
 * <p>
 * 示例 3：
 * 输入：adjList = []
 * 输出：[]
 * 解释：这个图是空的，它不含任何节点。
 * <p>
 * 示例 4：
 * 输入：adjList = [[2],[1]]
 * 输出：[[2],[1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 节点数不超过 100 。
 * 每个节点值 Node.val 都是唯一的，1 <= Node.val <= 100。
 * 无向图是一个简单图，这意味着图中没有重复的边，也没有自环。
 * 由于图是无向的，如果节点 p 是节点 q 的邻居，那么节点 q 也必须是节点 p 的邻居。
 * 图是连通图，你可以从给定节点访问到所有节点。
 */
public class Question133 {


    public Node cloneGraph2(Node node) {
        return clone(node, new HashMap<Integer, Node>());
    }

    /**
     * 利用dfs递归调用复制节点
     */
    private Node clone(Node node, HashMap<Integer, Node> visited) {
        if (node == null) {
            return null;
        }
        int val = node.val;
        if (visited.containsKey(val)) {
            //访问过的节点
            return visited.get(val);
        }
        //没有访问过的节点，直接创建
        Node newNode = new Node(val, new ArrayList<>());
        //保存访问过的节点
        visited.put(val, newNode);
        //复制子节点
        for (Node neighbors : node.neighbors) {
            newNode.neighbors.add(clone(neighbors, visited));
        }
        return newNode;
    }

    /**
     * 利用bfs调用生成
     */
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        Deque<Node> stack = new LinkedList<>();
        stack.push(node);

        Node newNode = new Node(node.val, new ArrayList<>());

        Map<Node, Node> visited = new HashMap<>();
        visited.put(node, newNode);
        while (!stack.isEmpty()) {
            Node cur = stack.poll();
            List<Node> neighbor = cur.neighbors;
            for (Node neigh : neighbor) {
                if (visited.containsKey(neigh)) {
                    visited.get(cur).neighbors.add(visited.get(neigh));
                } else {
                    Node neighCopy = new Node(neigh.val, new ArrayList<>());
                    visited.put(neigh, neighCopy);
                    visited.get(cur).neighbors.add(neighCopy);
                    stack.add(neigh);
                }
            }
        }
        return newNode;
    }
}
