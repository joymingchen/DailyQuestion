package com.joyming.Solution;

/**
 * 498.对角线遍历(Medium)
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * <p>
 * 输出:  [1,2,4,7,5,3,6,8,9]
 * <p>
 * 解释:
 * <p>
 * <p>
 * 说明:
 * 给定矩阵中的元素总数不会超过 100000 。
 */
public class Question498 {
    /**
     * 画图比较直观清晰
     */
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int i = 0, j = 0;
        int[] answer = new int[m * n];
        int index = 0;
        boolean isUp = true;
        answer[index++] = mat[i][j];
        while (i != n - 1 || j != m - 1) {
            if (isUp) {
                int nextI = i + 1;
                int nextJ = j - 1;
                if (nextJ >= 0 && nextJ < m && nextI >= 0 && nextI < n) {
                    j = nextJ;
                    i = nextI;
                } else {
                    //先右移
                    if (nextI < n) {
                        i = nextI;
                    } else {
                        //下移
                        if (j + 1 < m) {
                            j = j + 1;
                        }
                    }
                    isUp = false;
                }
            } else {
                int nextJ = j + 1;
                int nextI = i - 1;

                if (nextJ >= 0 && nextJ < m && nextI >= 0 && nextI < n) {
                    j = nextJ;
                    i = nextI;
                } else {
                    //先下移
                    if (nextJ < m) {
                        j = nextJ;
                    } else {
                        //右移
                        if (i + 1 < n) {
                            i = i + 1;
                        }
                    }
                    isUp = true;
                }
            }

            if (j >= 0 && j < m && i >= 0 && i < n) {
                answer[index++] = mat[j][i];
            }

        }
        return answer;
    }
}
