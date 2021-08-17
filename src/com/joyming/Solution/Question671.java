package com.joyming.Solution;

import com.joyming.Data.TreeNode;

import java.util.*;

/**
 * 671.二叉树中第二小的节点(Easy)
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。
 * <p>
 * 如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 * <p>
 * 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
 * <p>
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 * <p>
 * <p>
 * 示例 1：
 * 输入：root = [2,2,5,null,null,5,7]
 * 输出：5
 * 解释：最小的值是 2 ，第二小的值是 5 。
 * <p>
 * 示例 2：
 * 输入：root = [2,2,2]
 * 输出：-1
 * 解释：最小的值是 2, 但是不存在第二小的值。
 * <p>
 * <p>
 * 提示：
 * 树中节点数目在范围 [1, 25] 内
 * 1 <= Node.val <= 231 - 1
 * 对于树中每个节点 root.val == min(root.left.val, root.right.val)
 */
public class Question671 {

    List<Integer> list = new ArrayList<>();

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);

        //排序,找出第二小的值
        Collections.sort(list);

        if (list.size() >= 2) {
            return list.get(1);
        } else {
            return -1;
        }
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (!list.contains(root.val)) {
            list.add(root.val);
        }
        dfs(root.left);
        dfs(root.right);
    }
}
