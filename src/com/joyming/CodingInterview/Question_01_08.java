package com.joyming.CodingInterview;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 面试题 01.08. 零矩阵
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 * <p>
 * 示例 1：
 * 输入：
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * 输出：
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 * <p>
 * 示例 2：
 * 输入：
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * 输出：
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 */
public class Question_01_08 {

    public boolean setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        //行
        int[] row = new int[m];
        //列
        int[] column = new int[n];
        Arrays.fill(row, 1);
        Arrays.fill(column, 1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    //整行整列置零
                    row[i] = 0;
                    column[j] = 0;
                } else {
                    if (column[j] == 0 || row[i] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (column[j] == 0 || row[i] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        return false;
    }
}
