package com.joyming.Custom;

/**
 * Q04 切分木棒
 * IQ：70　目标时间：10 分钟
 * 假设要把长度为 n 厘米的木棒切分为 1 厘米长的小段，但是 1 根木棒只能由 1 人切分，
 * 当木棒被切分为 3 段后，可以同时由 3 个人分别切分木棒（图 2）。
 * <p>
 * https://www.ituring.com.cn/figures/2017/ProgrammerPuzzle/07.d01z.014.png
 * <p>
 * 图 2　n ＝ 8，m ＝ 3 的时候
 * <p>
 * 求最多有 m 个人时，最少要切分几次。譬如 n ＝ 8，m＝ 3 时如图所示，切分 4 次就可以了。
 * <p>
 * 单选题
 * 当 n ＝ 20， m ＝ 3 时的最少切分次数为 _____ ；当 n ＝ 100， m ＝ 5 时的最少切分次数为 _____ 。
 * <p>
 * 作者：图灵教育
 * 链接：https://leetcode-cn.com/leetbook/read/interesting-algorithm-puzzles-for-programmers/90ach5/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class SplitStick {

    public int minSplitStick(int n, int m) {
        int currentNum = 1;
        currentNum = DFS(n, m, currentNum);
        return currentNum;
    }

    /**
     * Depth First Search
     * 递归, 自上而下
     *
     * @param n 木棒长度
     * @param m 当前最多人数
     * @param i 当前木棒的根数
     * @return 切分次数
     */
    private int DFS(int n, int m, int i) {
        if (i >= n) {
            //完成切分
            return 0;
        } else if (i < m) {
            //切一刀
            return 1 + DFS(n, m, i * 2);
        } else {
            //加上切分次数
            return 1 + DFS(n, m, i + m);
        }
    }

    /**
     * 自下而上
     * m个人黏合若干个1厘米的木棒，成为长度为n的木棒
     */
    public int minSplitStick2(int n, int m) {
        int count = 0;
        int current = 1;
        while (current < n) {
            current += Math.min(current, m);
            count++;
        }
        return count;
    }

    public int minSplitStick3(int n, int m) {
        int count = 0;
        int stickNum = n;
        while (stickNum > 1) {
            stickNum -= Math.min(stickNum / 2, m);
            count++;
        }
        return count;
    }

}
