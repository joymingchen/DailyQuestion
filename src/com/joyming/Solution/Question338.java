package com.joyming.Solution;

/**
 * 338.比特位计数(Medium)
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * <p>
 * 示例 1:
 * 输入: 2
 * 输出: [0,1,1]
 * <p>
 * 示例 2:
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * <p>
 * 进阶:
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 */
public class Question338 {

    public int[] countBits(int num) {
        int[] answer = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            answer[i] = countOnes(i);
        }
        return answer;
    }

    /**
     * 按位与运算（&）的一个性质是：
     * 对于任意整数 xx，令 x=x&(x−1)，该运算将 x 的二进制表示的最后一个 1 变成 0。
     * 因此，对 x 重复该操作，直到 x 变成 0，则操作次数即为 x 的「一比特数」。
     */
    public int countOnes(int x) {
        int ones = 0;
        while (x > 0) {
            x &= (x - 1);
            ones++;
        }
        return ones;
    }

    /**
     * 动态规划
     */
    public int[] countBits2(int num) {
        int[] answer = new int[num + 1];
        int j = 0;
        for (int i = 1; i <= num; i++) {
            if((i & (i - 1)) == 0){
                j = i;
            }
            answer[i] = answer[i - j] + 1;
        }
        return answer;
    }
}
