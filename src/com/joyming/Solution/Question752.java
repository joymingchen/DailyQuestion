package com.joyming.Solution;

import com.joyming.Data.TreeNode;

import java.util.*;

/**
 * 752.打开转盘锁(Medium)
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * <p>
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * <p>
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * <p>
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 * <p>
 * <p>
 * 示例 1:
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 * <p>
 * 示例 2:
 * 输入: deadends = ["8888"], target = "0009"
 * 输出：1
 * 解释：
 * 把最后一位反向旋转一次即可 "0000" -> "0009"。
 * <p>
 * 示例 3:
 * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * 输出：-1
 * 解释：
 * 无法旋转到目标数字且不被锁定。
 * <p>
 * 示例 4:
 * 输入: deadends = ["0000"], target = "8888"
 * 输出：-1
 * <p>
 * <p>
 * 提示：
 * 1 <= deadends.length <= 500
 * deadends[i].length == 4
 * target.length == 4
 * target 不在 deadends 之中
 * target 和 deadends[i] 仅由若干位数字组成
 */
public class Question752 {

    /**
     * 每一位都可以向上或向下滚动一下，四位密码就是一个八叉树
     * 利用广度优先算法（BFS）即可
     */
    public int openLock(String[] deadends, String target) {
        String pwdLock = "0000";
        int step = 0;
        //转换死亡数字
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        if (deads.contains(pwdLock)) {
            return -1;
        }

        //创建队列
        Queue<String> queue = new LinkedList<>();
        queue.add(pwdLock);

        //记录访问过的节点
        Set<String> visited = new HashSet<>();
        visited.add(pwdLock);


        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {
                String cur = queue.poll();

                for (int i = 0; i < cur.length(); i++) {

                    int curNumber = Integer.parseInt(cur.substring(i, i + 1));

                    if (cur.equals(target)) {
                        return step;
                    }

                    //向上滑动
                    int next = curNumber + 1 == 10 ? 0 : curNumber + 1;
                    String newStr = cur.substring(0, i) + next + cur.substring(i + 1);

                    //向下滑动
                    int next2 = curNumber - 1 == -1 ? 9 : curNumber - 1;
                    String newStr2 = cur.substring(0, i) + next2 + cur.substring(i + 1);


                    if (!visited.contains(newStr) && !deads.contains(newStr)) {
                        queue.add(newStr);
                        visited.add(newStr);
                    }

                    if (!visited.contains(newStr2) && !deads.contains(newStr2)) {
                        queue.add(newStr2);
                        visited.add(newStr2);
                    }
                }
            }

            step++;
        }
        return -1;
    }


    /**
     * 二叉树的BFS 作为参考
     */
    public void levelOrder(TreeNode tree) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        int level = 0;//层级
        while (!queue.isEmpty()) {
            int size = queue.size();//每一层的节点数
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                // treeNode.val
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            level++;
        }
    }
}
