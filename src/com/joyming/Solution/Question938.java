package com.joyming.Solution;

import com.joyming.Data.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 938. 二叉搜索树的范围和
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 * <p>
 * <p>
 * 示例 1：
 * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
 * 输出：32
 * <p>
 * 示例 2：
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * 输出：23
 * <p>
 * <p>
 * 提示：
 * 树中节点数目在范围 [1, 2 * 104] 内
 * 1 <= Node.val <= 105
 * 1 <= low <= high <= 105
 * 所有 Node.val 互不相同
 */
public class Question938 {

    int answer = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return answer;
    }

    /**
     * 深度优先搜索
     * 注意变量的设置
     */
    private int dfs(TreeNode root, int low, int high) {
        if (root == null) {
            return answer;
        }
        int val = root.val;
        if (val >= low && val <= high) {
            answer += val;
        }
        return dfs(root.left, low, high) + dfs(root.right, low, high);
    }

    /**
     * 广度优先搜索
     * 利用队列
     */
    public int bfs(TreeNode root, int low, int high) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode == null) {
                continue;
            }
            queue.offer(treeNode.left);
            queue.offer(treeNode.right);

            if (treeNode.val >= low && treeNode.val <= high) {
                answer += treeNode.val;
            }
        }
        return answer;
    }

}
