package com.joyming.Solution;

import com.joyming.data.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 103. 二叉树的锯齿形层序遍历
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层序遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class Question103 {

    /**
     * 递归
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answerList = new ArrayList<>();
        if (root == null) {
            return answerList;
        }
        DFS(root, 0, answerList);
        return answerList;
    }

    /**
     * 深度优先搜索
     * Depth First Search
     */
    public void DFS(TreeNode treeNode, int level, List<List<Integer>> result) {
        if (level == result.size()) {
            List<Integer> newLevel = new ArrayList<>();
            newLevel.add(treeNode.val);
            result.add(newLevel);
        } else {
            if (level % 2 == 0) {
                //偶数层级
                result.get(level).add(treeNode.val);
            } else {
                //奇数层级
                result.get(level).add(0, treeNode.val);
            }
        }
        if (treeNode.left != null) {
            DFS(treeNode.left, level + 1, result);
        }
        if (treeNode.right != null) {
            DFS(treeNode.right, level + 1, result);
        }
    }

    /**
     * 迭代
     * 用队列来表示每一层，每一层结尾为null
     */
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> answerList = new ArrayList<>();
        if (root == null) {
            return answerList;
        }

        LinkedList<TreeNode> nodeQueue = new LinkedList<>();
        //构造第一层
        nodeQueue.addLast(root);
        nodeQueue.addLast(null);

        boolean isOrderFirst = true;
        //每一层的list
        List<Integer> levelList = new ArrayList<>();

        while (nodeQueue.size() > 0) {
            TreeNode treeNode = nodeQueue.pollFirst();
            if (treeNode != null) {
                if (isOrderFirst) {
                    levelList.add(treeNode.val);
                } else {
                    levelList.add(0, treeNode.val);
                }

                if (treeNode.left != null) {
                    nodeQueue.addLast(treeNode.left);
                }
                if (treeNode.right != null) {
                    nodeQueue.addLast(treeNode.right);
                }
            } else {
                //层级结束
                answerList.add(levelList);
                levelList = new ArrayList<>();

                if (nodeQueue.size() > 0) {
                    nodeQueue.addLast(null);
                }
                isOrderFirst = !isOrderFirst;
            }
        }
        return answerList;
    }

}
