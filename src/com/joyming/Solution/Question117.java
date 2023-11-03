package com.joyming.Solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个二叉树：
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL 。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next 指针连接），'#' 表示每层的末尾。
 * <p>
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * 树中的节点数在范围 [0, 6000] 内
 * -100 <= Node.val <= 100
 * 进阶：
 * <p>
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序的隐式栈空间不计入额外空间复杂度。
 */
public class Question117 {

    public void test() {
        Node root = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node seven = new Node(7);

        three.right = seven;
        two.left = four;
        two.right = five;
        root.left = two;
        root.right = three;

        connect(root);
    }


    //bfs
    public Node connect2(Node root) {

        Queue<Node> stack = new LinkedList<>();
        stack.add(root);

        Queue<Node> level = new LinkedList<>();

        while (!stack.isEmpty()) {
            level.add(stack.poll());

            if (stack.isEmpty()) {
                while (!level.isEmpty()) {

                    Node cur = level.poll();
                    Node next = level.peek();

                    if (cur == null) {
                        break;
                    }

                    cur.next = next;

                    Node left = cur.left;
                    Node right = cur.right;

                    if (left != null) {
                        stack.add(left);
                    }
                    if (right != null) {
                        stack.add(right);
                    }
                }
            }
        }
        return root;
    }

    public Node connect(Node root) {

        Queue<Node> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            //每一层的数量
            int levelCount = stack.size();

            Node pre = null;
            for (int i = 0; i < levelCount; i++) {
                Node cur = stack.poll();

                if (pre != null) {
                    pre.next = cur;
                }
                //然后再让当前节点成为前一个节点
                pre = cur;

                if (cur != null) {
                    Node left = cur.left;
                    Node right = cur.right;

                    if (left != null) {
                        stack.add(left);
                    }
                    if (right != null) {
                        stack.add(right);
                    }
                }
            }
        }
        return root;
    }


    // Definition for a Node.
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

}
