package com.joyming.Solution;

/**
 * 2698. 求一个整数的惩罚数
 * 给你一个正整数 n ，请你返回 n 的 惩罚数 。
 * <p>
 * n 的 惩罚数 定义为所有满足以下条件 i 的数的平方和：
 * <p>
 * 1 <= i <= n
 * i * i 的十进制表示的字符串可以分割成若干连续子字符串，且这些子字符串对应的整数值之和等于 i 。
 * <p>
 * <p>
 * 示例 1：
 * 输入：n = 10
 * 输出：182
 * 解释：总共有 3 个整数 i 满足要求：
 * - 1 ，因为 1 * 1 = 1
 * - 9 ，因为 9 * 9 = 81 ，且 81 可以分割成 8 + 1 。
 * - 10 ，因为 10 * 10 = 100 ，且 100 可以分割成 10 + 0 。
 * 因此，10 的惩罚数为 1 + 81 + 100 = 182
 * <p>
 * 示例 2：
 * 输入：n = 37
 * 输出：1478
 * 解释：总共有 4 个整数 i 满足要求：
 * - 1 ，因为 1 * 1 = 1
 * - 9 ，因为 9 * 9 = 81 ，且 81 可以分割成 8 + 1 。
 * - 10 ，因为 10 * 10 = 100 ，且 100 可以分割成 10 + 0 。
 * - 36 ，因为 36 * 36 = 1296 ，且 1296 可以分割成 1 + 29 + 6 。
 * 因此，37 的惩罚数为 1 + 81 + 100 + 1296 = 1478
 * <p>
 * <p>
 * 提示：
 * 1 <= n <= 1000
 */
public class Question2698 {

    public int punishmentNumber(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            int x = i * i;

            if (isMatch(x, i)) {
                answer += x;
            }
        }
        return answer;
    }

    private boolean isMatch(int x, int sum) {
        String str = String.valueOf(x);
        if (sum < 0) {
            return false;
        }
        if (x == sum) {
            return true;
        }
        for (int j = 1; j < str.length(); j++) {
            int left = Integer.parseInt(str.substring(0, j));
            int right = Integer.parseInt(str.substring(j));

            if (isMatch(right, sum - left)) {
                return true;
            }
        }
        return false;
    }

}
